
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel
 */
public class Barco extends Personajes {
    Random posiciones;
    public Barco(int x) {
        
        
        
        this.posX=x;
        this.posY=-80;
        this.width=100;
        this.height=40;     
        
        this.imagen= new ImageIcon(this.getClass().getResource("/Imagenes/barco.png"));
        
    }
    
}
