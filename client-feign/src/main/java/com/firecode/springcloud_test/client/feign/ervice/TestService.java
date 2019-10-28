package com.firecode.springcloud_test.client.feign.ervice;

import org.springframework.cloud.openfeign.FeignClient;

import com.firecode.springcloud_test.client.feign.config.FeignConfig;

/**
 * test-service 是服务的名称，FeignConfig.class 是Feign的配置类（注意：配置类建议使用配置文件的方式配置）
 * 注意：这个服务是没有的，也就调不通
 * @author JIANG
 */
@FeignClient(name="test-service",configuration = FeignConfig.class)
public interface TestService {

}
