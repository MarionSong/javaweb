package com.jt.common.vo;
/**
 * 自定义异常编写的目的就是为了
 * 更加准确的定位你的业务以及错误.
 */
public class ServiceException 
        extends RuntimeException {
	
	private static final long serialVersionUID = 7793296502722655579L;
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
		// TODO Auto-generated constructor stub
	}

	public ServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
     
}
