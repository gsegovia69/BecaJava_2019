package com.demo.prueba;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

@Log
@Controller
@Getter
@Setter
@ConfigurationProperties(prefix = "atrib.variable")
public class HomeController {

	private String atributo = "Hola mundo";
	
	@GetMapping("/")
	public String home() {
		log.info("Atributo: "+ atributo);
		return "home";
	}
}
