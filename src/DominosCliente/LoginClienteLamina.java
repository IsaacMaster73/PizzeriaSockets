package DominosCliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginClienteLamina extends JPanel{
	 public LoginClienteLamina(){
		 
		JLabel titulo = new JLabel("Cliente");
		add(titulo);
		campo= new JTextField(20);
		add(campo);
		btnEnviar = new JButton("Enviar");
		EnviarTexto eventEnv = new EnviarTexto();
		btnEnviar.addActionListener(eventEnv);
		add(btnEnviar);
	}

	private JTextField campo;
	private JButton btnEnviar;
	
	private class EnviarTexto implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
	//		campo.getText();
			try {
				Socket socket1 = new Socket("192.168.1.101" , 9999);
				DataOutputStream flujo_salida = new DataOutputStream(socket1.getOutputStream());
				flujo_salida.writeUTF(campo.getText());
				flujo_salida.close();
				
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println(e1.getMessage());
			}
			
		}
		
}
}
