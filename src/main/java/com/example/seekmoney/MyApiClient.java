package com.example.seekmoney;

import com.dtflys.forest.annotation.*;

@BaseRequest(
		)
public interface MyApiClient {
	@Get(url = "https://tp.tofur.com/addons/shopro/seckill/list?rush_config_id={rush_config_id}&page={pageNumber}")
	String seckillList(@Header("Token") String token,@Var("rush_config_id")int rush_config_id, @Var("pageNumber") int pageNumber);
//	@Get(url = "https://tp.tofur.com/addons/shopro/seckill/list?rush_config_id=2&page={pageNumber}")
//	String seckillListv2(@Header("Token") String token,@Var("pageNumber") int pageNumber);
	@Post("https://tp.tofur.com/addons/shopro/seckill/addOrder")
	@LogEnabled(logRequest = true, logResponseContent = false)
	String addOrder(@Header("Token") String token , @JSONBody("id") String idString);
	@Post("https://tp.tofur.com/addons/shopro/user/accountLogin")
	@LogEnabled(logRequest = true, logResponseContent = false)
	String accountLogin(@JSONBody("account") String account , @JSONBody("device_id") String device_id , @JSONBody("password") String password);
}
