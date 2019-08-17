package com.firecode.springcloudtest.gatewayzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 服务网关建议使用 Kong，有时间研究研究
 */
@SpringBootApplication
@EnableDiscoveryClient
//开始Zuul代理路由，访问方式 http://localhost:8083/{服务名称}/{接口名称}
//示例地址：http://localhost:8083/product/config_test
@EnableZuulProxy
public class GatewayZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayZuulApplication.class, args);
	}
	
//	动态刷新路由配置	
//  @ConfigurationProperties("zuul")
//  @RefreshScope
//  public ZuulProperties zuulProperties() {
//      return new ZuulProperties();
//  }
}
