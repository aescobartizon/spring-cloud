package com.in28minutes.microservices.netflixzuulapigatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient

/**
 * 
 * 
 * @author anescobar
 * To check zuul launch a call throwing the gateway format of url is :
 * http://localhost:{port zuul}/{application name}/{uri}
 * http://localhost:8100/currency-exchange/from/USD/to/INR/1000
 * http://localhost:8765/currency-conversion-service/currency-exchange/from/USD/to/INR/1000
 *
 */
public class NetflixZuulApiGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixZuulApiGatewayServerApplication.class, args);
	}
	
	
//	/**Configuration sleuth**/
//	@Bean
//	public AlwaysSampler defaultSample() {
//		return new AlwaysSampler();
//	}
}
