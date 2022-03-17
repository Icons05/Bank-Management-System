package com.icons.exceptions;

import org.springframework.http.HttpStatus;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ClientExceptionController 
{

	@ControllerAdvice
	public class ProductExceptionController
	{
		@ExceptionHandler(value=ClientNotFoundException.class)
		public ResponseEntity<Object> exception(ClientNotFoundException e)
		{
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

		@ExceptionHandler(value=ClientExistsException.class)
		public ResponseEntity<Object> exception(ClientExistsException e)
		{
			return new ResponseEntity<>(e.getMessage(), HttpStatus.FOUND);
		}
	}
}
