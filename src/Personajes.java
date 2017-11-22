
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;
import java.net.URL;

import javax.swing.ImageIcon;



/** La clase personaje, se considera una clase muy importante en este juego, ya que es la clase padre de los demas elementos que este implica,
 * tanto el avion como barcos y hasta los helicopteros son hijos de esta clase, ya que cuenta con ciertos atributos muy importantes en cada 
 * componente, lo que la hace comportarse como una clase generica abarcando practicamente el juego entero.
 *
 * @author Daniel
 */
public class Personajes {
    
    int posX, posY, width, height;
    ImageIcon imagen;
    URL url;
    
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

    public void setImagen(ImageIcon imagen) {
        
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
    /**
     * la funcion Rectangle2D se encarga de retornar un rectangulo con sus atributos iguales a la posicion de el personaje.
     * @return 
     */
    public Rectangle2D area(){
     return new Rectangle2D.Double(posX, posY, width, height);
             
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }
    
    
}
