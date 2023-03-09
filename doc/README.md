# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  \<22\>/\<23\>)
Autor/a: \<Ángel Sánchez Ruiz\>   uvus:\<NWR9335\>

El dataset contiene muchos datos de diferentes muebles de IKEA.

## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto. Debe estar estructurado en los siguentes paquetes
  * **fp.\<dominio\>**: Paquete que contiene los tipos del proyecto.
  * **fp.\<dominio\>.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.common**: Paquete que contiene los tipos auxiliares del proyecto
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
* **/data**: Contiene el dataset o datasets del proyecto
    * **\<IKEA_SA_Furniture_Web_Scrapings_sss.csv\>**: El dataset contiene varios datos sobre muebles de IKEA.
    * **\<dataset2.csv\>**: Añade una descripción del resto de datasets que puedas tener.
    
## Estructura del *dataset*

El enlace del dataset es este: https://www.kaggle.com/datasets/ahmedkallam/ikea-sa-furniture-web-scraping. Contiene muchos datos de diferentes muebles de IKEA.

El dataset está compuesto por \<11\> columnas, con la siguiente descripción:

* **\<item_id>**: de tipo Integer, representa el identificador del mueble
* **\<name>**: de tipo String, representa el nombre del mueble
  **\<category>**: de tipo String, representa la categoría del mueble(realmente es de tipo Categoria, pero cuando aprendamos a trabajar con CSV en java, al leer los datos, los cambiará a Categoria)
  **\<price>**: de tipo Float, representa el precio actual del mueble
  **\<old_price>**: de tipo Float, representa el precio anterior del mueble
  **\<sellable_online>**: de tipo Boolean, representa si se puede comprar online
  **\<depth>**: de tipo Integer, representa la profundidad del mueble en cm
  **\<height>**: de tipo Integer, representa la altura del mueble en cm
  **\<width>**: de tipo Integer, representa la anchura del mueble en cm
  **\<release_date>**: de tipo LocalDate, representa la fecha en la que se comercializó el mueble
  **\<designer>**: de tipo String, representa el nombre del diseñador del mueble

## Tipos implementados

 En mi proyecto uso un record que es el tipo caja. Este sirve para crear cajas con unas dimensiones determinadas para comprobar si un mueble cabría dentro de dicha caja mediante el método contiene(mueble).

### Tipo Base
Está compuesto por dos constructores, getters, un toString, un hashCode, un equals y un compareTo.

**Propiedades**:

- _id_, de tipo \<Integer\>, consultable.
- _nombre_, de tipo \<String\>, consultable.
- _categoria_, de tipo \<Categoria\>, consultable.
- _precio_, de tipo \<Float\>, consultable.
- _precioAnterior_, de tipo \<Float\>, consultable.
- _online_, de tipo \<Boolean\>, consultable.
- _diseñador_, de tipo \<String\>, consultable.
- _profundidad_, de tipo \<Integer\>, consultable.
- _altura_, de tipo \<Integer\>, consultable.
- _anchura_, de tipo \<Integer\>, consultable.
- _fecha_, de tipo \<LocalDate\>, consultable.
- _dimensiones_, de tipo \<List<Integer>\>, consultable, derivada.
- _volumen_, de tipo \<Integer\>, consultable, derivada.

**Constructores**: 

- muebles: Este constructor recibe todos los parámetros del csv y dimensiones lo crea usando las medidas de el mueble en cm y volumen lo calcula multiplicando estas 3.
- muebles: este segundo constructor es igual que el anterior, pero ya que hay en el csv algunas medidas que faltan, no las recibe como argumentos. De esta manera, sus valores son null, y el de dimensiones y volumen también.
- ...

**Restricciones**:
 
- R1: La primera restricción son realmente varias. Consisten en detectar que las medidas del mueble no sean null y sean mayores que cero. La aplico para métodos que usan estas medidas como el de contiene(mueble) o el compareTo(obj).
- R2: La segunda restricción la uso en los constructores, para asegurarme de que la fecha de salida sea una pasada.
 
**Criterio de igualdad**: El criterio de igualdad se cumple si coinciden la altura, la anchura, el nombre del diseñador, el id, el nombre del mueble, y la profundidad.

**Criterio de ordenación**: El criterio de ordenación es en este orden: el id, el nombre del mueble, el nombre del creador, y las medidas.

**Otras operaciones**:
 
-	_setPrecio_: este setter además de cambiar el valor de precio, cambia el valor de precioAnterior por el del precio antes de cambiarlo.

#### Tipos auxiliares
Hay un tipo auxiliar que es caja, recibe tres parámetros que son las medidas de una caja, y tiene el método contiene(muebles).

-	_contiene_: Este método está en el tipo caja, y sirve para comprobar si un mueble cabe dentro de la caja creada. Devuelve un Boolean.

### Factoría
Descripción breve de la factoría.

- _método 1_: Descripción del método 1.
-	_método 2_: Descripción del método 2.

### Tipo Contenedor

Descripción breve del tipo contenedor.

**Propiedades**:

- _propiedad1_, de tipo \<Tipo1\>, consultable. 
- _propiedad2_, de tipo \<Tipo2\>, consultable y modificable. 
- ...
- 
**Constructores**: 

- C1: Descripción del constructor 1.
- C2: Descripción del constructor 2.
- ...

**Restricciones**:
 
- R1: Descripción de la restricción 1.
- R2: Descripción de la restricción 2.
- ...
- 
**Criterio de igualdad**: Describir el criterio de igualdad

**Criterio de ordenación**: Describir el criterio de ordenación (si lo hay).

**Otras operaciones**:
 
-	_método 1_: Descripción del método 1.
- ...
