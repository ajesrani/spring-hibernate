package com.spring.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MyExceptionHandler {
	
	/*@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value=Exception.class)
	public String exceptionHandler()
	{
		return "errorPage";
	}*/
	
	@ExceptionHandler(value=MethodArgumentNotValidException.class)
	public ResponseEntity<?> exceptionHandler(MethodArgumentNotValidException e)
	{
		String message = e.getMessage();
		return new ResponseEntity<Object>(message, HttpStatus.BAD_REQUEST);
	}

}
