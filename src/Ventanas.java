
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel
 */
public class Ventanas extends JPanel {
     MenuPrincipal menu;
     Juego jugar;
     instrucciones ins;
     Datos datos;
     top10 t10;
     creditos cred;
     panel2 juego2;
    public Ventanas(){
        this.setFocusable(false);
        menu = new MenuPrincipal(this);
        jugar = new Juego(this);
        jugar.requestFocus();
        //datos= new Datos();
        
        
        ins=new instrucciones(this);
        //this.setLayout(null);
        this.setLocation(0, 0);
        this.setPreferredSize(new Dimension(800, 600));
        this.add(menu);
      
        this.setVisible(true);
        
    }
    
    public void instruc(){
        
        
        this.setVisible(false);
        menu.setVisible(false);
        ins.setVisible(true);
       
        //this.setBackground(Color.BLUE);
        this.add(ins);
        this.setVisible(true);
        
    }
    public void regresar(){
        this.setVisible(false);
        menu.setVisible(true);
        ins.setVisible(false);
        
        
        this.setVisible(true);
        
    }
    
    public void perdio(){
        this.setVisible(false);
        jugar.setFocusable(false);
        datos=new Datos(jugar.getPuntos());
        
       this.remove(jugar);
       
       datos.setVisible(true);
       this.add(datos);
       this.setVisible(true);
    }
    
    public void top10() throws IOException{
        this.setVisible(false);
        menu.setVisible(false);
        t10=new top10(this);
        t10.setVisible(true);
        
        this.add(t10);
        this.setVisible(true);
        
    }
    public void regresartop10(){
        this.setVisible(false);
        t10.setVisible(false);
        menu.setVisible(true);

        

        this.setVisible(true);
    }
            
    public void creditos(){
        this.setVisible(false);
        menu.setVisible(false);
        cred=new creditos(this);
        cred.setVisible(true);
        this.add(cred);
        this.setVisible(true);
    }
    
    public void salircreditos(){
        this.setVisible(false);
        cred.setVisible(false);
        menu.setVisible(true);
        this.setVisible(true);
    }
            
            
    
    public void iniciarJuego(){
        
        this.setVisible(false);
        this.remove(menu);
        jugar.setVisible(true);
        jugar.setFocusable(true);
        this.add(jugar);
        this.setVisible(true);
        
    }
    
    public void iniciarJuego2(){
        
        this.setVisible(false);
        this.remove(menu);
        juego2= new panel2(this);
        juego2.setVisible(true);
        this.add(juego2);
        this.setVisible(true);
        
    } 
}
