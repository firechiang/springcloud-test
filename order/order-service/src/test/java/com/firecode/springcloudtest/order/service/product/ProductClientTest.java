package com.firecode.springcloudtest.order.service.product;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.firecode.springcloudtest.order.service.OrderApplicationTests;
import com.firecode.springcloudtest.product.api.ProductClient;
import com.firecode.springcloudtest.product.common.ProductInfoOutput;

public class ProductClientTest extends OrderApplicationTests {
	
	@Autowired
	private ProductClient productClient;
	
    /**
     * 查询所有商品
     * @return
     */
	@Test
    public void products() {
    	List<ProductInfoOutput> productInfoList = productClient.listForOrder(Arrays.asList("157875196366160022"));
    	System.err.println(productInfoList);
    }

}
