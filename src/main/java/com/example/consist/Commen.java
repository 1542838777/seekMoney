package com.example.consist;

import com.example.service.user.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class Commen {
	public static String token ;

	@Resource
	LoginService loginService;

	public static String getToken() {
		return token;
	}

	/*public void setToken() {
		// 在这里添加你的自动登录获取 token 的逻辑
		// 例如：通过 HTTP 请求获取 token
		String token = loginService.loginReturnToken("", "");
		this.token = token; // 返回获取到的 token
	}*/
}