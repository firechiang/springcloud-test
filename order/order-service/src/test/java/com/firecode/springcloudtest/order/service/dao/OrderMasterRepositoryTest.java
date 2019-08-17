package com.firecode.springcloudtest.order.service.dao;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.firecode.springcloudtest.order.common.domain.OrderMaster;
import com.firecode.springcloudtest.order.common.enums.OrderStatusEnum;
import com.firecode.springcloudtest.order.common.enums.PayStatusEnum;
import com.firecode.springcloudtest.order.service.OrderApplicationTests;

/**
 * Created by 廖师兄
 * 2017-12-10 16:13
 */
public class OrderMasterRepositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void testSave() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("1234567");
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerPhone("1886131241241");
        orderMaster.setBuyerAddress("慕课网总部");
        orderMaster.setBuyerOpenid("1101110");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setCreateTime(new Date());
        orderMaster.setUpdateTime(new Date());

        OrderMaster result = orderMasterRepository.save(orderMaster);
        System.err.println(result);
        Assert.assertTrue(result != null);
    }

}