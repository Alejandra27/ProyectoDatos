package clases;

public class Pasajero {
 private int documento;
 private String nombre;
 private String ciudad;
 private String genero;
 private int silla;
 
 
 
 public Pasajero() {
	super();
}

public Pasajero(int documento, String nombre, String ciudad, String genero,
         int silla) {
     this.documento = documento;
     this.nombre = nombre;
     this.ciudad= ciudad;
     this.genero = genero;
     this.silla = silla;
 }



public Pasajero(int documento) {
	super();
	this.documento = documento;
}

public int getDocumento() {
	return documento;
}

public void setDocumento(int documento) {
	this.documento = documento;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getCiudad() {
	return ciudad;
}

public void setCiudad(String ciudad) {
	this.ciudad = ciudad;
}

public String getGenero() {
	return genero;
}

public void setGenero(String genero) {
	this.genero = genero;
}

public int getSilla() {
	return silla;
}

public void setSilla(int silla) {
	this.silla = silla;
}

public String insertar(){
	
	String resp = "insert into Pasajero values(" + nombre.trim() + ",'"+documento+"', '"+silla+"', '"+genero+"', " + ciudad + "')";
	System.out.println(resp);
	return resp;
}

 
public String eliminar(){
	return "delete from pasajero where documento = "+ documento;
}

public String actualizar(){
	return "update pasajero set nombre= " + nombre.trim() + " where documento =" + documento;
}

public String consultar(){
	return "select * from pasajero" + " where documento = " + documento;
}
}

 
 
 

 