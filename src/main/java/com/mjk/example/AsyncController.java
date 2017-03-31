package com.mjk.example;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AsyncController {
	
	@Autowired
	ServiceOne serviceOne;
	
    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncController.class);

    
	@RequestMapping("/async")
	Photo[] asyncCall() throws InterruptedException, ExecutionException {
		Future<Photo[]> results = serviceOne.test("Test123");
		while(!results.isDone()){
			Thread.sleep(10000L);
		}
		return results.get();
		
	}
	
}
