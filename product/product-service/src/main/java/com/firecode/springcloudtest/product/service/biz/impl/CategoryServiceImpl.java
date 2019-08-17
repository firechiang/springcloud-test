package com.firecode.springcloudtest.product.service.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firecode.springcloudtest.product.common.domain.ProductCategory;
import com.firecode.springcloudtest.product.service.biz.CategoryService;
import com.firecode.springcloudtest.product.service.dao.ProductCategoryRepository;

/**
 * Created by 廖师兄
 * 2017-12-09 22:06
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
    	
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }
}
