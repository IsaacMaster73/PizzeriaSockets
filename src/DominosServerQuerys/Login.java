/**
 * 
 */
package DominosServerQuerys;

import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Seriales.Sesion;

/**
 * @author isaacmontielsanchez
 *
 */
public class Login {
	PreparedStatement pst;
	ResultSet rs;
	Connection cn; 

	String id;
	String usuario;
	String contra;
	Sesion se; 
	boolean se_ini = false;

	public Login(String usr , String contra) throws SQLException {

		this.usuario = usr;
		this.contra = contra;
		try {
			// Se inicializa a null
			String passwordCorrecta = null;
			String nombre = null;
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dominos","root","");
			pst = cn.prepareStatement("SELECT * FROM usuarios WHERE usuario = ?");
			pst.setString(1, usuario );
			rs = pst.executeQuery();
			se = new Sesion();
			// Solo se obtiene el primer registro (Si existe)
			if (rs.next()) {
				id = rs.getString(1);
				usuario = rs.getString(2);
				passwordCorrecta = rs.getString(3);
				nombre = rs.getString(4);	  

				se.setId(id);
				se.setNombre(nombre);
				se.setUsuario(usuario);
				se.setSe_ini(true);
				System.out.println(passwordCorrecta +" "+  nombre);
			}else {
				se.setId(null);
				se.setNombre(null);
				se.setUsuario(null);
				se.setSe_ini(false);
				System.out.println( "Usuario o contraseña incorrectos");
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

	public Sesion se() {
		return this.se;
	}
}



