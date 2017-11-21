
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
public class mapa extends Personajes{

    public mapa(int x) {
        this.posX=x;
        this.posY=-160;
        this.height=80;
        this.width=250;
        this.imagen=new ImageIcon(this.getClass().getResource("/Imagenes/mapa.jpg"));
        
    }
    
    public mapa(int y , int x) {
        
        this.posX=x;
        this.posY=y;
        this.height=80;
        this.width=250;
        this.imagen=new ImageIcon(this.getClass().getResource("/Imagenes/mapa.jpg"));
        
    }
    
}
