
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
public class HelicopteroDer extends Personajes {
        int tipo;
    public HelicopteroDer(int y,int tipo) {
        this.tipo=tipo;
        if (this.tipo==0) {
            this.posX=-150;
            this.url=this.getClass().getResource("/Imagenes/helicopteroDerecha.png");
        }
        if (this.tipo==1) {
            this.posX=850;
            this.url=this.getClass().getResource("/Imagenes/helicopteroIzquierda.png");
        }
        
        this.posY=y;
        this.width=100;
        this.height=40;     
        
        this.imagen= new ImageIcon(url);
        
        
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
}
