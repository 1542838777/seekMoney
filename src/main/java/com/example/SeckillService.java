package com.example;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
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
public class SeckillService {
	public ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(44);

	private static final int THREAD_POOL_SIZE = 512;
	@Autowired
	MyApiClient client;

	public void test() {
		System.out.println("ttest");
	}

	//每天13：50秒执行
	@Scheduled(cron = "0 58 13 * * ?")
	public void exceed() {
		System.out.println("执行了");
		sortAndSeek(null, null);
}

//	@Scheduled(cron = "0 48 13 * * ?")
	public void tes1t() {
		System.out.println("11执行了");

		for (int i = 0; i < 17; i++) {

			// 提交抢购任务到线程池
			//wait
			// 安排购买任务
			scheduledExecutorService.schedule(() -> {
//				purchaseProduct(product);
				System.out.println(1);
			}, i, TimeUnit.MILLISECONDS);

		}
		sortAndSeek(null, null);
	}

	public void exceedvMock() {
		System.out.println("V2执行了");
		sortAndSeek(null, null);
	}

	public void sortAndSeek(String mockParam, Long mockLongCurrentTime) {
		String jsonResponse = null;
		if (mockParam == null) {
			jsonResponse = client.seckillList(TOKEN, 1);
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

			List<Product> products = getAllProducts(jsonResponse);
			new ArrayList<>();


			// 按  StartTime 排序
			products.sort(Comparator.comparingLong(Product::getStartTime));
			System.out.println("Sorted products:" + JSON.toJSONString(products));

			// 按 StartTime 排序
			products.sort(Comparator.comparingLong(Product::getStartTime));


			for (Product product : products) {
				// 提交抢购任务到线程池
				for (int i = 1; i <=10 ; i++) {
					waitAndPurchase(product, subReduceMill, i*850);
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
		long waitTime = product.getStartTime() - currentMillis-preOrderMillis;

		if (waitTime > 0) {
			// 安排购买任务
			scheduledExecutorService.schedule(() -> {
//				purchaseProduct(product);
				System.out.println(1);
			}, 1000, TimeUnit.MILLISECONDS);

			System.out.println(product.showCanOrderAndNow() + " 在 " + waitTime + " 毫秒后欲将执行addOrder");
		} else {
			// 如果时间已经过了，立即购买
			purchaseProduct(product);
			System.out.println(product.showCanOrderAndNow() + "  无需等待立即购买 商品Id: ");
		}
	}

	@SneakyThrows
	private List<Product> getAllProducts(String jsonResponse) {
		List<Product> products = new ArrayList<>();

		// 使用 Jackson 解析 JSON
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = objectMapper.readTree(jsonResponse);
		JsonNode dataNode = rootNode.path("data").path("data");
		Integer last_page = rootNode.path("data").path("last_page").asInt();
		// 遍历商品数据
		dataNodeToConvertProducts(dataNode, products);
		if (last_page == 1) {
			return products;
		}
		for (int i = 2; i <= last_page; i++) {
			jsonResponse = client.seckillList(TOKEN, i);
			rootNode = objectMapper.readTree(jsonResponse);
			dataNode = rootNode.path("data").path("data");
			dataNodeToConvertProducts(dataNode, products);
		}
		return products;
	}

	private void dataNodeToConvertProducts(JsonNode dataNode, List<Product> products) {
		for (JsonNode productNode : dataNode) {
			long start_time = productNode.path("start_time").asLong();
			int id = productNode.path("id").asInt();
			// 添加到产品列表
			products.add(new Product(id, start_time));
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

		public Product(int id, long starttime) {
			this.id = id;
			this.startTime = starttime * 1000;
		}

		public int getId() {
			return id;
		}


		public long getStartTime() {
			return startTime;
		}

		public String showCanOrderAndNow() {
			return showId() + "--当前时间:" + new SimpleDateFormat("HH:mm:ss.SSS").format(new Date()) + "--商品可下单时间:" + new SimpleDateFormat("HH:mm:ss.SSS").format(startTime);
		}

		public String showId() {
			return "--商品Id:" + id;
		}

	}

	// 模拟商品抢购
	public void purchaseProduct(Product product) {
		try {
			System.out.println("really调用addOrder--" + product.showCanOrderAndNow());        // 这里可以添加具体的购买逻辑)
			String s = client.addOrder(TOKEN, product.getId() + "");
			System.out.println("addorder结果》》》{}" + s);
			if (s.contains("\"msg\":\"ok\"")) {
				System.out.println("成功抢到商品--" + product.showCanOrderAndNow());
			}
		} catch (Exception e) {
			System.out.println("异常" + e);
		}
	}

}