package com.spring;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;



@Getter
@Setter
@Log
@Controller
@ConfigurationProperties(prefix="home.controller")
public class HomeController {
	
	private String atributo = "Hola Mundo";

	
	@GetMapping("/")
	public String home() {
		log.info("Atributo " + atributo);
		return "home";
	}
	
	 
}
