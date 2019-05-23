package paramo.de.la.programacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.Getter;
import lombok.Setter;
import paramo.de.la.programacion.managers.UsuarioManager;
@Getter
@Setter
@Controller
@ConfigurationProperties(prefix = "rules.pepino")
public class RulesController {
	@Autowired
	private UsuarioManager usuManager;
	
	@GetMapping("/register")
	public String registro() {
		
		
		return "register";
	}

}