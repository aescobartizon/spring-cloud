package com.in28minutes.microservices.currencyconversionservice.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.in28minutes.microservices.currencyconversionservice.domain.CurrencyConversion;


/****if only there is a instance of currency-exchange-service put the url**/
//@FeignClient(name="currency-exchange-service",url="localhost:8000")


/** If thre are two or more instaces of currency-exchange is necessary to use ribbon to resolve the url and port**/
@FeignClient(name="currency-exchange-service")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	
	@GetMapping(value="/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retriveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);

}
