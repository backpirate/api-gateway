package com.sa.gd.apigateway.zuulFilter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ErrorFilter extends ZuulFilter{

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		HttpServletResponse response=RequestContext.getCurrentContext().getResponse();
		System.out.println("Response status : "+response.getStatus());
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "Error";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}
	
}
