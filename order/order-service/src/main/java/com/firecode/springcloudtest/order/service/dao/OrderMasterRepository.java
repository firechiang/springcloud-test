package com.firecode.springcloudtest.order.service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firecode.springcloudtest.order.common.domain.OrderMaster;

/**
 * Created by 廖师兄
 * 2017-12-10 16:11
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}
