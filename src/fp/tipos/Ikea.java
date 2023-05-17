package fp.tipos;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;

public interface Ikea {

	Integer numElementos();
	void añadir(Mueble m);
	void añadirColección(List<Mueble> l);
	void eliminar(Mueble m);
	Boolean existeMueble(String nombre);
	Double mediaPreciosPorCategoria(Categoria categoria);
	List<Mueble> filtrarMasBaratoQue(Float precio);
	Map<Categoria, List<Mueble>> agruparCategorias();
	Map<Categoria, Integer> contarCategorias();
	
	//Entrega 3
	
	//Bloque 1
	Boolean existeMueble2(String nombre);
	Double mediaPreciosPorCategoria2(Categoria categoria);
	List<Mueble> filtrarMasBaratoQue2(Float precio);
	String masGrandeCategoria(Categoria categoria);
	List<Mueble> masCarosAño(Integer año);
	
	//Bloque 2
	Map<Categoria, List<Mueble>> agruparCategorias2();
	Map<Categoria, Integer> contarCategorias2();
	Map<String, List<Categoria>> categoriasDeDiseñadores();
	Map<Categoria, Integer> menorPrecioPorCategoria();
	SortedMap<Categoria, List<Mueble>> eneMueblesGrandesPorCategoria(Integer n);
	Categoria categoriaMediaMasCara();
}