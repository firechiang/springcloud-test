package com.firecode.springcloud_test.loadbalan.ribbon;

import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.IRule;
/**
 * 注意：当前类不要加@Configuration注解，因为它不能自动装配要引入装配
 */
public class RibbonConfig {
	
    @Bean
    public IRule ribbonRule() {
    	
        return new NacosWeightedRule();
    }

}
