
import java.awt.Rectangle;
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
public class Bala extends Personajes {

    
        
    public Bala(int x,int y) {
        this.posX=x;
        this.posY=y;
        this.width=10;
        this.height=8;     
        
        this.imagen= new ImageIcon(this.getClass().getResource("/Imagenes/Bala.png"));
        
    }
    
    
}
