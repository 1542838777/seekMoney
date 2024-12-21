package com.example.seekmoney.service;

import com.alibaba.fastjson.JSON;
import com.example.seekmoney.MyApiClient;
import com.example.seekmoney.Product;
import com.example.seekmoney.service.user.LoginService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@Service
@Slf4j
@RequestMapping("/skill")
@Controller
public class SeckillService {
	private String token = "3cfa1c00-2c2a-46c5-8f95-097ca777b63a";
	public ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(44);

	@Autowired
	MyApiClient client;

	@GetMapping("/testGetList")
	@Scheduled(cron = "35 04 14 * * ?")
	private String testGetList() {
		log.info("测试 自动的token start");
		String s = client.seckillList(token, 3, 1);
		return s;
	}

	/*
		@Scheduled(cron = "20 51 11 * * ?")
		private void testVAlToken() {
			log.info("定时查看token >>>{}", token);
		}
	*/
	@Scheduled(cron = "10 59 13 * * ?")
	@GetMapping("/initToken")
	private void initToken() {
		String originToken = token;

		String lastesToken = loginService.loginReturnToken();
		try {
			String s = client.seckillList(lastesToken, 3, 1);
			if (s.contains("ok")) {
				token = lastesToken;
			}
		} catch (Exception e) {
			//既然无法正常使用，那就无需替换
			log.info("自动获取的token依然不对！");
		}

		log.info("手动调用初始化token----- originToken {}, now Token {}", originToken, token);
	}


	//每天13：50秒执行
	@Scheduled(cron = "30 59 13 * * ?")
	public void exceed() {
		System.out.println("执行了");
		sortAndSeek(null, 3, null);
//		sortAndSeek(null, 2,null);
//		sortAndSeek(null, 1,null);
	}

	public void sortAndSeek(String mockParam, int rush_config_id, Long mockLongCurrentTime) {
		String jsonResponse = null;
		if (mockParam == null) {
			jsonResponse = getKillList(rush_config_id, 1);
		} else {
			jsonResponse = mockParam;
		}
		try {
			long curSeconds = System.currentTimeMillis(); // 获取当前时间（秒）
			long subReduceMill = mockLongCurrentTime == null ? 0 : curSeconds - mockLongCurrentTime;
			// 使用 Jackson 解析 JSON

			List<Product> products = getAllProducts(jsonResponse, rush_config_id);
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
				for (int i = -7; i <= 16; i++) {
					waitAndPurchase(product, subReduceMill, i * 1000 - (new Random().nextInt(440) + 150));
				}


			}
			// 关闭线程池
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private String getKillList(int rush_config_id, int i) {
		return client.seckillList(token, rush_config_id, 1);
	}

	@Resource
	private LoginService loginService;


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
	private List<Product> getAllProducts(String jsonResponse, int rush_config_id) {
		List<Product> products = new ArrayList<>();

		// 使用 Jackson 解析 JSON
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = objectMapper.readTree(jsonResponse);
		JsonNode dataNode = rootNode.path("data").path("data");
		Integer last_page = rootNode.path("data").path("last_page").asInt();
		// 遍历商品数据
		dataNodeToConvertProducts(dataNode, products, rush_config_id);
		if (last_page == 1) {
			return products;
		}
		for (int i = 2; i <= last_page; i++) {
			jsonResponse = client.seckillList(token, rush_config_id, i);
			rootNode = objectMapper.readTree(jsonResponse);
			dataNode = rootNode.path("data").path("data");
			dataNodeToConvertProducts(dataNode, products, rush_config_id);
		}
		return products;
	}


	private void dataNodeToConvertProducts(JsonNode dataNode, List<Product> products, int rush_config_id) {
		for (JsonNode productNode : dataNode) {
			long start_time = productNode.path("start_time").asLong();
			int id = productNode.path("id").asInt();
			// 添加到产品列表
			products.add(new Product(id, start_time, rush_config_id));
		}
	}

	private long getCurrentTime(Long mockLongCurrentTime) {
		if (mockLongCurrentTime == null) {
			return System.currentTimeMillis(); // 获取当前时间（秒）
		}
		return System.currentTimeMillis() - mockLongCurrentTime;
	}

	// 商品类

	// 模拟商品抢购
	public void purchaseProduct(Product product) {
		try {
			String invokeAddOrderTime = new SimpleDateFormat("HH:mm:ss.SSS").format(new Date());
			String can = new SimpleDateFormat("HH:mm:ss.SSS").format(product.getStartTime());
			if (product.getFinished()) {
				log.info("已经售完,停止addOrder {}", product.showId());
				return;
			}
			String s = client.addOrder(token, product.getId() + "");
			String currr = new SimpleDateFormat("HH:mm:ss.SSS").format(new Date());
			log.info("下单结果>>>{} --下单>>{}--可下单>>>{} --当前>>{}--{}", s.substring(0, 26), invokeAddOrderTime, can, currr, product.showId());
			if (s.contains("\"msg\":\"ok\"")) {
				System.out.println("成功抢到商品--" + product.showCanOrderAndNow());
				if (product.getFinished()) {
					System.out.println("已经finished但还是成功抢到商品--" + product.showId());
				}
			}
			if (s.contains("\"msg\":\"商品已被秒杀。\"")) {
				log.info(product.showId() + "商品已finished");
				product.setFinished(true);
			}
		} catch (Exception e) {
			System.out.println("异常" + e);
		}
	}

	public static void main(String[] args) {
		System.out.println("{\"code\":105,\"msg\":\"ok\"。\",\"data\":{\"today_seckill_time1\":0,\"user_seckill_times\":0,\"mobile\":\"13896947245\"}".substring(0, 23));
	}

}