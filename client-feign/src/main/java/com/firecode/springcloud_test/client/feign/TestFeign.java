package com.firecode.springcloud_test.client.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 使用Feign调用百度（注意：服务名称一定要有，否则无法启动，还有一点这种方式并没有和Ribbon整合，它其实是脱离Ribbon的）
 * @author JIANG
 */
@FeignClient(name="test-feign",url = "https://wwww.baidu.com")
public interface TestFeign {
	
	@GetMapping("")
	public String get();
	
}
