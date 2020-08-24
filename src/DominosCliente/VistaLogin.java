/**
 * 
 */
package DominosCliente;

import javax.swing.JFrame;

/**
 * @author isaacmontielsanchez
 
 */
public class VistaLogin{
	
	public VistaLogin(){
		LoginClienteLamina lcliente = new LoginClienteLamina();
		 
		lcliente.setTitle("Dominos");
		lcliente.setVisible(true);
		lcliente.setBounds(10,10,370,600);
		lcliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lcliente.setResizable(false);
		
				
	}

}
