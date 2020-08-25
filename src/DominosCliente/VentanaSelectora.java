/**
 * 
 */
package DominosCliente;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

import Seriales.Credenciales;
import Seriales.OrdenDeCompra;
import Seriales.PaqueteObjetos;
import Seriales.Sesion;


/**
 * @author isaacmontielsanchez
 *
 */
public class VentanaSelectora extends JFrame 
    implements ActionListener { 
  
    // Components of the Form
	private Container c; 
	private ButtonGroup tam_grp;
	private JLabel tamano_pizz; 
    private JRadioButton personal; 
    private JRadioButton familiar;
    private JRadioButton mediana;
    
    private ButtonGroup estilo_grp;
	private JLabel estilo_pizz; 
    private JRadioButton espe; 
    private JRadioButton sarten;
    private JRadioButton orilla;
    

    private JLabel labelTelefono; 
    private JTextField telefono; 
    
    private JLabel labelTipo;
    JRadioButton peperoni;
    JRadioButton hawaiana;      
    JRadioButton mexicana;
    JRadioButton queso;
    private ButtonGroup tipo_grp;
    private JLabel add; 
    private JLabel title; 
    private JTextArea resadd; 
    private JButton sub; 
    private JTextArea tadd; 
    JLabel labelTelefonoVal;
    JLabel labelDirVal;

    
    String tamano=null;
    String tipo=null;
    String estilo=null;
    PaqueteObjetos paquete;
  
    // constructor, to initialize the components 
    // with default values. 
    public VentanaSelectora(PaqueteObjetos paquete) 
    { 
    	this.paquete = paquete;
        setTitle("Dominos"); 
        setBounds(100, 90, 600, 700); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
  
        c = getContentPane(); 
        c.setLayout(null); 
  
        title = new JLabel("Escoge tu pizza como más te guste!!!"); 
        title.setFont(new Font("Arial", Font.PLAIN, 30)); 
        title.setSize(600, 40); 
        title.setLocation(50, 30); 
        c.add(title); 
  
        
        tamano_pizz = new JLabel("Tamaño:"); 
        tamano_pizz.setFont(new Font("Arial", Font.PLAIN, 20)); 
        tamano_pizz.setSize(100, 20); 
        tamano_pizz.setLocation(75, 100); 
        c.add(tamano_pizz); 
  
        familiar = new JRadioButton("Familiar"); 
        familiar.setFont(new Font("Arial", Font.PLAIN, 15)); 
        familiar.setSelected(true); 
        familiar.setSize(100, 30); 
        familiar.setLocation(200, 100); 
        familiar.setActionCommand("familiar");
        c.add(familiar); 
        mediana = new JRadioButton("Mediana"); 
        mediana.setFont(new Font("Arial", Font.PLAIN, 15)); 
        mediana.setSelected(true); 
        mediana.setSize(100, 30); 
        mediana.setActionCommand("mediana");
        mediana.setLocation(300, 100); 
        c.add(mediana);
        personal = new JRadioButton("Personal"); 
        personal.setFont(new Font("Arial", Font.PLAIN, 15)); 
        personal.setSelected(true); 
        personal.setSize(100, 30); 
        personal.setLocation(400, 100);
        personal.setActionCommand("personal");
        c.add(personal);

        tam_grp = new ButtonGroup(); 
        tam_grp.add(familiar); 
        tam_grp.add(mediana);
        tam_grp.add(personal);
        
        
        
        estilo_pizz = new JLabel("Estilo:"); 
        estilo_pizz.setFont(new Font("Arial", Font.PLAIN, 20)); 
        estilo_pizz.setSize(100, 20); 
        estilo_pizz.setLocation(75, 150); 
        c.add(estilo_pizz); 
        
        espe = new JRadioButton("Especial"); 
        espe.setFont(new Font("Arial", Font.PLAIN, 15)); 
        espe.setSelected(true); 
        espe.setSize(100, 30); 
        espe.setLocation(200, 150); 
        espe.setActionCommand("especial");
        c.add(espe); 
        
        sarten = new JRadioButton("Sarten"); 
        sarten.setFont(new Font("Arial", Font.PLAIN, 15)); 
        sarten.setSelected(true); 
        sarten.setSize(100, 30); 
        sarten.setLocation(300, 150);
        sarten.setActionCommand("sarten");
        c.add(sarten);
        
        orilla = new JRadioButton("Orilla de Queso"); 
        orilla.setFont(new Font("Arial", Font.PLAIN, 15)); 
        orilla.setSelected(true); 
        orilla.setSize(150, 30); 
        orilla.setLocation(400, 150);
        orilla.setActionCommand("orilla");
        c.add(orilla);

        estilo_grp = new ButtonGroup(); 
        estilo_grp.add(espe); 
        estilo_grp.add(sarten);
        estilo_grp.add(orilla);
        
       
  
       
        labelTipo = new JLabel("Tipo"); 
        labelTipo.setFont(new Font("Arial", Font.PLAIN, 20)); 
        labelTipo.setSize(100, 20); 
        labelTipo.setLocation(75, 200); 
        c.add(labelTipo); 
  

         peperoni = new JRadioButton("Pepperoni");
         peperoni.setFont(new Font("Arial", Font.PLAIN, 15)); 
         peperoni.setSelected(true); 
         peperoni.setSize(100, 30); 
         peperoni.setLocation(200, 200);
         peperoni.setActionCommand("peperoni");
         c.add(peperoni);
         hawaiana = new JRadioButton("Hawaina");   
         hawaiana.setFont(new Font("Arial", Font.PLAIN, 15)); 
         hawaiana.setSelected(true); 
         hawaiana.setSize(100, 30); 
         hawaiana.setActionCommand("hawaiana");
         hawaiana.setLocation(300, 200); 
         c.add(hawaiana);
         mexicana  = new JRadioButton("Mexicana");
         mexicana.setFont(new Font("Arial", Font.PLAIN, 15)); 
         mexicana.setSelected(true); 
         mexicana.setSize(100, 30);
         mexicana.setActionCommand("mexicana");
         mexicana.setLocation(400, 200); 
         c.add(mexicana);
         queso = new JRadioButton("Queso");
         queso.setFont(new Font("Arial", Font.PLAIN, 15)); 
         queso.setSelected(true); 
         queso.setSize(100, 30); 
         queso.setActionCommand("queso");
         queso.setLocation(500, 200); 
         c.add(queso);
         tipo_grp = new ButtonGroup(); 
         tipo_grp.add(peperoni); 
         tipo_grp.add(hawaiana);
         tipo_grp.add(mexicana);
         tipo_grp.add(queso);
         
         
         labelTelefono = new JLabel("Telefono"); 
         labelTelefono.setFont(new Font("Arial", Font.PLAIN, 20)); 
         labelTelefono.setSize(100, 20); 
         labelTelefono.setLocation(75, 250); 
         c.add(labelTelefono); 
   
         telefono = new JTextField(); 
         telefono.setFont(new Font("Arial", Font.PLAIN, 15)); 
         telefono.setSize(150, 20); 
         telefono.setLocation(200, 250); 
         c.add(telefono); 
        
         labelTelefonoVal = new JLabel(""); 
         labelTelefonoVal.setFont(new Font("Arial", Font.PLAIN,12)); 
         labelTelefonoVal.setSize(250, 30); 
         labelTelefonoVal.setLocation(350, 250); 
         c.add(labelTelefonoVal); 
         
        add = new JLabel("Dirección"); 
        add.setFont(new Font("Arial", Font.PLAIN, 20)); 
        add.setSize(100, 20); 
        add.setLocation(75, 300); 
        c.add(add); 
  
        tadd = new JTextArea(); 
        tadd.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tadd.setSize(300, 200); 
        tadd.setLocation(200, 300); 
        tadd.setLineWrap(true); 
        c.add(tadd); 
        
        labelDirVal = new JLabel(""); 
        labelDirVal.setFont(new Font("Arial", Font.PLAIN,12)); 
        labelDirVal.setSize(300, 30); 
        labelDirVal.setLocation(200, 500); 
        c.add(labelDirVal); 
        
  
        sub = new JButton("Comprar"); 
        sub.setFont(new Font("Arial", Font.PLAIN, 20)); 
        sub.setSize(150, 50); 
        sub.setLocation(200, 550); 
        sub.addActionListener(this); 
        c.add(sub); 
  

  
        setVisible(true); 
    } 
  
    // method actionPerformed() 
    // to get the action performed 
    // by the user and act accordingly 
    public void actionPerformed(ActionEvent e) 
    { 
    	tamano= this.tam_grp.getSelection().getActionCommand();
    	estilo= this.estilo_grp.getSelection().getActionCommand();
    	tipo= this.tipo_grp.getSelection().getActionCommand();
    	boolean valiFon = validTel(telefono.getText());
    	boolean valDir = !tadd.getText().isEmpty();
    	
    
    	if(!valiFon ){
    		this.labelTelefonoVal.setText("* porfavor llene los campos correctamente");
    	}else {
    		this.labelTelefonoVal.setText("");
    	}
    	
    	if(!valDir){
    		this.labelDirVal.setText("* porfavor llene los campos correctamente");
    	}else {
    		this.labelDirVal.setText("");
    	}
    	if(valiFon && valDir) {
    		 try {
 				Socket socket1 = new Socket("192.168.1.101" , 9999);
 				ObjectOutputStream ObjSaliente = new ObjectOutputStream(socket1.getOutputStream());
				paquete.setTipo_objeto(2);
				OrdenDeCompra orden = new OrdenDeCompra();
				orden.setDireccion(tadd.getText());
				orden.setEstilo(estilo);
				orden.setTamano(tamano);
				orden.setTelefono(telefono.getText());
				orden.setTipo(tipo);
				paquete.setOrden(orden);
				ObjSaliente.writeObject(paquete);
				
				

		       	ObjectInputStream paqueteResp = new ObjectInputStream(socket1.getInputStream());
		       	paquete = (PaqueteObjetos) paqueteResp.readObject();
		       	JOptionPane.showMessageDialog(this, "SU PEDIDO FUE REALIZADO CON EXITO \n FOLIO : "+paquete.getOrden().getIdPedido()+"\n TOTAL = "+ paquete.getOrden().getPrecio() + "\nLLEGARA ALA DIRECCION : " + paquete.getOrden().getDireccion()  );
		       	tadd.setText("");
		       	telefono.setText("");
		       	
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
    	
    } 
    public boolean validTel(String esTel ) {
        String pattern ="^(\\d{3}[- .]?){2}\\d{4}$";
        return esTel.matches(pattern);

        
    }
    
}