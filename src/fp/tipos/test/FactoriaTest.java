package fp.tipos.test;

import java.util.List;

import fp.tipos.FactoriaMueble;
import fp.tipos.Mueble;

public class FactoriaTest {
	public static void main(String[] args) {
		//Test de FactoriaMueble
				List<Mueble> muebles = FactoriaMueble.leeMuebles("data/ikea_csv.csv");
				System.out.println(muebles);
	}
}
