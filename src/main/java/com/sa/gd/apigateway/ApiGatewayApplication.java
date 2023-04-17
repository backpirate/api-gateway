package com.sa.gd.apigateway;

import org.springframework.boot.SpringApplication;



import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.client.RestTemplate;

import com.sa.gd.apigateway.zuulFilter.ErrorFilter;
import com.sa.gd.apigateway.zuulFilter.PostFilter;
import com.sa.gd.apigateway.zuulFilter.PreFilter;
import com.sa.gd.apigateway.zuulFilter.RouteFilter;



@SpringBootApplication
@EnableEurekaClient
 @EnableZuulProxy 
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	@Bean
	public ServerCodecConfigurer serverCodecConfigurer() {
	   return ServerCodecConfigurer.create();
	}
	
	@Bean
	public ErrorFilter zuulErrorFilter()
	{
		return new ErrorFilter();
	}
	
	@Bean
	public PostFilter zuulPostFilter()
	{
		return new PostFilter();
	}
	
	@Bean
	public PreFilter zuulPreFilter()
	{
		return new PreFilter();
	}
	
	@Bean RouteFilter zuulRouteFilter()
	{
		return new RouteFilter();
	}
}
