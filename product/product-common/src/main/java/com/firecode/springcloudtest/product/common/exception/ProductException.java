package com.firecode.springcloudtest.product.common.exception;

import com.firecode.springcloudtest.product.common.enums.ResultEnum;

/**
 * Created by 廖师兄
 * 2017-12-10 22:59
 */
@SuppressWarnings("unused")
public class ProductException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private Integer code;

    public ProductException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
