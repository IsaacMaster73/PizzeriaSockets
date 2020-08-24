/**
 * 
 */
package DominosServerQuerys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author isaacmontielsanchez
 *
 */
public class Login {
	PreparedStatement pst;
	ResultSet rs;
	Connection cn; 
	
	String usuario;
	String contra;
	
	public Login(String usr , String contra) throws SQLException {
		
		this.usuario = usr;
		this.contra = contra;
	try {
		  // Se inicializa a null
	    String passwordCorrecta = null;
	    String nombre = null;
		cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dominos","root","");
		pst = cn.prepareStatement("SELECT contrasena,nombre_comp FROM usuarios WHERE usuario = ?");
	    pst.setString(1, usuario );
	    rs = pst.executeQuery();

	    // Solo se obtiene el primer registro (Si existe)
	    if (rs.next()) {
	        passwordCorrecta = rs.getString(1);
	        nombre = rs.getString(2);	        
	    }

	    // Si se ha obtenido un usuario y password y ademas esta es coincidente
	    if (passwordCorrecta !=null && contra.equals(passwordCorrecta)) {
	        System.out.println(passwordCorrecta +" "+  nombre); 
	    } else {
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
	}}



