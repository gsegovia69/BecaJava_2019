package com.everis.ejercicio1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.crypto.IllegalBlockSizeException;

public class Ejercicio3 
{
	private List <Alumno> alumno;
	
	public Ejercicio3(List<Alumno> alumno)
	{
		this.alumno = alumno;
	}
	
	public void OApellido() throws Exception
	{
		if (!alumno.isEmpty()) 
		{

			Collections.sort(alumno, new Comparator<Alumno>()
			{
				@Override
				public int compare(Alumno t1, Alumno t2) 
				{
					return t1.getNombre().toLowerCase().compareTo(t2.getNombre().toLowerCase());
				}
			});
			Collections.sort(alumno, new Comparator<Alumno>()
			{
				@Override
				public int compare(Alumno t1, Alumno t2) 
				{
					return t1.getApellidos().toLowerCase().compareTo(t2.getApellidos().toLowerCase());
				}
			});
		}
		else
		{
			throw new IllegalBlockSizeException("ERROR. Lista vacía");
		}
	}
	//FECHA
	public String getFecha() 
	{
		String t= null;
		Date d = new Date();
		DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat h = new SimpleDateFormat("HH:mm:ss");
		t = f.format(d) + " " + h.format(d);	
		return t;
	}
	//GUARDAR DATOS
	public String toString(Alumno a) 
	{	
		return getFecha() + "		" + a.getApellidos() + ", " + a.getNombre();
	}
	public void print() throws Exception 
	{
		OApellido();
		for (Alumno a : alumno) 
		{
			if(a.getCiudad().toLowerCase().startsWith("a")) 
			{
				System.out.println(toString(a));
			}
		}
	}
}