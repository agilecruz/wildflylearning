package com.wildfly.exception;

public class NoSuchSeatException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public NoSuchSeatException(String message) {
		super(message);
	}
}
