package com.imooc.appoint.exception;
//预约义务异常
public class AppointException extends RuntimeException{
	public AppointException(String message) {
		super(message);
	}

	public AppointException(String message, Throwable cause) {
		super(message, cause);
	}
}
