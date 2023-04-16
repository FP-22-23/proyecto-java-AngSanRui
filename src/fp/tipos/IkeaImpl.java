package fp.tipos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class IkeaImpl implements Ikea {
	
	private List<Mueble> muebles;
	
	public IkeaImpl() {
		this.muebles = new ArrayList<Mueble>();
	}
	
	public IkeaImpl(List<Mueble> lista) {
		this.muebles = lista;
	}

	public int hashCode() {
		return Objects.hash(muebles);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IkeaImpl other = (IkeaImpl) obj;
		return Objects.equals(muebles, other.muebles);
	}

	public String toString() {
		return "Ikea [muebles=" + muebles + "]";
	}
	
//	Obtener el número de elementos.
	public Integer numElementos() {
		return muebles.size();
	}
//	Añadir un elemento.
	public void añadir(Mueble m) {
		muebles.add(m);
	}

//	Añadir una colección de elementos.
	public void añadirColección(List<Mueble> l) {
		muebles.addAll(l);
	}

//	Eliminar un elemento.
	public void eliminar(Mueble m) {
		if(muebles.contains(m)) {
			muebles.remove(m);
		}
	}
	
//	A escoger uno de los dos siguientes: existe / para todo.
	public Boolean existeMueble(String nombre) {
		Boolean res = false;
		for (Mueble mueble:muebles) {
			if(mueble.getNombre().equals(nombre)) {
				res = true;
				break;
			}
		}
		return res;
	}

//	A escoger uno de los tres siguientes: contador / suma / media.
	public Double mediaPreciosPorCategoria(Categoria categoria) {
		Double suma = 0.0;
		Integer cont = 0;
		for (Mueble mueble:muebles) {
			if(mueble.getCategoria().equals(categoria)) {
				suma += mueble.getPrecio();
				cont ++;
			}
		}
		if (cont>0) {
			return suma/cont;
		} else {
			return null;
		}
	}

//	Una selección con filtrado.
	public List<Mueble> filtrarMasBaratoQue(Float precio){
		List<Mueble> res = new ArrayList<>();
		for(Mueble mueble: muebles) {
			if (mueble.getPrecio()<precio) {
				res.add(mueble);
			}
		}
		return res;
	}

//	Un método de agrupación que devuelva un Map en el que las claves sean una propiedad del tipo base, y los valores una colección (List, Set, SortedSet) de objetos del tipo base.
	
	public Map<Categoria, List<Mueble>> agruparCategorias(){
		return muebles.stream().collect(Collectors.groupingBy(Mueble::getCategoria));
	}
	
	
//	Un método de acumulación que devuelva un Map en el que las claves sean una propiedad del tipo base, y los valores el conteo o la suma de los objetos del tipo base almacenados en el contenedor que tienen como valor esa propiedad.
	public Map<Categoria, Long> contarCategorias(){
		return muebles.stream().collect(Collectors.groupingBy(Mueble::getCategoria, Collectors.counting()));
	}
}
