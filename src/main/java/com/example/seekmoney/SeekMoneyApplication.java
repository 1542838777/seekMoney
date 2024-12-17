package com.example.seekmoney;

import com.example.service.SeckillService;
import com.dtflys.forest.springboot.annotation.ForestScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})
@ForestScan(basePackages = "com.example")
@EnableScheduling
public class SeekMoneyApplication {
@Autowired
SeckillService service;

	public static void main(String[] args) {
		System.out.println(1);
		SpringApplication.run(SeekMoneyApplication.class, args);
	}

}
