package everis.beca.java.practicas.mavenPrueba.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Fecha {
	public String getFecha() {
		@SuppressWarnings("unused")
		StringBuffer stringBuffer = new StringBuffer();
		@SuppressWarnings("unused")
		Date now = new Date();
		String isoDatePattern = "dd-MM-yyyy' 'HH:mm:ss' '";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(isoDatePattern);
		String dateString = simpleDateFormat.format(new Date());
		return dateString;
	}
}
