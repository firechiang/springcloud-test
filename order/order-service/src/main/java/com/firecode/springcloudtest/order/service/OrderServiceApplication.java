package com.firecode.springcloudtest.order.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages={"com.firecode.springcloudtest.order.common.domain"})
@EnableJpaRepositories(basePackages={"com.firecode.springcloudtest.order.service.dao"})
@EnableFeignClients(basePackages = {"com.firecode.springcloudtest.product.api"})
public class OrderServiceApplication {
	
	public static void main(String[] args) {
		
		SpringApplication.run(OrderServiceApplication.class, args);
	}
}
