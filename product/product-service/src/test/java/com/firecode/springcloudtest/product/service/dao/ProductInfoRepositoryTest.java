package com.firecode.springcloudtest.product.service.dao;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.firecode.springcloudtest.product.common.domain.ProductInfo;
import com.firecode.springcloudtest.product.service.ProductApplicationTests;

/**
 * Created by 廖师兄
 * 2017-12-09 21:32
 */
public class ProductInfoRepositoryTest extends ProductApplicationTests {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void findByProductStatus() throws Exception {
        List<ProductInfo> list = productInfoRepository.findByProductStatus(0);
        System.err.println(list);
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void findByProductIdIn() throws Exception {
        List<ProductInfo> list = productInfoRepository.findByProductIdIn(Arrays.asList("157875196366160022", "157875227953464068"));
        System.err.println(list);
        Assert.assertTrue(list.size() > 0);
    }

}