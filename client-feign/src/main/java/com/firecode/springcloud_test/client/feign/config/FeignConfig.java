package com.firecode.springcloud_test.client.feign.config;

import org.springframework.context.annotation.Bean;

import feign.Logger;

/**
 * Feign的配置类（注意：当前类不能加@Configuration注解，加了就会变成全局的配置，因为有父子上下文扫描的问题）
 * @author JIANG
 */
public class FeignConfig {
	
	/**
	 * 配置Feign的日志级别（注意：建议使用配置文件的方式配置）
	 * @return
	 */
	@Bean
	public Logger.Level level(){
		
		return Logger.Level.FULL;
	}

}
