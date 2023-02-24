
import java.applet.AudioClip;
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

public class Juego extends JPanel {
    LlenadorCombustible combustible;
    int puntos,min,seg;
    JLabel JLabelPuntaje,tiempo;
    HelicopteroDer helicoptero;
    Bala balas;
    medidor indicador;
    Avion avion;
    ArrayList <explosion> explot ;    
    vidas[]nvid;
    Barco barco;
    aguja aguja;
    Timer timerBarco,timergame,tiempogas,timerGenerarB,timerBala,timerGenerarHeli,timerMoverHeli,timerCombustible;
    Random random;
    ArrayList <Barco> enemigos ;
    ArrayList <mapa> mapas;
    int alpha;
    Ventanas v;
    boolean perder,son;
    
    public Juego(Ventanas v){
        this.v=v;
        this.setFocusable(true);
        puntos=0;
        min=1;seg=30;
        balas=null;
        perder=false;
        nvid=new vidas[3];
        son=true;
        for (int i = 0; i < nvid.length; i++) {
            nvid[i]=new vidas(50*i);
        }
        indicador=new medidor();
        aguja=new aguja(770);
        
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
                if (son) {
                     AudioClip sonido2;
                    sonido2=java.applet.Applet.newAudioClip(this.getClass().getResource("/sonidos/nota.wav"));
                    
                    sonido2.loop();
                    son=false;
                }
                if (!perder) {
                    timerCombustible.start();
                    timerBarco.start();
                    timerGenerarB.start();
                    timerBala.start();
                    timerGenerarHeli.start();
                    tiempogas.start();
                    timergame.start();
                   
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
                         AudioClip sonido2;
                            sonido2=java.applet.Applet.newAudioClip(this.getClass().getResource("/sonidos/disparo.wav"));

                            sonido2.play();
                        

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
        
        tiempo= new JLabel("1:30");
        tiempo.setBounds(650, 10, 200, 50);
        tiempo.setForeground(Color.white);
        tiempo.setFont(new Font("Arial", Font.PLAIN, 25));
        
        avion= new Avion();
        enemigos= new ArrayList<Barco>();
        mapas= new  ArrayList<>();
        explot=new ArrayList<>();
        hacerMapa();
       //enemigos.add(new Barco());
       timerGenerarHeli= new Timer(2000, generarHelicopteroD);
       timerMoverHeli= new Timer(5, moverHeli);
       timerCombustible= new Timer(2000, GenerarCombustible);
        timerBarco= new Timer(20,moverBarco );
        timerGenerarB=new Timer(2500,generarBarco);
        timerBala= new Timer(5, moverbala);
        timergame= new Timer(1000, cronometro);
        alpha =-160;
        this.add(JLabelPuntaje);
        this.add(tiempo);
        this.setVisible(false);
        tiempogas =new Timer(250, tgas);
        
        
        
        
    }
    ActionListener cronometro = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            seg--;
            if (seg==0) {
                if(seg==0&&min==0){
                    perder=true;
                }
                min--;
                seg=59;
                
            }
            
            tiempo.setText(Integer.toString(min)+":"+Integer.toString(seg));
            if (perder) {
                timerBala.stop();
                timerBarco.stop();
                timerCombustible.stop();
                timerGenerarB.stop();
                timerGenerarHeli.stop();
                timerMoverHeli.stop();
                timergame.stop();
                v.perdio();
            }
        }
    };
    ActionListener tgas=new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            aguja.setPosX(aguja.getPosX()-1);
            if(aguja.getPosX()==630){
                avion.setVidas(avion.getVidas()-1);
                aguja.setPosX(770);
                
                if (!(avion.getVidas()>0)) {
                    perder=true;
                    
                }
                    
                
            }
                
        }
    };
    
    ActionListener GenerarCombustible= new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (combustible == null) {
                Random r = new Random();
                int x, cont = 25;
                Rectangle2D rectangulo;
                boolean band = false;
                do {
                    band = false;
                    x = r.nextInt(800);
                    rectangulo = new Rectangle2D.Double(x, -80, 40, 60);
                    for (mapa map : mapas) {
                        if (map.area().intersects(rectangulo)) {
                            band = true;
                        }
                    }
                    for (Barco barco : enemigos) {
                        if (barco.area().intersects(rectangulo)) {
                            band = true;
                        }
                    }
                    cont--;
                } while (band==true && cont < 0);

                if (band == false) {
                    combustible = new LlenadorCombustible(x);
                    timerCombustible.stop();
                }
            }
            
        }
    };
    
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
                    AudioClip sonido;
                    sonido=java.applet.Applet.newAudioClip(this.getClass().getResource("/sonidos/bomba.wav"));
         
                    sonido.play();
                    explot.add(new explosion(helicoptero.getPosX(), helicoptero.getPosY()));
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
            if (balas!=null&&combustible!=null&&balas.area().intersects(combustible.area())) {
                balas=null;
                combustible=null;
                timerCombustible.start();
                puntos-=100;
                JLabelPuntaje.setText("Puntuacion: "+Integer.toString(puntos));
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
                int cont=20;
                boolean band = true;
            Random r = new Random();
            int posX;
            do {
                 band=true;
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
    
    /**
     * El ActionListener mover barco es basicamente el listener que llama el timer principal del juego, este mismo se encarga de mover
     * posicion el mapa los barcos y todos los objetos que tenga que desplazarse hacia abajo.
     * Se reduce la pocision de cada uno de estos pixel por pixel.
     */
    ActionListener moverBarco = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            //System.out.println(mapas.get(0).getPosY());
            
            for(explosion xp:explot){
                
                xp.setPosY(xp.getPosY()+1);
                xp.setSeg(xp.getSeg()+1);
                if (xp.getSeg()==50) {
                    explot.remove(xp);
                    break;
                }
                
            }
            
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
            chocarCombustible();
            choqueMapa();
            choqueBarco();
            chocarhelicoptero();
            alpha = alpha +1;
            if (helicoptero!=null) {
                helicoptero.setPosY(helicoptero.getPosY()+1);
            }
            if (combustible!=null) {
                combustible.setPosY(combustible.getPosY()+1);
            }
            if (combustible!=null&&combustible.getPosY()>600) {
                combustible=null;
                timerCombustible.start();
            }
            for (Barco barco: enemigos) {
                
                
                if (balas!=null&&barco.area().intersects(balas.area())) {
                    AudioClip sonido;
                    sonido=java.applet.Applet.newAudioClip(this.getClass().getResource("/sonidos/bomba.wav"));
         
                    sonido.play();
                    
                    puntos+=100;
                    JLabelPuntaje.setText("Puntuacion: "+Integer.toString(puntos));
                    balas=null;
                    
                    explot.add(new explosion(barco.getPosX(), barco.getPosY()));
                    
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
    /**
     * La funcion chocarCombustible verifica que cuando el rectangulo que posee el avion a su alrededor y el rectangulo
     * que posee el area de carga de combustible se intersecten aumentara el combustible proporcionalmente al tiempo en el que el avion se encuentre
     * sobre ella.
     */
    public void chocarCombustible(){
    
        if (combustible!=null&&combustible.area().intersects(avion.area())&&aguja.getPosX()<771) {
            tiempogas.stop();
            aguja.setPosX(aguja.getPosX()+1); 
        }
        
    }        
   /**
    * La funcion chocar helicoptero se encarga de verificar las intersecciones entre el avion y el helicoptero ya que si esto ocurre el 
    * jugador debera perder una vida y el helicoptero debera ser destruido
    */         
    public void chocarhelicoptero(){
        if (helicoptero!=null&&helicoptero.area().intersects(avion.area())) {
            avion.setVidas(avion.getVidas()-1);
            if (avion.getVidas()>0) {
                //System.out.println("ha perdido una vida");

                avion.setPosX(350);
            }else{
                //System.out.println("ha perdido el juego");
                timerBarco.stop();timerGenerarB.stop();
                perder=true;
            }
            
            helicoptero=null;
            
        }
    }

    public int getPuntos() {
        return puntos;
    }
            
    
    /**
     * la funcion hacerMapa se encarga de generar el mapa cuando el juego comienza, es un mapa predeterminado,constante y con posiciones preestablecidas.
     * 
     */
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
                  AudioClip sonido;
                    sonido=java.applet.Applet.newAudioClip(this.getClass().getResource("/sonidos/bomba.wav"));
         
                    sonido.play();
                    explot.add(new explosion(barco.getPosX(), barco.getPosY()));
                  
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
        
        if (combustible!=null) {
            combustible.draw(g2);
        }
        for (explosion xp:explot) {
            xp.draw(g2);
        }
        
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
     for (int i = 0; i <avion.getVidas(); i++) {
            
                nvid[i].draw(g2);
                //System.out.println("hola :V");
            
        }
     
     indicador.draw(g2);
     aguja.draw(g2);
        
        
    }
    
    

    
    
}
