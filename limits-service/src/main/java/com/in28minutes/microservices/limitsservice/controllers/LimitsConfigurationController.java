package com.in28minutes.microservices.limitsservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.limitsservice.domain.LimitConfiguration;

@RestController
public class LimitsConfigurationController extends AbstractLimitsConfigurationController{
	
	@GetMapping(value="/limits")
	public LimitConfiguration retrieveLimitsFromConfigurations() {
		return LimitConfiguration.builder().maximum(getConfiguration().getMaximum()).minimum(getConfiguration().getMinimum()).build(); 
	}
}
