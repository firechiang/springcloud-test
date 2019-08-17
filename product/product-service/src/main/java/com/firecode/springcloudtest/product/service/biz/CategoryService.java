package com.firecode.springcloudtest.product.service.biz;

import java.util.List;

import com.firecode.springcloudtest.product.common.domain.ProductCategory;

/**
 * 类目
 * Created by 廖师兄
 * 2017-12-09 22:06
 */
public interface CategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
