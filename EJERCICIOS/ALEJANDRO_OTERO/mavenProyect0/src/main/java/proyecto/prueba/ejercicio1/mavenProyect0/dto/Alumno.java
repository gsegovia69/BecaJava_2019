package proyecto.prueba.ejercicio1.mavenProyect0.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**import com.thoughtworks.xstream.annotations.XStreamAlias;*/
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table

public class Alumno {
	@Column (columnDefinition = "id")
	private String id;
	@Column (name = "nombre")
	
	private String nombre;
	
	private String apellidos;
	private String email;
	private String ciudad;
	
}
