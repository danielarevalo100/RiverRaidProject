
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
public class Avion extends Personajes {
    
    int vidas;

    public Avion() {
        
        this.width=70;
        this.height=130;
        this.posX=350;
        this.posY=470;
        this.vidas=3;
        this.url=this.getClass().getResource("/Imagenes/Avion.png");
        this.imagen= new ImageIcon(url);
        
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int getVidas() {
        return vidas;
    }
    
    
    public void moverse(int dir){
        switch(dir){
           
            
            case 1:
                this.posX-=15;
            break;    
            
            case 2:
                this.posX+=15;
            break;    
        }
    }
    
    
    
}
