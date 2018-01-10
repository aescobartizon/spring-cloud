package com.in28minutes.microservices.currencyexchangeservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import lombok.Getter;
import lombok.Setter;

public class AbstractCurrencyExchangeController {

	
	@Autowired
	@Getter
	@Setter
	private Environment enviroment;
}
