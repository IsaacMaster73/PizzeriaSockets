package Seriales;

import java.io.Serializable;

public class PizzaPedido implements Serializable{


	public String getIdTamano() {
		return idTamano;
	}
	public void setIdTamano(String idTamano) {
		this.idTamano = idTamano;
	}
	public String getTamano() {
		return tamano;
	}
	public void setTamano(String tamano) {
		this.tamano = tamano;
	}
	public String getPrecioTamano() {
		return precioTamano;
	}
	public void setPrecioTamano(String precioTamano) {
		this.precioTamano = precioTamano;
	}
	public String getIdEstilo() {
		return idEstilo;
	}
	public void setIdEstilo(String idEstilo) {
		this.idEstilo = idEstilo;
	}
	public String getEstilo() {
		return estilo;
	}
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
	public String getPrecioEstilo() {
		return precioEstilo;
	}
	public void setPrecioEstilo(String precioEstilo) {
		this.precioEstilo = precioEstilo;
	}
	public String getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(String idTipo) {
		this.idTipo = idTipo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		tipo = tipo;
	}
	public String getPrecioTipo() {
		return precioTipo;
	}
	public void setPrecioTipo(String precioTipo) {
		this.precioTipo = precioTipo;
	}
	public String getPrecioFinal() {
		try {
			
			float pt= Float.valueOf(precioTamano);
			float pe = Float.valueOf(precioEstilo); 
			float ptp= Float.valueOf(precioTipo);
//			System.out.println(pt +" "+ pe+" " + ptp);
			precioFinal = Float.toString( pt + pe + ptp);
			}
			catch (NumberFormatException e)
			{
				precioFinal = "0";
			}
		return precioFinal ;
	}
	public void setPrecioFinal(String precioFinal) {
		this.precioFinal = precioFinal;
	}

	public String getDirCliente() {
		return dirCliente;
	}
	public void setDirCliente(String dirCliente) {
		this.dirCliente = dirCliente;
	}
	public String getIdDir() {
		return idDir;
	}
	public void setIdDir(String i) {
		this.idDir = i;
	}
	String idTamano; 
	String tamano; 
	String precioTamano;
	
	String idEstilo;
	String estilo;
	String precioEstilo;
	
	String idTipo;
	String tipo;
	String precioTipo;
	String precioFinal;
	
	
	String dirCliente;
	String idDir;
	
	

}