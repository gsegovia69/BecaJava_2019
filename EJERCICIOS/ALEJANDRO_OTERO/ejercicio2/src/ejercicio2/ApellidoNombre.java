package ejercicio2;

public class ApellidoNombre {
	import java.text.DateFormat;
	import java.text.SimpleDateFormat;
	import java.util.Collections;
	import java.util.Comparator;
	import java.util.Date;
	import java.util.List;

	import javax.crypto.IllegalBlockSizeException;

	import org.apache.commons.lang3.StringUtils;

	import com.everis.beca.ejercicios.dto.*;

	import lombok.Getter;
	import lombok.NoArgsConstructor;
	import lombok.Setter;

	@Getter
	@Setter
	@NoArgsConstructor
	public class ApellidoNombre {

		private List <Alumno> alumnos;

		public ApellidoNombre(List<Alumno> alumnos) {
			this.alumnos = alumnos;
		}
		
		public void ordenarApellido() throws Exception{

			if (!alumnos.isEmpty()) {
			Collections.sort(alumnos, new Comparator<Alumno>(){
			@Override
			public int compare(Alumno o1, Alumno o2) {
				if(o1.getApellidos().toLowerCase().compareTo(o2.getApellidos().toLowerCase())!=0) 
					return o1.getApellidos().toLowerCase().compareTo(o2.getApellidos().toLowerCase());
				else
					return o1.getNombre().toLowerCase().compareTo(o2.getNombre().toLowerCase());
			}
	 		});
			}
			else 
				throw new IllegalBlockSizeException("La lista de alumnos esta vacia");
		}
		public String getFecha() {
			String fechaHora= null;
			Date date = new Date();
			DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
			DateFormat hora = new SimpleDateFormat("HH:mm:ss");
			
			fechaHora = fecha.format(date) + " " + hora.format(date);

			
			return fechaHora;
		}
		
		public String toString(Alumno alu) {
			
			return getFecha() + " " + StringUtils.capitalize(alu.getApellidos()) + ", " + StringUtils.capitalize(alu.getNombre());
		}
		
		public void mostrar() throws Exception {
			ordenarApellido();
			for (Alumno alu : alumnos) {
				System.out.println(toString(alu));
			}
		}
		
	}

}
