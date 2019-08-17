package com.firecode.springcloudtest.gatewayzuul.exception;

/**
 * Created by 廖师兄
 * 2018-03-11 23:56
 */
public class RateLimitException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RateLimitException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RateLimitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public RateLimitException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public RateLimitException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public RateLimitException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
