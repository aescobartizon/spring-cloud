package com.in28minutes.microservices.limitsservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.in28minutes.microservices.limitsservice.configuration.Configuration;

import lombok.Getter;

public class AbstractLimitsConfigurationController {

	@Autowired
	@Getter
	protected Configuration configuration;
}
