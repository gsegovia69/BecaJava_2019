package manuelAmaya.proyecto1.mavenProject1.dto;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Fecha {
	
	Calendar hoy = new GregorianCalendar();
	
	public String getFechaDiaMes() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String fechafinal = sdf.format(hoy.getTime());
		
		return fechafinal;
	}
	public String getFechaMesDia() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		String fechafinal = sdf.format(hoy.getTime());
		
		return fechafinal;
	}
}
