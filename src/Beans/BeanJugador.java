package Beans;

public class BeanJugador {
private String nombre, jugador;

public String getNombre(){
	return nombre;
}
public void setNombre(String nombre){
	this.nombre = nombre;
}
public String getJugador(){
	return jugador;
}
public void setJugador(String jugador){
	this.jugador = jugador;
}
public BeanJugador(String nombre, String jugador){
	super();
	this.nombre  = nombre;
	this.jugador = jugador;
	
}
@Override
public String toString(){
	return this.nombre;
}
	
}
