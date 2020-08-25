/**
 * 
 */
package DominosCliente;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

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
	
    private JLabel title; 
    private JLabel name; 
    private JTextField tname; 
    private JLabel gender; 
    private JRadioButton male; 
    private JRadioButton female; 
    private ButtonGroup gengp; 
    private JLabel dob; 
    private JComboBox date; 
    private JComboBox month; 
    private JComboBox year; 
    private JLabel add; 
    private JTextArea tadd; 
    private JCheckBox term; 
    private JButton sub; 
    private JButton reset; 
    private JTextArea tout; 
    private JLabel res; 
    private JTextArea resadd; 
  
    private String dates[] 
        = { "1", "2", "3", "4", "5", 
            "6", "7", "8", "9", "10", 
            "11", "12", "13", "14", "15", 
            "16", "17", "18", "19", "20", 
            "21", "22", "23", "24", "25", 
            "26", "27", "28", "29", "30", 
            "31" }; 
    private String months[] 
        = { "Jan", "feb", "Mar", "Apr", 
            "May", "Jun", "July", "Aug", 
            "Sup", "Oct", "Nov", "Dec" }; 
    private String years[] 
        = { "1995", "1996", "1997", "1998", 
            "1999", "2000", "2001", "2002", 
            "2003", "2004", "2005", "2006", 
            "2007", "2008", "2009", "2010", 
            "2011", "2012", "2013", "2014", 
            "2015", "2016", "2017", "2018", 
            "2019" }; 
  
    // constructor, to initialize the components 
    // with default values. 
    public VentanaSelectora() 
    { 
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
        c.add(familiar); 
        mediana = new JRadioButton("Mediana"); 
        mediana.setFont(new Font("Arial", Font.PLAIN, 15)); 
        mediana.setSelected(true); 
        mediana.setSize(100, 30); 
        mediana.setLocation(300, 100); 
        c.add(mediana);
        personal = new JRadioButton("Personal"); 
        personal.setFont(new Font("Arial", Font.PLAIN, 15)); 
        personal.setSelected(true); 
        personal.setSize(100, 30); 
        personal.setLocation(400, 100); 
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
        c.add(espe); 
        
        sarten = new JRadioButton("Sarten"); 
        sarten.setFont(new Font("Arial", Font.PLAIN, 15)); 
        sarten.setSelected(true); 
        sarten.setSize(100, 30); 
        sarten.setLocation(300, 150); 
        c.add(sarten);
        
        orilla = new JRadioButton("Orilla de Queso"); 
        orilla.setFont(new Font("Arial", Font.PLAIN, 15)); 
        orilla.setSelected(true); 
        orilla.setSize(150, 30); 
        orilla.setLocation(400, 150); 
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
         c.add(peperoni);
         hawaiana = new JRadioButton("Hawaina");   
         hawaiana.setFont(new Font("Arial", Font.PLAIN, 15)); 
         hawaiana.setSelected(true); 
         hawaiana.setSize(100, 30); 
         hawaiana.setLocation(300, 200); 
         c.add(hawaiana);
         mexicana  = new JRadioButton("Mexicana");
         mexicana.setFont(new Font("Arial", Font.PLAIN, 15)); 
         mexicana.setSelected(true); 
         mexicana.setSize(100, 30); 
         mexicana.setLocation(400, 200); 
         c.add(mexicana);
         queso = new JRadioButton("Queso");
         queso.setFont(new Font("Arial", Font.PLAIN, 15)); 
         queso.setSelected(true); 
         queso.setSize(100, 30); 
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
       
    } 
}