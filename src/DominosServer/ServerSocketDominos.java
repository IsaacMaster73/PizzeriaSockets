/**
 * 
 */
package DominosServer;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
				Socket sock1=servSock.accept();
				DataInputStream flujo_entrada = new DataInputStream(sock1.getInputStream());
				String mensaje = flujo_entrada.readUTF();
				System.out.println("\n "+ mensaje);
				sock1.close();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
