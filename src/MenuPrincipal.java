
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.FocusManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel
 */
public class MenuPrincipal extends JPanel {
    private Ventanas dueño;
    private JButton jugarBoton,insBoton,creditosBoton;
    
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
        
        
        
        insBoton= new JButton("INSTRUCCIONES");
        insBoton.setFocusable(false);
        insBoton.setBackground(new Color(170, 38, 75));
        insBoton.setFont(new Font("Arial", Font.PLAIN, 20));
        insBoton.setForeground(Color.white);
        insBoton.setSize(200, 80);
        insBoton.setVisible(true);
        insBoton.setLocation(300, 250);
        insBoton.setBorderPainted(false);
        
        creditosBoton= new JButton("CREDITOS");
        creditosBoton.setFocusable(false);
        creditosBoton.setBackground(new Color(170, 38, 75));
        creditosBoton.setFont(new Font("Arial", Font.PLAIN, 20));
        creditosBoton.setForeground(Color.white);
        creditosBoton.setSize(200, 80);
        creditosBoton.setVisible(true);
        creditosBoton.setLocation(300, 350);
        creditosBoton.setBorderPainted(false);
        
        
        
        fondo=new ImageIcon(this.getClass().getResource("/Imagenes/fondoMenu.jpg"));
        this.setFocusable(false);
        this.setPreferredSize(new Dimension(800, 600));
        this.add(insBoton);
        this.add(creditosBoton);
        this.add(jugarBoton);
        
        
        this.setVisible(true);
        
        
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        
        System.out.println();
        
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(fondo.getImage(),0,0,800, 600, this);
       
    }
    
    

}  
