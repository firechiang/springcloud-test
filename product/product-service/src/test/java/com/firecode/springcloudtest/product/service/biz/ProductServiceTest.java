package com.firecode.springcloudtest.product.service.biz;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.firecode.springcloudtest.product.common.DecreaseStockInput;
import com.firecode.springcloudtest.product.common.ProductInfoOutput;
import com.firecode.springcloudtest.product.common.domain.ProductInfo;
import com.firecode.springcloudtest.product.service.ProductApplicationTests;

/**
 * Created by 廖师兄
 * 2017-12-09 22:03
 */
public class ProductServiceTest extends ProductApplicationTests{

    @Autowired
    private ProductService productService;

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> list = productService.findUpAll();
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void findList() throws Exception {
        List<ProductInfoOutput> list = productService.findList(Arrays.asList("157875196366160022", "157875227953464068"));
        System.err.println(list);
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void decreaseStock() throws Exception {
        DecreaseStockInput decreaseStockInput = new DecreaseStockInput("157875196366160022", 2);
        System.err.println(decreaseStockInput);
        productService.decreaseStock(Arrays.asList(decreaseStockInput));
    }

}