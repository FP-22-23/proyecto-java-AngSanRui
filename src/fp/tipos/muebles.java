package fp.tipos;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import fp.utiles.Checkers;

public class muebles {
	
	private Integer id;				//identificador del mueble			1-integer
	private String nombre;			//nombre del mueble					2-string
	private Categoria categoria;	//categoría del mueble				3-enumerate
	private Float precio;			//precio actual del mueble			4-float
	private Float precioAnterior;	//precio anterior del mueble		
	private Boolean online;			//si se puede comprar online		5-boolean
	private	String diseñador;		//nombre del diseñador del mueble	6-string
	private Integer profundidad;	//profundidad del mueble(cm)		}
	private	Integer altura;			//altura del mueble(cm)				}7-float derivada
	private	Integer anchura;		//anchura del mueble(cm)			}
	private LocalDate fecha;		//fecha de la salida del mueble		8-DateTime

	
	/**
	 * @param id				identificador del mueble	
	 * @param nombre			nombre del mueble
	 * @param categoria			categoría del mueble
	 * @param precio			precio actual del mueble
	 * @param precioAnterior	precio anterior del mueble
	 * @param online			si se puede comprar online
	 * @param diseñador			nombre del diseñador del mueble
	 * @param anchura			profundidad del mueble(cm)
	 * @param altura			altura del mueble(cm)
	 * @param profundidad		profundidad del mueble(cm)
	 * @param fecha				fecha de la salida del mueble
	 */
	
	//Este es el primer constructor, que incluye las medidas del mueble(anchura, altura y profundidad)
	
	public muebles(Integer id, String nombre, Categoria categoria, Float precio, Float precioAnterior,
			Boolean online, String diseñador, Integer anchura,
			Integer altura, Integer profundidad, LocalDate fecha) {
		
		super();
		
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.precioAnterior = precioAnterior;
		this.online = online;
		this.diseñador = diseñador;
		Checkers.check("Profundidad no válida", profundidad != null && profundidad > 0);
		Checkers.check("Altura no válida", altura != null && altura > 0);
		Checkers.check("Anchura no válida", anchura != null && anchura > 0);
		this.profundidad = profundidad;
		this.altura = altura;
		this.anchura = anchura;
		Checkers.check("Fecha no válida", !(fecha.isAfter(LocalDate.now())));
		this.fecha = fecha;
	}
	
	//Este es el segundo constructor, que NO incluye las medidas del mueble, ya que en el CSV hay algunas medidas que no están
	
	public muebles(Integer id, String nombre, Categoria categoria, Float precio, Float precioAnterior,
			Boolean online, String diseñador, LocalDate fecha) {
		
		super();
		
		this.id = id;
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.precioAnterior = precioAnterior;
		this.online = online;
		this.diseñador = diseñador;
		this.profundidad = null;
		this.altura = null;
		this.anchura = null;
		Checkers.check("Fecha no válida", !(fecha.isAfter(LocalDate.now())));
		this.fecha = fecha;
	}

	//Variables derivadas(volumen y dimensiones)
	
	public Integer getVolumen() {
		Integer res = null;
		if (getAnchura()!= null && getAltura()!= null && getProfundidad()!= null) {
			res = getAnchura()*getAltura()*getProfundidad();
		}
		return res;
	}
	
	public List<Integer> getDimensiones() {
		List<Integer> res = null;
		if (getAnchura()!= null && getAltura()!= null && getProfundidad()!= null) {
			res = new LinkedList<Integer>();
			res.add(anchura);
			res.add(altura);
			res.add(profundidad);
		}
		return res;
	}
	 
	
	//Todos los getters, como la mayoría de los datos no cambiarán, sólo hay setter del precio
	//Este setter aparte de cambiar el precio actual, cambia el anterior, sustituyéndolo por el-
	//-precio de antes de cambiarlo
	
	public void setPrecio(Float precio) {
		precioAnterior = this.precio;
		this.precio = precio;
	}
	
	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Float getPrecio() {
		return precio;
	}

	public Float getPrecioAnterior() {
		return precioAnterior;
	}

	public Boolean getOnline() {
		return online;
	}

	public String getDiseñador() {
		return diseñador;
	}

	public Integer getProfundidad() {
		return profundidad;
	}

	public Integer getAltura() {
		return altura;
	}

	public Integer getAnchura() {
		return anchura;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	
	//Este es el formato en String del objeto, que muestra todas sus propiedades(las medidas las muestra directamente en la lista de dimensiones
	
	@Override
	public String toString() {
		return "Estos son los datos del mueble: id=" + id + ", nombre del mueble=" + nombre + ", categoria=" + categoria + ", precio=" + precio
				+ ", precio anterior=" + precioAnterior + ", se vende online=" + online + ", nombre del diseñador=" + diseñador
				+ ", fecha de salida=" + fecha + ", dimensiones(anchura, altura, profundidad)=" + getDimensiones() + ", volumen=" + getVolumen();
	}

	//El hashCode y el equals, que usan las medidas, el diseñador, el id, y el nombre
	
	@Override
	public int hashCode() {
		return Objects.hash(altura, anchura, diseñador, id, nombre, profundidad);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		muebles other = (muebles) obj;
		return Objects.equals(altura, other.altura) && Objects.equals(anchura, other.anchura)
				&& Objects.equals(diseñador, other.diseñador) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(profundidad, other.profundidad);
	}

	//El compareTo, cuyo orden es el ID, el nombre, el nombre del diseñador, y las medidas(que tienen checkers para que sean válidas)
	
	public int compareTo(muebles mueble ) {
		int res = (getId().compareTo(mueble.getId()));
		if (res==0) {
			res = (getNombre().compareTo(mueble.getNombre()));
			if (res==0) {
				res = (getDiseñador().compareTo(mueble.getDiseñador()));
				if (res==0) {
					Checkers.check("Anchura de algún mueble no válida", mueble.getAnchura() != null && mueble.getAnchura()> 0 && anchura != null && anchura > 0);
					res = (getAnchura().compareTo(mueble.getAnchura()));
					if (res==0) {
						Checkers.check("Altura de algún mueble no válida", mueble.getAltura() != null && mueble.getAltura()> 0 && altura != null && altura > 0);
						res = (getAltura().compareTo(mueble.getAltura()));
						if (res==0) {
							Checkers.check("Profundidad de algún mueble no válida", mueble.getProfundidad() != null && mueble.getProfundidad()> 0);
							res = (getProfundidad().compareTo(mueble.getProfundidad()));
						}
					}
				}
			}
		}
		return res;
	}
}