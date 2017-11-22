
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
public class aguja extends Personajes {

    public aguja(int pos) {
        
        this.posX=pos;
        this.posY=539;
        this.width=8;
        this.height=8;
        
        this.imagen=new ImageIcon(this.getClass().getResource("/Imagenes/Aguja.png"));
        
    }
    
    

    
}
