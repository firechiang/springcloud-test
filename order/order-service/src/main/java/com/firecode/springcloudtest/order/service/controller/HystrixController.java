package com.firecode.springcloudtest.order.service.controller;

import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

/**
 * Created by 廖师兄
 * 2018-03-18 20:23
 */
@SuppressWarnings("unused")
@RestController
// defaultFallback=断路器默认回调函数（注意：这个回调函数是当前类对象的）
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {

	//超时配置（name属性可在com.netflix.hystrix.HystrixCommandProperties类中找到）
	@HystrixCommand(commandProperties = {
	    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
	})
//  熔断配置	（name属性可在com.netflix.hystrix.HystrixCommandProperties类中找到）
//	@HystrixCommand(commandProperties = {
//	    @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  //设置开启熔断
//		@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),	//在滑动窗口中，至少有多少个请求，才可能触发断路
//		@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //休眠时间窗，休眠时间过了尝试调用一次服务（休眠时间过了只是半开状态），如果还不行继续休眠
//		@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),	//在滑动窗口中，到达该错误率（百分比），才可能触发断路
//	})
	// defaultFallback=断路器默认回调函数（注意：这个回调函数是当前类对象的）
	//@HystrixCommand(fallbackMethod="fallback")
	@GetMapping("/getProductInfoList")
	public String getProductInfoList(@RequestParam("number") Integer number) {
		if (number % 2 == 0) {
			return "success";
		}

		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject("http://127.0.0.1:8005/product/listForOrder",
				Arrays.asList("157875196366160022"),
				String.class);

//		throw new RuntimeException("发送异常了");
	}

	private String fallback() {
		return "太拥挤了, 请稍后再试~~";
	}

	private String defaultFallback() {
		return "默认提示：太拥挤了, 请稍后再试~~";
	}
}
