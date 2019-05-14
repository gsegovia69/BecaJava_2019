package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		  final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

		 
		    logger.info("Entering application.");

		 
		    logger.info("Exiting application.");
		    SpringApplication.run(DemoApplication.class, args);
		  }
}
