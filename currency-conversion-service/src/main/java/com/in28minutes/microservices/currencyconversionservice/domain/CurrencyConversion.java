package com.in28minutes.microservices.currencyconversionservice.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class CurrencyConversion implements Serializable{

	protected CurrencyConversion() {
		super();
	}
	
	public CurrencyConversion(Long id, String from, String to, BigDecimal conversionMultiple, int port,
			BigDecimal quantity) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.port = port;
		this.quantity = quantity;
	}

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String from;

	private String to;
	
	private BigDecimal conversionMultiple;
	
	private int port;
	
	private BigDecimal quantity;
}
