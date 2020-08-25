/**
 * 
 */
package Seriales;

import java.io.Serializable;

/**
 * @author isaacmontielsanchez
 *
 */
public class PaqueteObjetos  implements Serializable{

	public int getTipo_objeto() {
		return tipo_objeto;
	}
	public void setTipo_objeto(int tipo_objeto) {
		this.tipo_objeto = tipo_objeto;
	}
	
	public OrdenDeCompra getOrden() {
		return orden;
	}
	public void setOrden(OrdenDeCompra orden) {
		this.orden = orden;
	}
	public Sesion getSesion() {
		return sesion;
	}
	public void setSesion(Sesion sesion) {
		this.sesion = sesion;
	}
	public Credenciales getCredenciales() {
		return credenciales;
	}
	public void setCredenciales(Credenciales credenciales) {
		this.credenciales = credenciales;
	}
	/**
	 * 
	 */
	public PaqueteObjetos() {
		// TODO Auto-generated constructor stub
	}
	OrdenDeCompra orden;
	Sesion sesion;
	Credenciales credenciales;
	//1 = login , 2 = orden , 
	int tipo_objeto ;
	PizzaPedido pizza;
	public PizzaPedido getPizza() {
		return pizza;
	}
	public void setPizza(PizzaPedido pizza) {
		this.pizza = pizza;
	}

}
