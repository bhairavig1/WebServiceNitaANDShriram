package com.webservice.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class WebserviceConsumerNitaandShriramApplication {

	public static void main(String[] args) 
	{
		System.out.println("Consumer project Start");
		SpringApplication.run(WebserviceConsumerNitaandShriramApplication.class, args);
	}

	@Bean
	public RestTemplate rt()
	{
		RestTemplate rr= new RestTemplate();
		
		return rr;
		
	}
}
