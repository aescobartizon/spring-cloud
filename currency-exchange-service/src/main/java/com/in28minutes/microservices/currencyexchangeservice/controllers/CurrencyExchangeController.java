package com.in28minutes.microservices.currencyexchangeservice.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.currencyexchangeservice.conf.Configuration;
import com.in28minutes.microservices.currencyexchangeservice.domain.ExchangeValue;
import com.in28minutes.microservices.currencyexchangeservice.exception.ExchangeValueNotFoundException;
import com.in28minutes.microservices.currencyexchangeservice.repositories.ExchangeValueRepository;

import lombok.Getter;
import lombok.Setter;

@RestController
public class CurrencyExchangeController extends AbstractCurrencyExchangeController{
	
	@Autowired
	@Getter
	Configuration configuration;
	
	@Autowired
	@Getter
	@Setter
	ExchangeValueRepository exchangeValueRepository;
	
	private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
	
	@GetMapping(value="/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retriveExchangeValue(@PathVariable String from, @PathVariable String to) {
		
		ExchangeValue exchangeValue = getExchangeValueRepository().getExchaValue(from, to);
		
		if(exchangeValue!=null) {
			exchangeValue.setPort(Integer.parseInt(getEnviroment().getProperty("local.server.port")));
			logger.info("{}",exchangeValue);
		} else {
			throw new ExchangeValueNotFoundException("Exchange value not found");
		}
		
		return exchangeValue;
	}

}
