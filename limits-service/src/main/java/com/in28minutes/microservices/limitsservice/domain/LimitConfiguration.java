package com.in28minutes.microservices.limitsservice.domain;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LimitConfiguration implements Serializable{

	protected LimitConfiguration() {
		
	}
	
	public LimitConfiguration(int maximum, int minimum) {
		super();
		this.maximum = maximum;
		this.minimum = minimum;
	}

	private static final long serialVersionUID = 6294421806033168008L;
	
	private int maximum;
	
	private int minimum;
	

}
