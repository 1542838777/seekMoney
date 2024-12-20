package com.example.seekmoney.service.user;

import com.example.seekmoney.MyApiClient;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
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
	public String loginReturnToken() {
		String date = myApiClient.accountLogin("13896947245", "1730440189833104661" + ("" + new Random().nextInt(10)), "aa258258");
		// 使用 Jackson 解析 JSON
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode rootNode = objectMapper.readTree(date);
		String token = String.valueOf(rootNode.path("data").path("token"));
		log.info("parse Token>>> {}",token);
		//去掉第一个字符，去掉最后面一个字符
		token = token.substring(1, token.length() - 1);
		return  token;
	}
}
