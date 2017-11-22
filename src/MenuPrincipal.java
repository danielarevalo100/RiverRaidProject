
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.FocusManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/** Menu principal el jugador decide entre una serie de opciones dadas a traves de botones, puede decidir entre empezar el juego,
 * leer las instrucciones, ver los creditos, observar los mejores jugadores y salir.
 * 
 * 
 *
 * @author Daniel
 */
public class MenuPrincipal extends JPanel {
    private Ventanas dueño;
    private JButton salir,jugarBoton,jugarBoton2,insBoton,creditosBoton,top10;
    
    private final ImageIcon fondo;
    public MenuPrincipal(Ventanas dueños){
        
        this.dueño=dueños;
        this.setLayout(null);
        this.setFocusable(true);
        jugarBoton= new JButton("JUGAR");
        jugarBoton.setFocusable(false);
        jugarBoton.setBackground(new Color(170, 38, 75));
        jugarBoton.setFont(new Font("Arial", Font.PLAIN, 35));
        jugarBoton.setForeground(Color.white);
        jugarBoton.setSize(200, 80);
        jugarBoton.setVisible(true);
        jugarBoton.setLocation(300, 150);
        jugarBoton.setBorderPainted(false);
        
        
        
        jugarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                   try{
                    System.out.println(FocusManager.getCurrentManager().getFocusOwner().toString());
                }catch(Exception ex){
                    System.out.println("nadie tiene el focus");
                }
                dueño.iniciarJuego();
                
            }
        });
        
        jugarBoton2= new JButton("JUGAR");
        jugarBoton2.setFocusable(false);
        jugarBoton2.setBackground(new Color(170, 38, 75));
        jugarBoton2.setFont(new Font("Arial", Font.PLAIN, 18));
        jugarBoton2.setForeground(Color.white);
        jugarBoton2.setSize(100, 50);
        jugarBoton2.setVisible(true);
        jugarBoton2.setLocation(690, 550);
        jugarBoton2.setBorderPainted(false);
        jugarBoton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dueño.iniciarJuego2();
            }
        });
        
        insBoton= new JButton("INSTRUCCIONES");
        insBoton.setFocusable(false);
        insBoton.setBackground(new Color(170, 38, 75));
        insBoton.setFont(new Font("Arial", Font.PLAIN, 20));
        insBoton.setForeground(Color.white);
        insBoton.setSize(200, 80);
        insBoton.setVisible(true);
        insBoton.setLocation(300, 250);
        insBoton.setBorderPainted(false);
        insBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dueño.instruc();
            }
        });
        
        
        creditosBoton= new JButton("CREDITOS");
        creditosBoton.setFocusable(false);
        creditosBoton.setBackground(new Color(170, 38, 75));
        creditosBoton.setFont(new Font("Arial", Font.PLAIN, 20));
        creditosBoton.setForeground(Color.white);
        creditosBoton.setSize(200, 80);
        creditosBoton.setVisible(true);
        creditosBoton.setLocation(300, 350);
        creditosBoton.setBorderPainted(false);
        creditosBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dueño.creditos();
            }
        });
        
        top10=new JButton("TOP 10");
         top10.setFocusable(false);
        top10.setBackground(new Color(170, 38, 75));
        top10.setFont(new Font("Arial", Font.PLAIN, 20));
        top10.setForeground(Color.white);
        top10.setSize(200, 80);
        top10.setVisible(true);
        top10.setLocation(300, 450);
        top10.setBorderPainted(false);
        top10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    dueño.top10();
                } catch (IOException ex) {
                    Logger.getLogger(MenuPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        salir=new JButton("Salir");
        salir.setFocusable(false);
        salir.setBackground(new Color(170, 38, 75));
        salir.setFont(new Font("Arial", Font.PLAIN, 20));
        salir.setForeground(Color.white);
        salir.setSize(100, 50);
        salir.setVisible(true);
        salir.setLocation(10, 550);
        salir.setBorderPainted(false);
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        
        fondo=new ImageIcon(this.getClass().getResource("/Imagenes/fondoMenu.jpg"));
        this.setFocusable(false);
        this.setPreferredSize(new Dimension(800, 600));
        this.add(insBoton);
        this.add(jugarBoton2);
        this.add(creditosBoton);
        this.add(jugarBoton);
        this.add(top10);
        this.add(salir);
        
        
        this.setVisible(true);
        
        
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        
        System.out.println();
        
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(fondo.getImage(),0,0,800, 600, this);
       
    }
    
    

}  
