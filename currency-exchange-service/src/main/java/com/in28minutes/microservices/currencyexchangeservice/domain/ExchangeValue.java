package com.in28minutes.microservices.currencyexchangeservice.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@Entity
public class ExchangeValue implements Serializable{
	
	private static final long serialVersionUID = 1L;

	protected ExchangeValue() {
		super();
	}
	
	public ExchangeValue(Long id, String from, String to, BigDecimal conversionMultiple, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.port=port;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "currency_from", updatable = true, nullable = false)
	private String from;
	
	@Column(name = "currency_to", updatable = true, nullable = false)
	private String to;
	
	private BigDecimal conversionMultiple;
	
	@Column(name = "port", updatable = true, nullable = true)
	private int port;
}
