package fp.tipos;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import fp.utiles.Checkers;
import fp.utiles.Ficheros;

public class FactoriaMueble {
	private static final int ArrayList = 0;
	private static Mueble parseMueble(String s) {
		Checkers.checkNoNull(s);
		String[] trozos = s.split(";");
		Checkers.check("Formato inválido", trozos.length == 12);
		Integer id = Integer.parseInt(trozos[1].trim());				
		String nombre = trozos[2].trim();			
		Categoria categoria = parsearCategoria(trozos[3].trim());
		Float precio = Float.parseFloat(trozos[4].trim());
		Float precioAnterior = Float.parseFloat(trozos[5].trim());;	
		Boolean online = parseBoolean(trozos[6].trim());
		String diseñador = trozos[11].trim();	
		Integer profundidad = parseInt(trozos[7].trim());
		Integer altura = parseInt(trozos[8].trim());			
		Integer anchura = parseInt(trozos[9].trim());	
		LocalDate fecha = parsearFecha(trozos[10].trim());	
		
		Mueble mueble = new Mueble( id,  nombre,  categoria,  precio,  precioAnterior,
				 online, diseñador, anchura, altura, profundidad, fecha);
		
		return mueble;
	
	}

	private static Integer parseInt(String a) {
		Integer res = null;
		if(!a.isEmpty()) {
			res = Integer.parseInt(a);
		}
		return res;
	}

	private static LocalDate parsearFecha(String a) {
		return LocalDate.parse(a, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	private static Boolean parseBoolean(String a) {
		Boolean res = true;
		if (a == "False") {
			res = false;
		}
		return res;
 	}
	
	public static List<Mueble> leeMuebles(String fichero){
		List<Mueble> res = new ArrayList<>();
		Checkers.checkNoNull(fichero);
		List<String> lineas = Ficheros.leeFichero("Error lectura",fichero);
		lineas.remove(0);
		for(String linea: lineas) {
			Mueble m = parseMueble(linea);
			res.add(m);
		}
		return res;
	}
	
	private static Categoria parsearCategoria(String categoria) {
		Categoria res = null;
		switch(categoria) {
		case "Bar furniture":{
			res = Categoria.BAR;
			break;
		}
		case "Beds":{
			res = Categoria.CAMA;
			break;
		}
		case "Bookcases & shelving units":{
			res = Categoria.ESTANTERÍA;
			break;
		}
		case "Cabinets & cupboards":{
			res = Categoria.ARMARIO;
			break;
		}
		case "CafÃ© furniture":{
			res = Categoria.MUEBLECAFÉ;
			break;
		}
		case "Chairs":{
			res = Categoria.SILLA;
			break;
		}
		case "Chests of drawers & drawer units":{
			res = Categoria.CAJONERA;
			break;
		}
		case "Children's furniture":{
			res = Categoria.MUEBLENIÑOS;
			break;
		}
		case "Nursery furniture":{
			res = Categoria.ENFERMERÍA;
			break;
		}
		case "Outdoor furniture":{
			res = Categoria.FUERA;
			break;
		}
		case "Room dividers":{
			res = Categoria.DIVISOR;
			break;
		}
		case "Sideboards. buffets & console tables":{
			res = Categoria.APARADOR;
			break;
		}
		case "Sofas & armchairs":{
			res = Categoria.SOFÁ;
			break;
		}
		case "Tables & desks":{
			res = Categoria.MESA;
			break;
		}
		case "Trolleys":{
			res = Categoria.CARROS;
			break;
		}
		case "TV & media furniture":{
			res = Categoria.MUEBLETELE;
			break;
		}
		case "Wardrobes":{
			res = Categoria.ROPERO;
			break;
		}
		}
		return res;
	}
}
