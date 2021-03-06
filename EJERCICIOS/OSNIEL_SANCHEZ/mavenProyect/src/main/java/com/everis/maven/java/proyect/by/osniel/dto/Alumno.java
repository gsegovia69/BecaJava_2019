package com.everis.maven.java.proyect.by.osniel.dto;
import java.util.Date;
import java.nio.channels.SelectableChannel;
import java.text.SimpleDateFormat;
import java.util.Locale;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@XStreamAlias("alumno")
public class Alumno{
	String nombre;
    String apellidos;
    String email;
    String ciudad;
    String id_clase;
	public boolean isAlejandro() {
		return this.nombre.equalsIgnoreCase("Alejandro");
	}
	public boolean getNameAandS() {
		return this.nombre.substring(0, 1).equalsIgnoreCase("A") || this.nombre.substring(0, 1).equalsIgnoreCase("S");
	}
	public String printaAlumnos() {
		String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault()).format(new Date());
		return String.format("%s ......%s...... email:%s" + "......ciudad:%s %s",date + "->", nombre +" "+ apellidos,email,ciudad,id_clase);
    }
	public String getaAlumnos() {
		String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault()).format(new Date());
		return String.format("%s ......%s...... email:%s" + "......ciudad:%s %s",date + "->", nombre +" "+ apellidos,email,ciudad,id_clase);
    }
	public String getaEmailandCiudad(){
		return String.format("email:%s" + "......ciudad:%s",email,ciudad);
    }
	public String getaAlumnosFormatoFecha() {
		int separator = email.toString().length()-5;
		String date = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.getDefault()).format(new Date());
        return String.format("%s ......%s...... email:%s" + "......ciudad:%s",date + "->",nombre + " " + apellidos,email,ciudad).replace('/', '-');
    }
	public boolean getCiudadContainsA() {
		return this.ciudad.substring(0, 1).equalsIgnoreCase("A") ;
	}
	public boolean getNameContainsA() {
		return this.nombre.contains("a");
	}
}
