package fp.common;

import fp.tipos.Mueble;
import fp.utiles.Checkers;

public record caja(Integer anchura, Integer altura, Integer profundidad) {
	
	//Este tipo caja crea una caja recibiendo tres medidas, tiene un método contiene(muebles)-
	//-que sirve para comprobar si un mueble cabe dentro de ese tipo de caja. Tiene un Checkers-
	//-por si alguno de los valores del mueble no tiene sentido(si es null o cero o negativo)repite
	
	public Boolean contiene(Mueble mueble) {
		Checkers.check("Al mueble le falta una o más dimensiones", (mueble.getAltura() >0 && mueble.getAnchura() >0 && mueble.getProfundidad() > 0));
		return	(anchura >= mueble.getAnchura() && altura >= mueble.getAltura() 
				&& profundidad >= mueble.getProfundidad());
	}
}