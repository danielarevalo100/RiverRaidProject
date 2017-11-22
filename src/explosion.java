
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
public class explosion extends Personajes {

    int seg;
    
    public explosion(int x,int y) {
        
        this.seg=0;
        
        this.posX=x;
        this.posY=y;
        this.width=70;
        this.height=70;
        this.imagen=new ImageIcon(this.getClass().getResource("/Imagenes/Explosion.png"));
        
    }

    public int getSeg() {
        return seg;
    }

    public void setSeg(int seg) {
        this.seg = seg;
    }
    
    
    
    
}
