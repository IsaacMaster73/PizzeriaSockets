/**
 * 
 */
package DominosServer;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

import DominosServerQuerys.Login;
import DominosServerQuerys.Pedido;
import Seriales.Credenciales;
import Seriales.PaqueteObjetos;
import Seriales.Sesion;

/**
 * @author isaacmontielsanchez
 *
 */
public class ServerSocketDominos implements Runnable {

	
	public ServerSocketDominos() {
		Thread hilo = new Thread(this);
		hilo.start();
	}	
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			ServerSocket servSock = new ServerSocket(9999);
			
			while(true) {
				Credenciales credenciales;
				PaqueteObjetos paquete;
				Socket sock1=servSock.accept();
				ObjectInputStream streamInput = new ObjectInputStream(sock1.getInputStream());
				paquete = (PaqueteObjetos) streamInput.readObject();
				switch(paquete.getTipo_objeto()) {
				
				case 1:
					Login log = new Login(paquete.getCredenciales().getUsuario(),paquete.getCredenciales().getContra());
					paquete.setSesion( log.se()); 
					paquete.setTipo_objeto(3);
					paquete.setCredenciales(null);
					ObjectOutputStream outSt = new ObjectOutputStream(sock1.getOutputStream());
					outSt.writeObject(paquete);
					break;
				
				case 2:
					Pedido pedido = new Pedido(paquete);
					paquete = pedido.pq();
					ObjectOutputStream outSt1 = new ObjectOutputStream(sock1.getOutputStream());
					outSt1.writeObject(paquete);
					break;
					
				
				
				}
				
				
			}
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

