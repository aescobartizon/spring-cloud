package com.in28minutes.microservices.currencyexchangeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExchangeValueNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ExchangeValueNotFoundException(String message) {
		super(message);
	}
}
