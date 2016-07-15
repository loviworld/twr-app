package com.lovi.twr.exception;

public class DataAccessException extends Exception{
	private static final long serialVersionUID = -7206167215849013043L;

	public DataAccessException() {
	}
	
	public DataAccessException(Throwable throwable){
		super(throwable);
	}
}
