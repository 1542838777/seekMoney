package com.example.service.user;

import com.example.MyApiClient;
import com.example.consist.Commen;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;

@Service
@Slf4j
public class LoginService {
	@Resource
	MyApiClient myApiClient;

	//login
	@SneakyThrows
	@Scheduled(cron = "10 59 13 * * ?")
	public String loginReturnToken() {
		String date = myApiClient.accountLogin("17764819218", "1730440189833104661" + ("" + new Random().nextInt(10)), "2222XYXY");
		// 使用 Jackson 解析 JSON
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = objectMapper.readTree(date);
		String token = String.valueOf(rootNode.path("data").path("token"));
		Commen.token = token;
		log.info("parse Token>>> {}",token);
		return  token;
	}
}
