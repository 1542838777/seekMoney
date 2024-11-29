package com.example;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.example.consist.Commen.TOKEN;


@Service
@Slf4j
public class SeckillService {
	public ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(44);

	private static final int THREAD_POOL_SIZE = 512;
	@Autowired
	MyApiClient client;

	public void test() {
		System.out.println("ttest");
	}

	//每天13：50秒执行
	@Scheduled(cron = "35 59 13 * * ?")
	public void exceed() {
		System.out.println("执行了");
		sortAndSeek(null, 3,null);
//		sortAndSeek(null, 2,null);
//		sortAndSeek(null, 1,null);
	}





	public void sortAndSeek(String mockParam,int rush_config_id, Long mockLongCurrentTime) {
		String jsonResponse = null;
		if (mockParam == null) {
			jsonResponse = client.seckillList(TOKEN, rush_config_id,1);
		} else {
			jsonResponse = mockParam;
		}
		try {
			long curSeconds = System.currentTimeMillis(); // 获取当前时间（秒）
			long subReduceMill = mockLongCurrentTime == null ? 0 : curSeconds - mockLongCurrentTime;
			// 使用 Jackson 解析 JSON
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode rootNode = objectMapper.readTree(jsonResponse);
			JsonNode dataNode = rootNode.path("data").path("data");

			List<Product> products = getAllProducts(jsonResponse,rush_config_id);
			new ArrayList<>();


			// 按  StartTime 排序
			products.sort(Comparator.comparingLong(Product::getStartTime));
			System.out.println("Sorted products:" + JSON.toJSONString(products));

			// 按 StartTime 排序
			products.sort(Comparator.comparingLong(Product::getStartTime));


			for (Product product : products) {
				// 提交抢购任务到线程池
				//提前20毫秒

				//提前1s ------6s
				for (int i = 1; i <= 8; i++) {
					waitAndPurchase(product, subReduceMill, i * 1000 );
				}
				//捡漏1s-13s
				for (int i = 3; i <= 6; i++) {
					waitAndPurchase(product, subReduceMill, -i * 1000);
				}

			}
			// 关闭线程池
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	public void sortAndSeekv2(String mockParam, Long mockLongCurrentTime) {
//		String jsonResponse = null;
//		if (mockParam == null) {
//			jsonResponse = client.seckillListv2(TOKEN, 1);
//		} else {
//			jsonResponse = mockParam;
//		}
//		try {
//			long curSeconds = System.currentTimeMillis(); // 获取当前时间（秒）
//			long subReduceMill = mockLongCurrentTime == null ? 0 : curSeconds - mockLongCurrentTime;
//			// 使用 Jackson 解析 JSON
//			ObjectMapper objectMapper = new ObjectMapper();
//			JsonNode rootNode = objectMapper.readTree(jsonResponse);
//			JsonNode dataNode = rootNode.path("data").path("data");
//
//			List<Product> products = getAllProducts(jsonResponse);
//			new ArrayList<>();
//
//
//			// 按  StartTime 排序
//			products.sort(Comparator.comparingLong(Product::getStartTime));
//			System.out.println("Sorted products:" + JSON.toJSONString(products));
//
//			// 按 StartTime 排序
//			products.sort(Comparator.comparingLong(Product::getStartTime));
//
//			ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
//
//			for (Product product : products) {
//				// 提交抢购任务到线程池
//				executorService.submit(() -> {
//					waitAndPurchase(product, subReduceMill, 120);
//				});
//				executorService.submit(() -> {
//					waitAndPurchase(product, subReduceMill, 40);
//				});
//				executorService.submit(() -> {
//					waitAndPurchase(product, subReduceMill, 0);
//				});
//				executorService.submit(() -> {
//					waitAndPurchase(product, subReduceMill, 20);
//				});
//
//			}
//			// 关闭线程池
//			executorService.shutdown();
//			try {
//				// 等待所有任务完成或超时
//				if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
//					executorService.shutdownNow(); // 超时后强制关闭
//				}
//			} catch (InterruptedException e) {
//				executorService.shutdownNow();
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}


	private void waitAndPurchase(Product product, long subReduceMill, long preOrderMillis) {
		//wait
		long currentMillis = getCurrentTime(subReduceMill);
		long waitTime = product.getStartTime() - currentMillis - preOrderMillis;

		if (waitTime > 0) {
			// 安排购买任务
			scheduledExecutorService.schedule(() -> {
				purchaseProduct(product);
			}, waitTime, TimeUnit.MILLISECONDS);

			System.out.println(product.showCanOrderAndNow() + " pre-在 " + waitTime + " 毫秒后欲将执行addOrder");
		} else {
			scheduledExecutorService.schedule(() -> {
				purchaseProduct(product);
			}, waitTime, TimeUnit.MILLISECONDS);
			System.out.println(product.showCanOrderAndNow() + " after-在 " + waitTime + " 毫秒后欲将执行addOrder");

		}
	}

	@SneakyThrows
	private List<Product> getAllProducts(String jsonResponse,int rush_config_id) {
		List<Product> products = new ArrayList<>();

		// 使用 Jackson 解析 JSON
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = objectMapper.readTree(jsonResponse);
		JsonNode dataNode = rootNode.path("data").path("data");
		Integer last_page = rootNode.path("data").path("last_page").asInt();
		// 遍历商品数据
		dataNodeToConvertProducts(dataNode, products,rush_config_id);
		if (last_page == 1) {
			return products;
		}
		for (int i = 2; i <= last_page; i++) {
			jsonResponse = client.seckillList(TOKEN, rush_config_id,i);
			rootNode = objectMapper.readTree(jsonResponse);
			dataNode = rootNode.path("data").path("data");
			dataNodeToConvertProducts(dataNode, products,rush_config_id);
		}
		return products;
	}

	private void dataNodeToConvertProducts(JsonNode dataNode, List<Product> products,int rush_config_id) {
		for (JsonNode productNode : dataNode) {
			long start_time = productNode.path("start_time").asLong();
			int id = productNode.path("id").asInt();
			// 添加到产品列表
			products.add(new Product(id, start_time,rush_config_id));
		}
	}

	private long getCurrentTime(Long mockLongCurrentTime) {
		if (mockLongCurrentTime == null) {
			return System.currentTimeMillis(); // 获取当前时间（秒）
		}
		return System.currentTimeMillis() - mockLongCurrentTime;
	}

	// 商品类
	static class Product {
		private int id;
		private long startTime;
		private int rushConfigId;

		public Product(int id, long starttime,int rushConfigId) {
			this.id = id;
			this.startTime = starttime * 1000;
			this.rushConfigId = rushConfigId;
		}

		public int getId() {
			return id;
		}


		public long getStartTime() {
			return startTime;
		}

		public String showCanOrderAndNow() {
			return showId() + "--当前:" + new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()) + "--商品可下单:" + new SimpleDateFormat("HH:mm:ss.SSS").format(startTime);
		}

		public String showId() {
			return "--Id:" + id +"--configId--"+ rushConfigId;
		}

	}

	// 模拟商品抢购
	public void purchaseProduct(Product product) {
		try {
			System.out.println("really调用addOrder--" + product.showCanOrderAndNow());        // 这里可以添加具体的购买逻辑)
			String invokeAddOrderTime = new SimpleDateFormat("HH:mm:ss.SSS").format(new Date());
			String can =  new SimpleDateFormat("HH:mm:ss.SSS").format(product.getStartTime());
			String s = client.addOrder(TOKEN, product.getId() + "");
			String currr = new SimpleDateFormat("HH:mm:ss.SSS").format(new Date());
			log.info("下单结果>>>{} --下单调用时间>>{}--商品可下单时间>>>{} --当前时间>>{}",s,invokeAddOrderTime,can,currr);
			if (s.contains("\"msg\":\"ok\"")) {
				System.out.println("成功抢到商品--" + product.showCanOrderAndNow());
			}
		} catch (Exception e) {
			System.out.println("异常" + e);
		}
	}

}