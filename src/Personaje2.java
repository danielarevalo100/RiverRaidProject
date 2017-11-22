import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author YAVD
 */
public class Personaje2 {
    
    int posx,posy,width,heigh;
    ImageIcon imagen;
    URL url;

    public Personaje2(URL url,int posx,int posy) {
        
        this.posx=posx;
        this.posy=posy;
        width=70;
        heigh=70;
        this.url=url;
        imagen=new ImageIcon(url);
        
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeigh(int heigh) {
        this.heigh = heigh;
    }

    
    
    public int getPosx() {
        return posx;
    }

    public int getPosy() {
        return posy;
    }

    public int getWidth() {
        return width;
    }

    public int getHeigh() {
        return heigh;
    }

    public ImageIcon getImagen() {
        return imagen;
    }
    
    
    
    
    Rectangle2D area(){
        
        return new Rectangle2D.Double(posx, posy, width, heigh);
        
    }
    
}