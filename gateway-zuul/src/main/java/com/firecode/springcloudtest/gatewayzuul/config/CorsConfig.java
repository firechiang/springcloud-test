package com.firecode.springcloudtest.gatewayzuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * 跨域配置
 * Created by 廖师兄
 * 2018-03-11 23:04
 * C - Cross  O - Origin  R - Resource  S - Sharing
 */
@Configuration
public class CorsConfig {

	@Bean
	public CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();
        // 是否存在Cookie跨域
		config.setAllowCredentials(true);
		// 原始域
		config.setAllowedOrigins(Arrays.asList("*")); //http:www.a.com
		// 允许的头
		config.setAllowedHeaders(Arrays.asList("*"));
		// 允许的方法
		config.setAllowedMethods(Arrays.asList("*"));
		// 如果执行过一次跨域，在这个时间以内不再进行跨域检查
		config.setMaxAge(300l);
        // 
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}
}
