
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
    public ventana() throws IOException{
        Ventana= new Ventanas();
       
        this.setIconImage(ImageIO.read(new File("src/Imagenes/Avion.png/")));
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
