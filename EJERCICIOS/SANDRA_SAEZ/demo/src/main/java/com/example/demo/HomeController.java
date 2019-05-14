package com.example.demo;

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
@ConfigurationProperties(prefix="prueba1.prueba")
public class HomeController {
	
	private String atributo ="Hola mundo";
	
	@GetMapping("/")
	public String home() {
		
	
		log.info("atributo:" + atributo);
	
		return "home";
		
	}
	

}
