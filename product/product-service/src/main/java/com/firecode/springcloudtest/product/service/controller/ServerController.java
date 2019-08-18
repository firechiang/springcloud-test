package com.firecode.springcloudtest.product.service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 廖师兄
 * 2017-12-10 20:37
 */
@RefreshScope   // 配置自动刷新的注解（注意： 没有这个注解，配置信息是不会自动刷新的）
@RestController
public class ServerController {
	
	@Value("${config_test}")
	private String config_test;

	/**
	 * 获取config_test配置的值（注意：这个接口是为了测试Spring Cloud Bus配置自动刷新是否起作用）
	 * @return
	 */
    @GetMapping("/config_test")
    public String msg() {
    	
        return "config_test="+config_test;
    }
    
    @GetMapping("/sleuth_test")
    public String sleuthTest(){
    	
    	return "我是Product服务链路追踪测试所返回的结果";
    }
}
