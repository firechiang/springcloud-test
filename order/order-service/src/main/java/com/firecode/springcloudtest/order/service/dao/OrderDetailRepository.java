package com.firecode.springcloudtest.order.service.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firecode.springcloudtest.order.common.domain.OrderDetail;

/**
 * Created by 廖师兄
 * 2017-12-10 16:12
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

	List<OrderDetail> findByOrderId(String orderId);
}
