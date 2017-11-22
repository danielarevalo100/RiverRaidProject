import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author YAVD
 */
public class panel2 extends JPanel{
    
    Personaje2 a;
    Personaje2 bala = null;
    ArrayList<mapa2>m;
    Timer t, tiempoe, generacion;
    ArrayList<Personaje2>enemigos;
    Ventanas v;
    int aux, aux1, aux2;
    

    public panel2(Ventanas v) {
        this.v=v;
        setLayout(null);
        setBackground(Color.WHITE);
        setFocusable(true);
        setBackground(Color.BLUE);
        setPreferredSize(new Dimension(800, 600));
        a=new Personaje2(this.getClass().getResource("/Imagenes/Avion.png"),50,350);
        enemigos= new ArrayList<>();
        m=new ArrayList<>();
        
        
        addKeyListener(tecla);
        
        t = new Timer(50, tavion);
        t.start();
        tiempoe = new Timer(100, tiempo);
        tiempoe.start();
        generacion = new Timer(1000, crear);
        generacion.start();
    }
    
    
    KeyListener tecla=new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()==KeyEvent.VK_UP)
            {
                t.stop();
                aux-=10;
                a.setPosy(aux);
                repaint();
                
            }
            
            if(bala==null)
            {
                if(e.getKeyCode()==KeyEvent.VK_SPACE)
            {
                bala=new Personaje2(this.getClass().getResource("/Imagenes/Bala.png"), a.getPosx(),a.getPosy());
                bala.setHeigh(10);
                bala.setWidth(20);
            }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            
            if(e.getKeyCode()==KeyEvent.VK_UP)
            {
                t.start();
                
                
            }
            
            
        }
    };
    
    ActionListener tiempo = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            

            for (int i = 0; i < enemigos.size(); i++) {

                enemigos.get(i).posx -= 10;
                if (enemigos.get(i).area().intersects(a.area())) {
                    System.exit(0);
                }

                if (bala != null) {
                    if (enemigos.get(i).area().intersects(bala.area())) {
                        enemigos.remove(i);
                        bala = null;
                        aux2 = a.posx;
                    }
                }

            }

            if (bala != null) {

                aux2 += 50;
                bala.setPosx(aux2);

                if (bala.getPosx() > 900) {

                    bala = null;
                    aux2 = a.posx;
                }

            }

            

            for (int i = 0; i < m.size(); i++) {

                m.get(i).posx -= 10;

            }

            for (int i = 0; i < m.size(); i++) {

                for (int j = 0; j < enemigos.size(); j++) {

                    if (enemigos.get(j).area().intersects(m.get(i).area())) {
                        enemigos.remove(j);
                    }
                    

                }
                if(m.get(i).area().intersects(a.area())){
                        System.exit(0);
                    }
                if(bala!=null){
                    if(m.get(i).area().intersects(bala.area())){
                    bala = null;
                    aux2 = a.posx;
                }
                }
            }
            
            

            repaint();

        }
    };

    ActionListener tavion = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            aux += 10;
            a.setPosy(aux);
            repaint();

        }
    };

    ActionListener crear = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Random r = new Random();

            int aux3;

            aux3 = r.nextInt(600);
            enemigos.add(new Personaje2(this.getClass().getResource("/Imagenes/helicopteroIzquierda.png"), getWidth(), aux3));
            
            Random r1 = new Random();
            int aux5, aux6;
            aux5 = r1.nextInt(150);
            aux6 = r1.nextInt(290) + 350;

            m.add(new mapa2(getWidth(), aux6));
            m.add(new mapa2(getWidth(), (-500 + aux5)));

        }
    };

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        Graphics2D g1=(Graphics2D)g;
        
        g1.drawImage(a.getImagen().getImage(), a.getPosx(), a.getPosy(), a.getWidth(), a.getHeigh(), this);
        
        
        if(enemigos.isEmpty()){
            
        }else{
            for (int i = 0; i < enemigos.size(); i++) {
            
            if(enemigos.get(i)!=null){
                g1.drawImage(enemigos.get(i).getImagen().getImage(), enemigos.get(i).getPosx(), enemigos.get(i).getPosy(), enemigos.get(i).getWidth(), enemigos.get(i).getHeigh(), this);
            }
            
            
        }
        }
        
        
        if(bala!=null){ 
            
            g1.drawImage(bala.getImagen().getImage(), bala.getPosx(), bala.getPosy(), bala.getWidth(), bala.getHeigh(), this);
        }
        
        if(!(m.isEmpty())){
            for (int i = 0; i < m.size(); i++) {
                
                g1.drawImage(m.get(i).getImagen().getImage(), m.get(i).getPosx(), m.get(i).getPosy(), m.get(i).getWidth(), m.get(i).getHeigh(), this);
                
                
            }
        }
        
    }
    
    
    
}