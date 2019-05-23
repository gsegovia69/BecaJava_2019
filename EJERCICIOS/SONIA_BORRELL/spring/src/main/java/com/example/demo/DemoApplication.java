package com.example.demo;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication(scanBasePackages={
		"com.example.demo"})
public class DemoApplication {
	
private static final Logger logger =LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		logger.info("Hola Mundo");
		SpringApplication.run(DemoApplication.class, args);
	}

}
