package com.icons.exceptions;


public class ClientExistsException extends RuntimeException
{
	private String message;

	public ClientExistsException() {
		super();
	}

	public ClientExistsException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

	@Override
	public String toString() {
		return String.format("ClientExistsException [message=%s]", message);
	}
	
}


