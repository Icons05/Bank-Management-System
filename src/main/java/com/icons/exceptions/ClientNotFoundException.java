package com.icons.exceptions;

public class ClientNotFoundException extends RuntimeException
{
	private String message;

	public ClientNotFoundException() {
		super();
	}

	public ClientNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

	@Override
	public String toString() {
		return String.format("ClientNotFoundException [message=%s]", message);
	}

}


