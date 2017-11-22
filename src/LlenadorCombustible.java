
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
public class LlenadorCombustible extends Personajes {

    public LlenadorCombustible(int x) {
        
        this.posX=x;
        this.posY=-80;
        this.width=40;
        this.height=60;     
        this.url=this.getClass().getResource("/Imagenes/combustible.jpg");
        this.imagen= new ImageIcon(url);
    }
    
}
