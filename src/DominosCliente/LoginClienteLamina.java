package DominosCliente;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Seriales.Credenciales;
import Seriales.PaqueteObjetos;
import Seriales.Sesion;

public class LoginClienteLamina extends JFrame implements ActionListener {
 
    Container container=getContentPane();
    JLabel labelUsuario=new JLabel("Usuario");
    JLabel labelContra=new JLabel("Contraseña");
    JTextField inputUsuario=new JTextField();
    JPasswordField inputContra=new JPasswordField();
    JButton loginButton=new JButton("Ingresar");
    JButton resetButton=new JButton("Limpiar campos");
    JCheckBox verContra=new JCheckBox("Mostar contrasaña");
    
    
    
    LoginClienteLamina()
    {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();//calling addActionEvent() method
        inputUsuario.setText("is@gmail.com");
        inputContra.setText("noseguro");
 
    }
   public void setLayoutManager()
   {
       container.setLayout(null);
   }
   public void setLocationAndSize()
   {
       labelUsuario.setBounds(50,150,100,30);
       labelContra.setBounds(50,220,100,30);
       inputUsuario.setBounds(150,150,150,30);
       inputContra.setBounds(150,220,150,30);
       verContra.setBounds(150,250,150,30);
       loginButton.setBounds(50,300,100,30);
       resetButton.setBounds(200,300,100,30);
 
 
   }
   public void addComponentsToContainer()
   {
       container.add(labelUsuario);
       container.add(labelContra);
       container.add(inputUsuario);
       container.add(inputContra);
       container.add(verContra);
       container.add(loginButton);
       container.add(resetButton);
   }
   public void addActionEvent()
   {
      //adding Action listener to components
       loginButton.addActionListener(this);
       resetButton.addActionListener(this);
       verContra.addActionListener(this);
   }
 
 
   @Override
   public void actionPerformed(ActionEvent e) {
       //Coding Part of LOGIN button
       if (e.getSource() == loginButton && inputUsuario.getText() != null &&  inputContra.getText() != null) {
    	  
           String userText;
           String pwdText;
           userText = inputUsuario.getText();
           pwdText = inputContra.getText();
           PaqueteObjetos paquete= new PaqueteObjetos (); 
           try {
				Socket socket1 = new Socket("192.168.1.101" , 9999);
				Credenciales credenciales  = new Credenciales();
				credenciales.setUsuario(userText);
				credenciales.setContra(pwdText);
				ObjectOutputStream ObjSaliente = new ObjectOutputStream(socket1.getOutputStream());
				paquete.setTipo_objeto(1);
				paquete.setCredenciales(credenciales);
				ObjSaliente.writeObject(paquete);
				
				
				
		       	ObjectInputStream paqueteResp = new ObjectInputStream(socket1.getInputStream());
		       	paquete = (PaqueteObjetos) paqueteResp.readObject();
				
		           if(paquete.getSesion().isSe_ini() == true) {
//						JOptionPane.showMessageDialog(this, "Ingreso Correcto");
						this.dispose();
						VentanaSelectora vSelec = new VentanaSelectora(paquete);
						vSelec.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(this, "Credenciales invalidas\nPorfavor intente de nuevo.");
					}
		           socket1.close();
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println(e1.getMessage());
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
           
       }
       //Coding Part of RESET button
       if (e.getSource() == resetButton) {
    	   inputUsuario.setText("");
    	   inputContra.setText("");
       }
      //Coding Part of showPassword JCheckBox
       if (e.getSource() == verContra) {
           if (verContra.isSelected()) {
        	   inputContra.setEchoChar((char) 0);
           } else {
        	   inputContra.setEchoChar('*');
           }


       }
   }
   
   
}

