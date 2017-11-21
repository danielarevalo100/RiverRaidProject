
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

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
public class Personajes {
    
    int posX, posY, width, height;
    ImageIcon imagen;
    
    public Personajes(){
    
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
    
    public void draw(Graphics2D g){
        
       g.drawImage(imagen.getImage(),posX,posY,this.width, this.height, null);
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
    
    public Rectangle2D area(){
     return new Rectangle2D.Double(posX, posY, width, height);
             
    }

    public ImageIcon getImagen() {
        return imagen;
    }
    
    
}
