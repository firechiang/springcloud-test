package com.firecode.springcloud_test.loadbalan.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
// 全局配置负载均衡策略
@RibbonClients(defaultConfiguration = RibbonConfig.class)
public class RibbonTest {
	
	@Autowired
	private RestTemplate restTemplate1;
	
	/**
	 * 自动负载均衡（注意：请求地址直接写成服务名称即可）
	 * @return
	 */
	@GetMapping("/bizServiceName1")
	public String bizServiceList1() {
		ResponseEntity<String> response = restTemplate1.getForEntity("http://user-service/serviceName", String.class);
		return response.getBody();
	}

}
