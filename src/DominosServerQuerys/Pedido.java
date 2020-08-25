/**
 * 
 */
package DominosServerQuerys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Seriales.OrdenDeCompra;
import Seriales.PaqueteObjetos;
import Seriales.PizzaPedido;
import Seriales.Sesion;

/**
 * @author isaacmontielsanchez
 *
 */
public class Pedido {

	PaqueteObjetos paquete;
	PreparedStatement pst;
	ResultSet rs;
	Connection cn; 
	
	
	public Pedido(PaqueteObjetos pq) throws SQLException {
		this.paquete = pq;
		
		try {
		
		// Se inicializa a null
		PizzaPedido pizza =new PizzaPedido ();
		cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dominos","root","");
		
		pst = cn.prepareStatement("SELECT * FROM tam_pizza WHERE tipo = ?;");
		pst.setString(1, paquete.getOrden().getTamano() );
		rs = pst.executeQuery();
//		// Solo se obtiene el primer registro (Si existe)
		if (rs.next()) {
			pizza.setIdTamano(rs.getString(1));
			pizza.setTamano(rs.getString(2));
			pizza.setPrecioTamano(rs.getString(3));	
		}
		
		pst = cn.prepareStatement("SELECT * FROM especialidad WHERE especialidad = ?");
		pst.setString(1, paquete.getOrden().getEstilo() );
		rs = pst.executeQuery();
//		// Solo se obtiene el primer registro (Si existe)
		if (rs.next()) {
			pizza.setIdEstilo(rs.getString(1));
			pizza.setEstilo(rs.getString(2));
			pizza.setPrecioEstilo(rs.getString(3));	
		}
		pst = cn.prepareStatement("SELECT * FROM tipo WHERE tipo = ?");
		pst.setString(1, paquete.getOrden().getTipo());
		rs = pst.executeQuery();
//		// Solo se obtiene el primer registro (Si existe)
		if (rs.next()) {
			pizza.setIdTipo(rs.getString(1));
			pizza.setTipo(rs.getString(2));
			pizza.setPrecioTipo(rs.getString(3));	
		}
		pst = cn.prepareStatement("INSERT INTO dir_cliente (direccion,telefono) VALUES (?,?);",Statement.RETURN_GENERATED_KEYS);
		pst.setString(1, paquete.getOrden().getDireccion());
		pst.setString(2, paquete.getOrden().getTelefono());
		pst.executeUpdate();
		
		rs = pst.getGeneratedKeys();
//		// Solo se obtiene el primer registro (Si existe)
		if (rs.next()) {
			
			pizza.setIdDir(Integer.toString(rs.getInt(1)));	
			pizza.setDirCliente(paquete.getOrden().getDireccion());
		}
		
		pst = cn.prepareStatement("INSERT INTO pedidos (id_usuario,id_dir_cliente,id_especialidad,id_tam_pizza,id_tipo,precio_final) VALUES (?,?,?,?,?,?);",Statement.RETURN_GENERATED_KEYS);
		pst.setString(1, paquete.getSesion().getId());
		pst.setString(2, pizza.getIdDir());
		pst.setString(3, pizza.getIdEstilo());
		pst.setString(4, pizza.getIdTamano());
		pst.setString(5, pizza.getIdTipo());
		pst.setString(6, pizza.getPrecioFinal());
		pst.executeUpdate();
		
		rs = pst.getGeneratedKeys();
//		// Solo se obtiene el primer registro (Si existe)
		if (rs.next()) {
			
			paquete.getOrden().setPrecio( pizza.getPrecioFinal());
			paquete.getOrden().setIdPedido(Integer.toString(rs.getInt(1)));	
		}
		
	} catch (Exception e) {
		System.out.println( "Error " + e);
	} finally {
		// Cierre de recursos (si se usa java7 se puede usar un try-with-resources
		if(rs!=null){
			rs.close();
		}
		if(pst!=null){
			pst.close();
		}
		if(cn!=null){
			cn.close();
		}   
	}
			
	}

	public PaqueteObjetos pq() {
		return this.paquete;
	}
	
}

