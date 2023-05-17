package fp.tipos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		Map<Categoria, List<Mueble>> res = new HashMap<>();
		for(Mueble mueble: muebles) {
			if (res.containsKey(mueble.getCategoria())) {
				res.get(mueble.getCategoria()).add(mueble);
			}
			else {
				List<Mueble> lista = new ArrayList<>();
				lista.add(mueble);
				res.put(mueble.getCategoria(), lista);
			}
		}
		return res;
	}
	
	
//	Un método de acumulación que devuelva un Map en el que las claves sean una propiedad del tipo base, y los valores el conteo o la suma de los objetos del tipo base almacenados en el contenedor que tienen como valor esa propiedad.
	
	public Map<Categoria, Integer> contarCategorias(){
		Map<Categoria, Integer> res = new HashMap<>();
		for(Mueble mueble: muebles) {
			if (res.containsKey(mueble.getCategoria())) {
				res.put(mueble.getCategoria(), res.get(mueble.getCategoria())+1);
			}
			else {
				res.put(mueble.getCategoria(), 1);
			}
		}
		return res;
	}

//	ENTREGA 3
//	Bloque 1
//	A escoger uno de los dos siguientes: existe / para todo (el mismo implementado en la entrega 2, pero con streams).
	
	public Boolean existeMueble2(String nombre) {
		return muebles.stream()
				.map(t -> t.getNombre())
				.anyMatch(t->t.contains(nombre));
	}
	
//	A escoger uno de los tres siguientes: contador/suma/media (el mismo implementado en la entrega 2, pero con streams).
	
	public Double mediaPreciosPorCategoria2(Categoria categoria) {
		return muebles.stream()
				.filter(t->t.getCategoria()
				.equals(categoria))
				.mapToInt(m -> m.getPrecio().intValue())
				.average()
				.orElse(0);
	}
	
//	Una selección con filtrado (la misma implementada en la entrega 2, pero con streams).
	
	public List<Mueble> filtrarMasBaratoQue2(Float precio){
		return muebles.stream()
				.filter(t->t.getPrecio()<precio)
				.collect(Collectors.toList());
	}
	
//	Un máximo/mínimo con filtrado.
	
	public String masGrandeCategoria(Categoria categoria) {
		return muebles.stream()
				.filter(t->t.getCategoria().equals(categoria))
				.max(Comparator.comparing(t -> t.getVolumen()))
				.map(t -> t.getNombre())
				.get();
	}
	
//	Una selección, con filtrado y ordenación.
	
	public List<Mueble> masCarosAño(Integer año){
		Comparator<Mueble> c = Comparator.comparing(t -> t.getPrecio());
		return muebles.stream()
				.filter(t -> t.getFecha().getYear() == año)
				.sorted(c.reversed())
				.collect(Collectors.toList())
				;
	}
	
//	Bloque 2
//	Uno de los métodos (4) o (5) implementados en la entrega 2, pero con streams.
	
	public Map<Categoria, List<Mueble>> agruparCategorias2(){
		return muebles.stream().collect(Collectors.groupingBy(Mueble::getCategoria));
	}
	
	public Map<Categoria, Integer> contarCategorias2(){
		return muebles.stream().collect(Collectors.groupingBy(Mueble::getCategoria, Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
	}
	
//	Un método en cuya implementación se use, o bien el Collector collectingAndThen, o bien el Collector mapping.
	
	public Map<String, List<Categoria>> categoriasDeDiseñadores(){
		return muebles.stream()
				.collect(Collectors.groupingBy(
						Mueble::getDiseñador,
						Collectors.mapping(Mueble::getCategoria, Collectors.collectingAndThen(Collectors.toList(), d->d.stream().distinct().toList()))));
	}
	
//	Un método que devuelva un Map en el que las claves sean un atributo o una función sobre un atributo, y los valores son máximos/mínimos de los elementos que tienen ese valor.
	
	public Map<Categoria, Integer> menorPrecioPorCategoria(){
		Map<Categoria, List<Integer>> dict = muebles.stream()
				.collect(Collectors.groupingBy(
						Mueble::getCategoria, 
						Collectors.mapping(
								t->t.getPrecio().intValue(), 
								Collectors.toList())));
		return dict.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, t -> t.getValue().stream().min(Comparator.naturalOrder()).get()));
	}
	
//	Un método que devuelva un SortedMap en el que las claves sean un atributo o una función sobre un atributo, y los valores sean listas con los n mejores o peores elementos que comparten el valor de ese atributo (o función sobre el atributo).
	
	public SortedMap<Categoria, List<Mueble>> eneMueblesGrandesPorCategoria(Integer n){
		Comparator<Mueble> c = Comparator.comparing(t->t.getVolumen());
			return muebles.stream()
				.collect(Collectors.groupingBy(
						Mueble::getCategoria,
						TreeMap::new,
						Collectors.collectingAndThen(
								Collectors.toList(), 
								t->t.stream().sorted(c.reversed()).limit(n).collect(Collectors.toList()))));
	}
		
//	Un método que calcule un Map y devuelva la clave con el valor asociado (mayor o menor) de todo el Map.
	
	public Categoria categoriaMediaMasCara() {
		//Crear map con categoría y media
		//Sacar de ahí la clave con mayor media
		
		Map<Categoria, Double> dict = 
				muebles.stream().collect(
						Collectors.groupingBy(
								Mueble::getCategoria,
								Collectors.averagingDouble(Mueble::getPrecio)
								));
		
		return dict.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).map(t->t.getKey()).get();
	}
}
