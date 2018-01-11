package com.in28minutes.microservices.currencyconversionservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.currencyconversionservice.domain.CurrencyConversion;
import com.in28minutes.microservices.currencyconversionservice.feign.CurrencyExchangeServiceProxy;

import lombok.Getter;
import lombok.Setter;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	@Getter
	@Setter
	private Environment environment;
	
	@Autowired
	@Setter
	@Getter
	CurrencyExchangeServiceProxy currencyExchangeServiceProxy;
	
	@GetMapping(value="/currency-exchange/from/{from}/to/{to}/{quantity}")
	public CurrencyConversion retrieveCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		
		
		/**Code without feign*********************************************
		 * ***************************************************************
		 * ***************************************************************
		 *
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		ResponseEntity<CurrencyConversion> currencyConversion = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);

		CurrencyConversion response = currencyConversion.getBody();
		**/
		
		/**Code with feign proxy*******************************************
		 * 
		 */
		
		CurrencyConversion response = getCurrencyExchangeServiceProxy().retriveExchangeValue(from, to);

		return CurrencyConversion.builder().id(response.getId()).from(response.getFrom()).to(response.getTo())
				.conversionMultiple(response.getConversionMultiple()).quantity(quantity)
				.port(response.getPort())
				.totalCalculatedAmout(quantity.multiply(response.getConversionMultiple())).build();
	}

}
