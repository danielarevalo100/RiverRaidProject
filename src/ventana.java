
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
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
public class ventana extends JFrame {
    Ventanas Ventana;
    public ventana(){
        Ventana= new Ventanas();
       
        
        this.setContentPane(Ventana);
        this.setFocusable(false);
        this.setTitle("River Raid");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       // this.setPreferredSize(new Dimension(800, 600));
       this.setSize(810, 645);
        this.setResizable(true);
        this.setVisible(true);
        
    }
    
   

    
}
