package com.example.seekmoney;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	private int id;
	private long startTime;
	private int rushConfigId;


	private Boolean finished = false;
	//grabbed
	private Boolean grabbed = false;


	public Long getWaitTime() {
		return waitTime;
	}

	Long waitTime;



	public void setWaitTime(Long waitTime) {
		this.waitTime = waitTime;
	}

	public Boolean getGrabbed() {
		return grabbed;
	}

	public void setGrabbed(Boolean grabbed) {
		this.grabbed = grabbed;
	}

	public Product(int id, long starttime, int rushConfigId) {
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
		return "--Id:" + id + "--configId--" + rushConfigId ;
	}

	public Boolean getFinished() {
		return finished;
	}

	public void setFinished(Boolean finished) {
		this.finished = finished;
	}

}
