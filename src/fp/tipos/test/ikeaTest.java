package fp.tipos.test;

import java.util.List;

import fp.tipos.Categoria;
import fp.tipos.FactoriaMueble;
import fp.tipos.Ikea;
import fp.tipos.IkeaImpl;
import fp.tipos.Mueble;

public class ikeaTest {
	public static void main(String[] args) {
		List<Mueble> muebles = FactoriaMueble.leeMuebles("data/ikea_csv.csv");
		//Test métodos Ikea
				Ikea ikea = new IkeaImpl(muebles);
				System.out.println("Número de elementos: "+ikea.numElementos());
				System.out.println(muebles.subList(Math.max(muebles.size() - 10, 0), muebles.size()));
				System.out.println("Existe el mueble: INGOLF? "+ikea.existeMueble("INGOLF"));
				System.out.println("Existe el mueble: INVENTADO? "+ikea.existeMueble("INVENTADO"));
				System.out.println("Media de precios de la categoría BAR:"+ ikea.mediaPreciosPorCategoria(Categoria.CAMA));
				System.out.println(ikea.agruparCategorias());
				System.out.println("Los muebles más baratos de 80 um son: "+ ikea.filtrarMasBaratoQue(80.0f));
				System.out.println("La cuenta de cada categoría de muebles es: \n"+ikea.contarCategorias());
	}
}
