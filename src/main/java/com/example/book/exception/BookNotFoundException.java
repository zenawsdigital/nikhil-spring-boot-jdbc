package com.example.book.exception;

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
