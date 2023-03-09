package fp.tipos.test;

import java.time.LocalDate;

import fp.common.caja;
import fp.tipos.Categoria;
import fp.tipos.muebles;

public class mueblesTest {
	
	public static void main(String[] args) {
		//constructor 1
		muebles mueble1 = new muebles(50420329, "FREKVENS", Categoria.BAR, 177.0f, 295.0f,
				true, "Nicholai Wiig Hansen", 43, 104, 53, LocalDate.of(2013, 04, 10));
		//constructor 2
		muebles mueble2 = new muebles(50420329, "FREKVENS", Categoria.BAR, 177.0f, 295.0f,
				Boolean.TRUE, "Nicholai Wiig Hansen", LocalDate.of(2013, 04, 10));
		
		//con mismos datos que el mueble 1
		muebles mueble3 = new muebles(50420329, "FREKVENS", Categoria.BAR, 177.0f, 295.0f,
				true, "Nicholai Wiig Hansen", 43, 104, 53, LocalDate.of(2013, 04, 10));
		//con distintos datos que mueble 1
		muebles mueble4 = new muebles(60155602, "DALFRED", Categoria.BAR, 195.0f, null,
				true, "Sarah Fager", 43, 104, 53, LocalDate.of(2013, 04, 10));
		
		//Esta caja es más pequeña que mueble 1
		caja caja1 = new caja(50, 104, 50);
		//Esta caja es más grande que mueble 1
		caja caja2 = new caja(50, 104, 53);

		System.out.println(mueble1);
		System.out.println(mueble2);
		System.out.println(mueble1.equals(mueble2));
		System.out.println(mueble1.equals(mueble3));
		//El de abajo hace saltar un error previsto
		//System.out.println(mueble1.compareTo(mueble2));
		System.out.println(mueble1.compareTo(mueble3));
		System.out.println(mueble1.compareTo(mueble4));
		System.out.println(caja1.contiene(mueble1));
		System.out.println(caja2.contiene(mueble1));
		//El de abajo hace saltar un error previsto
		//System.out.println(caja1.contiene(mueble2));
		System.out.println("El precio actual del mueble 4 es: "+mueble4.getPrecio()+" y el anterior es: "+mueble4.getPrecioAnterior());
		mueble4.setPrecio(13.0f);
		System.out.println("Tras cambiarlo, el precio actual del mueble 4 es: "+mueble4.getPrecio()+" y el anterior es: "+mueble4.getPrecioAnterior());
	}

}
