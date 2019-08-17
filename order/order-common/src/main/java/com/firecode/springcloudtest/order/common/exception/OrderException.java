package com.firecode.springcloudtest.order.common.exception;

import com.firecode.springcloudtest.order.common.enums.ResultEnum;

/**
 * Created by 廖师兄
 * 2017-12-10 17:27
 */
@SuppressWarnings("unused")
public class OrderException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private Integer code;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
