package com.firecode.springcloudtest.product.service.biz;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.firecode.springcloudtest.product.common.domain.ProductCategory;
import com.firecode.springcloudtest.product.service.ProductApplicationTests;

/**
 * Created by 廖师兄
 * 2017-12-09 22:07
 */
public class CategoryServiceTest extends ProductApplicationTests {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<ProductCategory> list = categoryService.findByCategoryTypeIn(Arrays.asList(11, 22));
        System.err.println(list);
        Assert.assertTrue(list.size() > 0);
    }

}