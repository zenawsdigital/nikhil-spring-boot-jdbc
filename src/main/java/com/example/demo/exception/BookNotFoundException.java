package com.example.demo.exception;

public class BookNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BookNotFoundException() {
		super();
	}
	
	public BookNotFoundException(String message, Throwable throwable) {
		super(message,throwable);
	}

}
