package com.in28minutes.microservices.currencyexchangeservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.currencyexchangeservice.conf.Configuration;
import com.in28minutes.microservices.currencyexchangeservice.domain.ExchangeValue;

import lombok.Getter;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	@Getter
	Configuration configuration;
	
	@GetMapping(value="/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retriveExchangeValue(@PathVariable String from, @PathVariable String to) {
		return ExchangeValue.builder().from(from).to(to).id(getConfiguration().getId()).conversionMultiple(getConfiguration().getConversionMultiple()).build();
	}

}
