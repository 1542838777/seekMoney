package com.example;

import com.dtflys.forest.annotation.*;

@BaseRequest(
		)
public interface MyApiClient {
	@Get(url = "https://tp.tofur.com/addons/shopro/seckill/list?rush_config_id=3&page={pageNumber}")
	String seckillList(@Header("Token") String token,@Var("pageNumber") int pageNumber);
//	@Get(url = "https://tp.tofur.com/addons/shopro/seckill/list?rush_config_id=2&page={pageNumber}")
//	String seckillListv2(@Header("Token") String token,@Var("pageNumber") int pageNumber);
	@Post("https://tp.tofur.com/addons/shopro/seckill/addOrder")
	String addOrder(@Header("Token") String token , @JSONBody("id") String idString);
}
