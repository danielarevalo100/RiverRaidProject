
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**El avion es el protagonista de este juego, siendo el jugador quien lo conduce,este avion, hijo de la clase Personajes,
 * cuenta con ciertos atributos de mas.
 * 
 * Las vidas: el avion cuenta con 3 vidas desde su inicio, al perder las 3 el juego finalizaria.
 * 
 * Atributo("gas"): Este atrubuto se creo para llevar de manera eficiente el control de combustible que el avion acarrea
 * ya que de quedarce sin este recurso perderia una vida.
 *
 * @author Daniel
 */
public class Avion extends Personajes {
    
    int vidas;
    int gas=150;

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
