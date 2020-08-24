/**
 * 
 */
package Seriales;

import java.io.Serializable;

/**
 * @author isaacmontielsanchez
 *
 */
public class Credenciales implements Serializable{
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContra() {
		return contra;
	}
	public void setContra(String contra) {
		this.contra = contra;
	}
	String usuario = "";
	String contra = "";
	
}