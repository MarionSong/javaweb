package com.jt.common.vo;

public class ServiceException extends RuntimeException{
	/**
	 * 自定义异常编写的目的
	 */
	private static final long serialVersionUID = 3121101706925181234L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

}
