
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
public class medidor extends Personajes{

    public medidor() {
        
        this.posX=630;
        this.posY=500;
        this.width=150;
        this.height=50;
        
        this.imagen=new ImageIcon(this.getClass().getResource("/Imagenes/medidor.png"));
        
    }
    
    
    
}
