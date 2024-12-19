package com.example.seekmoney;

import com.dtflys.forest.springboot.annotation.ForestScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan(basePackages = {"com.example"})
@ForestScan(basePackages = "com.example")
@EnableScheduling
@SpringBootApplication(scanBasePackages = "com.example.seekmoney.service.SeckillService")


public class SeekMoneyApplication {

	public static void main(String[] args) {
		System.out.println(1);
		SpringApplication.run(SeekMoneyApplication.class, args);
	}

}
