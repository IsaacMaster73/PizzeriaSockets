package Seriales;

import java.io.Serializable;

public class Sesion implements Serializable{
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String nombre;
	public String usuario;
	public String	id;
	public boolean se_ini;
	public boolean isSe_ini() {
		return se_ini;
	}
	public void setSe_ini(boolean se_ini) {
		this.se_ini = se_ini;
	}

}
