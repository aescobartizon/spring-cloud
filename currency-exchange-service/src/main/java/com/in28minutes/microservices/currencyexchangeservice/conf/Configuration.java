package com.in28minutes.microservices.currencyexchangeservice.conf;

import java.math.BigDecimal;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Setter;

@Component
@Setter
@ConfigurationProperties("currency.exchange")
public class Configuration {
	
	private String id;
	
	private String conversionMultiple;
	
	public Long getId() {
		return Long.parseLong(id);
	}
	
	public BigDecimal getConversionMultiple() {
		return new BigDecimal(conversionMultiple);
	}
}
