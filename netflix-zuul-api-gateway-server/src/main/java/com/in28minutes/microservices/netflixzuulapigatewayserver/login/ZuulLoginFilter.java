package com.in28minutes.microservices.netflixzuulapigatewayserver.login;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class ZuulLoginFilter extends ZuulFilter{
	
	private Logger logger = org.slf4j.LoggerFactory.getLogger(ZuulLoginFilter.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logger.info("request -> {} request uri -> {}",request, request.getRequestURI());
		
		return null;
	}

	@Override
	public String filterType() {
		
		// where the filter is excecute
		// pre post error
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
