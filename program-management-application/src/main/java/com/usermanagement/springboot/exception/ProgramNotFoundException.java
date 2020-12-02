package com.usermanagement.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ProgramNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public ProgramNotFoundException(String message) {
		super(message);
	}

}
