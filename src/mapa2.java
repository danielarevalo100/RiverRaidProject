import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author YAVD
 */
public class mapa2 {
    
    int posx,posy,width,heigh;
    ImageIcon imagen;
    URL url;

    public mapa2(int pox, int posy) {
        this.posx = pox;
        this.posy = posy;
        
        width=200;
        heigh=500;
        
        url=this.getClass().getResource("/Imagenes/mapa.jpg");
        imagen=new ImageIcon(url);
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

    public URL getUrl() {
        return url;
    }
    
    Rectangle2D area(){
        
        return new Rectangle2D.Double(posx, posy, width, heigh);
        
    }

 
        
        
    
    
    
    
}
