package paramo.de.la.programacion.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UsuarioDTO {
	
	private Long id;
	
	private String username;
	
	private String password;
}
