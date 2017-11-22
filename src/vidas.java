
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
public class vidas extends Personajes {

    public vidas(int pos) {
        
        this.posX=pos;
        this.posY=500;
        this.width=40;
        this.height=40;
        
        this.imagen=new ImageIcon(this.getClass().getResource("/Imagenes/corazon.png"));
        
    }
    
    
    
}
