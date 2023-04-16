package fp.tipos;

import java.util.List;
import java.util.Map;

public interface Ikea {

	Integer numElementos();
	void añadir(Mueble m);
	void añadirColección(List<Mueble> l);
	void eliminar(Mueble m);
	Boolean existeMueble(String nombre);
	Double mediaPreciosPorCategoria(Categoria categoria);
	List<Mueble> filtrarMasBaratoQue(Float precio);
	Map<Categoria, List<Mueble>> agruparCategorias();
	Map<Categoria, Long> contarCategorias();
}
