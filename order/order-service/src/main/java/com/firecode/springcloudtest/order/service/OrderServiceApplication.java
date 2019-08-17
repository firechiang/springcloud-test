package com.firecode.springcloudtest.order.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//启用断路器
@EnableCircuitBreaker
@EntityScan(basePackages={"com.firecode.springcloudtest.order.common.domain"})
@EnableJpaRepositories(basePackages={"com.firecode.springcloudtest.order.service.dao"})
@EnableFeignClients(basePackages = {"com.firecode.springcloudtest.product.api"})
//@SpringCloudApplication包含 @SpringBootApplication，@EnableDiscoveryClient，@EnableCircuitBreaker这个三个注解
//@SpringCloudApplication 
public class OrderServiceApplication {
	
	public static void main(String[] args) {
		
		SpringApplication.run(OrderServiceApplication.class, args);
	}
}
