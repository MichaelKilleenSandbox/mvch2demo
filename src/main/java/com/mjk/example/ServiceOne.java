package com.mjk.example;

import java.util.ArrayList;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceOne {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceOne.class);

	private final RestTemplate restTemplate;

	public ServiceOne(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	@Async
	public Future<Photo[]> test(String user) throws InterruptedException {
		LOGGER.info("Looking up " + user);
		//String url = "https://httpbin.org/get";
		String url = "http://jsonplaceholder.typicode.com/photos";
		Photo[] results = restTemplate.getForObject(url, Photo[].class);
		// Artificial delay of 1s for demonstration purposes
		Thread.sleep(10000L);
		return new AsyncResult<>(results);
	}

}
