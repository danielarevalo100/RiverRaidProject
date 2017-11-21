
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel
 */
public class Juego extends JPanel {
    int puntos;
    JLabel JLabelPuntaje;
    HelicopteroDer helicoptero;
    Bala balas;
    Avion avion;
    Barco barco;
    Timer timerBarco,timerGenerarB,timerBala,timerGenerarHeli,timerMoverHeli;
    Random random;
    ArrayList <Barco> enemigos ;
    ArrayList <mapa> mapas;
    int alpha;
    boolean perder;
    
    public Juego(){
        
        this.setFocusable(true);
        puntos=0;
        balas=null;
        perder=false;
        
        this.setPreferredSize(new Dimension(800, 600));
        //this.requestFocus();
        //this.requestDefaultFocus();
        this.setBackground(Color.blue);
        this.setLayout(null);
        
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
           
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                if (!perder) {
                    timerBarco.start();
                    timerGenerarB.start();
                    timerBala.start();
                    timerGenerarHeli.start();
                    if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
                        avion.moverse(1);
                    }

                    if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
                        avion.moverse(2);
                    }
                    
                    if (ke.getKeyCode() == KeyEvent.VK_UP) {
                        timerBarco.setDelay(1);
                    }

                    if (ke.getKeyCode() == KeyEvent.VK_SPACE && balas == null) {
                        balas = new Bala(avion.getPosX() + 32, avion.getPosY());

                    }
                }
                
                
                
                
                
                
                
                
                repaint();
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                   if (ke.getKeyCode() == KeyEvent.VK_UP) {
                        timerBarco.setDelay(20);
                    }
            }
        });
        
        JLabelPuntaje= new JLabel("Puntuacion: 0");
        JLabelPuntaje.setBounds(30,10,250,50);
        JLabelPuntaje.setForeground(Color.white);
        JLabelPuntaje.setFont(new Font("Arial", Font.PLAIN, 25));
        
        avion= new Avion();
        enemigos= new ArrayList<Barco>();
        mapas= new  ArrayList<>();
        hacerMapa();
       //enemigos.add(new Barco());
       timerGenerarHeli= new Timer(2000, generarHelicopteroD);
       timerMoverHeli= new Timer(5, moverHeli);
        timerBarco= new Timer(20,moverBarco );
        timerGenerarB=new Timer(1000,generarBarco);
        timerBala= new Timer(5, moverbala);
        alpha =-160;
        this.add(JLabelPuntaje);
        this.setVisible(false);
        
        
        
        
    }
    ActionListener moverHeli = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            
            if (helicoptero!=null) {
                if (helicoptero.getTipo()==0) {
                    helicoptero.setPosX(helicoptero.getPosX()+2);
                    repaint();
                    if (helicoptero.getPosX()>800) {
                        helicoptero=null;
                    }
                }
                else if (helicoptero.getTipo()==1) {
                    helicoptero.setPosX(helicoptero.getPosX()-2);
                    repaint();
                    if (helicoptero.getPosX()<-99) {
                        helicoptero=null;
                    }
                }
            }
            
        }
    };
    
    ActionListener generarHelicopteroD= new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (helicoptero==null) {
                Random x= new Random();
                int y,tipo;
                tipo=x.nextInt(2);
                System.out.println(tipo);
                y=x.nextInt(400);
               
                helicoptero= new HelicopteroDer(y,tipo);
                timerMoverHeli.start();
            }
        }
            
        
    };
        
        
    
    
    
    
    /**
     * ActionListener moverbala es llamado por un temporizador el cual se ancargará de mover la bala disparada por el avion 
     * a una velocidad constante.
     */
    ActionListener moverbala= new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (balas!=null) {
                
                for (mapa map: mapas) {
                    if (balas.area().intersects(map.area())) {
                        balas=null;
                        break;
                    }
                }
            }
            if (balas!=null&&helicoptero!=null) {
                if (balas.area().intersects(helicoptero.area())) {
                    puntos+=200;
                    JLabelPuntaje.setText("Puntuacion: "+Integer.toString(puntos));
                    helicoptero=null;
                    balas=null;
                }
            }
            
            if (balas!=null) {
                if (balas.getPosY()<0) {
                    balas=null;
                }else{
                    balas.setPosY(balas.getPosY()-5);
                }  
            }
                
           
        }
    };
    /**
     *  
     * Action Listener generarBarco, se encarga de generar un numero aleatorio que sera la posicion en X del nuevo barco
     * , ya que la pocision en Y del mismo siempre es constante para que aparezca fuera del area visible.
     * 
     * Todo esto lo realiza verificando que el rectangulo que ocupa el barco no se intersecte con ningun rectangulo del mapa, para que asi
     * no se produzca un barco sobre la tierra;
     */
    ActionListener generarBarco = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
                Rectangle2D rectangulo;
                int cont=100;
                boolean band = true;
            Random r = new Random();
            int posX;
            do {

                 posX = r.nextInt(800);
                rectangulo = new Rectangle2D.Double(posX, -80, 100, 40);
                for (mapa map : mapas) {
                    if (rectangulo.intersects(map.area())) {
                        band = false;
                    }
                }
                cont--;
            } while (band == false&&cont>0);
        
            if(band==true)enemigos.add(new Barco(posX));
                    
                
                    
                
                
                
                repaint();
           } 
           
            
        
    };
    
    
    ActionListener moverBarco = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            //System.out.println(mapas.get(0).getPosY());
            if (alpha==-80) {
                Random x = new Random();
                int posX;
                
                posX= x.nextInt(240);
                
                mapas.add(new mapa((0-posX)));
                mapas.add(new mapa((550+posX)));
                repaint();
                alpha=-160;
                
                
            }
            //System.out.println(mapas.size());
            for (mapa map: mapas) {
                if (map.getPosY()>600) {
                   mapas.remove(map);
                   break;
                }
                
                map.setPosY(map.getPosY()+1);
                
                
            }
            
            choqueMapa();
            choqueBarco();
            alpha = alpha +1;
            if (helicoptero!=null) {
                helicoptero.setPosY(helicoptero.getPosY()+1);
            }
            for (Barco barco: enemigos) {
                
                
                if (balas!=null&&barco.area().intersects(balas.area())) {
                    puntos+=100;
                    JLabelPuntaje.setText("Puntuacion: "+Integer.toString(puntos));
                    balas=null;
                    
                    
                    enemigos.remove(barco);
                    break;
                    
                }
                
                if (barco.getPosY()==600) {
                    
                    enemigos.remove(barco);
                    break;
                }
                
                else {
                    barco.setPosY(barco.getPosY()+1);
                }
                
                //System.out.println(enemigos.size());
            }
            
            
            
            
            repaint();
        }
            
            
    };   
            
            

            
    public void hacerMapa(){
        
        int y=-160;
        for (int i = 0; i < 10; i++) {
            mapa cuadro = new mapa(y,-50);
            mapa cuadro2 = new mapa(y,600);
            mapas.add(cuadro);
            mapas.add(cuadro2);
            y=y+80;
        }
        
        repaint();
        
    }
    
    /**
     * La funcion choqueMapa se encarga de chequear que el rectangulo de el avion no se intersecte con ningun rectangulo
     * de tipo mapa.
     * 
     * se logra al recorrer todos los rectangulos mapas e intersectarlos con el rectangulo del avion, de ser asi se perdera una vida
     * se destruira el barco y avion. Se reestablecera la pocision inicial X del avion.
     */
    public void choqueMapa(){
        for(mapa map: mapas){
            if (avion.area().intersects(map.area())) {
                  //System.out.println("perdio una vida");
                  avion.setVidas(avion.getVidas()-1);
                  if (avion.getVidas()>0) {
                      //System.out.println("ha perdido una vida");
                      
                      avion.setPosX(350);
                   }else{
                      //System.out.println("ha perdido el juego");
                      timerBarco.stop();timerGenerarB.stop();
                      perder=true;
                  }


            }
        }
    
    }
    /**
     * La funcion choqueBarco se encarga de chequear que el rectangulo del avion no se intersecte con ningun rectangulo de los barcos que existan
     * 
     */
     public void choqueBarco(){
        for(Barco barco: enemigos){
            if (avion.area().intersects(barco.area())) {
                  //System.out.println("perdio una vida");
                  avion.setVidas(avion.getVidas()-1);
                  
                  if (avion.getVidas()>0) {
                    //  System.out.println("ha perdido una vida");
                      avion.setPosX(350);
                   }else{
                      //System.out.println("ha perdido el juego");
                      timerBarco.stop();timerGenerarB.stop();
                      perder=true;
                  }
                  enemigos.remove(barco);
                  break;


            }
        }
    
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        Graphics2D g2= (Graphics2D)g;
        
        if (!(balas==null))balas.draw(g2); 
        avion.draw( g2);
        if(!(balas==null))g2.draw(balas.area());
        for (Barco barco : enemigos) {
            barco.draw(g2);
        }
 
        for (mapa map : mapas ) {
            map.draw(g2);
        }
        
        if (helicoptero!=null) {
            helicoptero.draw(g2);
        }
     
        
        
        
    }
    
    

    
    
}
