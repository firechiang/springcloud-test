package com.firecode.springcloudtest.product.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.firecode.springcloudtest.product.common.DecreaseStockInput;
import com.firecode.springcloudtest.product.common.ProductInfoOutput;

//import org.springframework.cloud.netflix.feign.FeignClient;


/**
 * 注意：加了 @RequestBody 注解一定要用POST请求，否则会报错
 * Created by 廖师兄
 * 2017-12-10 21:04
 */
@FeignClient(name = "product", fallback = ProductClient.ProductClientFallback.class)
public interface ProductClient {

    @PostMapping("/listForOrder")
    List<ProductInfoOutput> listForOrder(@RequestBody List<String> productIdList);

    @PostMapping("/decreaseStock")
    void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);
    
    @GetMapping("/sleuth_test")
    String sleuth_test();

    @Component
    static class ProductClientFallback implements ProductClient {

        @Override
        public List<ProductInfoOutput> listForOrder(List<String> productIdList) {
            return null;
        }

        @Override
        public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {

        }
        
        public String sleuth_test(){
        	
        	return null;
        }
    }
}
