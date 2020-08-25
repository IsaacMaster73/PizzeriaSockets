
/**
 * 
 */
package DominosServerQuerys;

import java.sql.*;

/**
 * @author isaacmontielsanchez
 *
 */
public class BDconexion {
	
	Connection cn;
	public BDconexion() {
		
		try {
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dominos","root","");
		}catch(Exception e) {
			
		}
	}
	public Connection getCn() {
		return cn;
	}
	public void setCn(Connection cn) {
		this.cn = cn;
	}
}
