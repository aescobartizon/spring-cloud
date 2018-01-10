package com.in28minutes.microservices.currencyconversionservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.currencyconversionservice.domain.CurrencyConversion;

import lombok.Getter;
import lombok.Setter;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	@Getter
	@Setter
	private Environment environment;
	
	@GetMapping(value="/currency-exchange/from/{from}/to/{to}/{quantity}")
	public CurrencyConversion retrieveCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		return CurrencyConversion.builder()
				.id(1L)
				.from(from)
				.to(to)
				.conversionMultiple( new BigDecimal(65))
				.quantity(quantity).build();
	}

}
