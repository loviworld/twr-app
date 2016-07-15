package com.lovi.twr.exception;

public class ServiceException extends Exception{

	private static final long serialVersionUID = -5931196832370849494L;

	public ServiceException() {
	}
	
	public ServiceException(Throwable throwable){
		super(throwable);
	}
}
