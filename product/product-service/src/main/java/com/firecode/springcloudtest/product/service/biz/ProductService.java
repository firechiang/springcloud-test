package com.firecode.springcloudtest.product.service.biz;

import java.util.List;

import com.firecode.springcloudtest.product.common.DecreaseStockInput;
import com.firecode.springcloudtest.product.common.ProductInfoOutput;
import com.firecode.springcloudtest.product.common.domain.ProductInfo;

/**
 * Created by 廖师兄
 * 2017-12-09 21:57
 */
public interface ProductService {

    /**
     * 查询所有在架商品列表
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询商品列表
     * @param productIdList
     * @return
     */
    List<ProductInfoOutput> findList(List<String> productIdList);

    /**
     * 扣库存
     * @param decreaseStockInputList
     */
    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);
}
