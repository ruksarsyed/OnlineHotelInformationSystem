package com.example.demo.exception;

public class BookResourceNotFoundException extends RuntimeException {

	public BookResourceNotFoundException(String message) {
		super(message);
	}
}