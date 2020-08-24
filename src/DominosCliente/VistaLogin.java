/**
 * 
 */
package DominosCliente;

import javax.swing.JFrame;

/**
 * @author isaacmontielsanchez
 *
 */
public class VistaLogin extends JFrame {
	
	public VistaLogin(){
		setBounds(1200,300,280,350);
		LoginClienteLamina lcliente = new LoginClienteLamina();
		add(lcliente);
		setVisible(true);
		
	}

}
