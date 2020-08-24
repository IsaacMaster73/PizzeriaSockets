/**
 * 
 */
package DominosServer;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

import Seriales.Credenciales;

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
			
			Credenciales usuario_ser ;
			while(true) {
				Socket sock1=servSock.accept();
				ObjectInputStream pack_int = new ObjectInputStream(sock1.getInputStream());
				usuario_ser = (Credenciales) pack_int.readObject();
				System.out.println(usuario_ser.getUsuario());
				System.out.println(usuario_ser.getContra());
				sock1.close();
			}
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

