
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;
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
    Bala balas;
    Avion avion;
    Barco barco;
    Timer timerBarco,timerGenerarB,timerBala;
    Random random;
    ArrayList <Barco> enemigos ;
    ArrayList <mapa> mapas;
    int alpha;
    boolean perder;
    
    public Juego(){
        
        this.setFocusable(true);
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
        
        
        avion= new Avion();
        enemigos= new ArrayList<Barco>();
        mapas= new  ArrayList<>();
        hacerMapa();
       // enemigos.add(new Barco());
        timerBarco= new Timer(20,moverBarco );
        timerGenerarB=new Timer(1000,generarBarco);
        timerBala= new Timer(5, moverbala);
        alpha =-160;
        
        this.setVisible(false);
        
        
        
        
    }
    ActionListener moverbala= new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (balas!=null) {
                if (balas.getPosY()<0) {
                    balas=null;
                }else{
                    balas.setPosY(balas.getPosY()-5);
                }
                
            }
        }
    };
    
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
            
            for (Barco barco: enemigos) {
                
                
                if (balas!=null&&barco.area().intersects(balas.area())) {
                    
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
                
                System.out.println(enemigos.size());
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
    public void choqueMapa(){
        for(mapa map: mapas){
            if (avion.area().intersects(map.area())) {
                  System.out.println("perdio una vida");
                  avion.setVidas(avion.getVidas()-1);
                  if (avion.getVidas()>0) {
                      System.out.println("ha perdido una vida");
                      avion.setPosX(350);
                   }else{
                      System.out.println("ha perdido el juego");
                      timerBarco.stop();timerGenerarB.stop();
                      perder=true;
                  }


            }
        }
    
    }
    
     public void choqueBarco(){
        for(Barco barco: enemigos){
            if (avion.area().intersects(barco.area())) {
                  System.out.println("perdio una vida");
                  avion.setVidas(avion.getVidas()-1);
                  
                  if (avion.getVidas()>0) {
                      System.out.println("ha perdido una vida");
                      avion.setPosX(350);
                   }else{
                      System.out.println("ha perdido el juego");
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
     
        
        
        
    }
    
    

    
    
}
