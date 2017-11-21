
import java.awt.Color;
import java.awt.Dimension;
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
    public Ventanas(){
        this.setFocusable(false);
        menu = new MenuPrincipal(this);
        jugar = new Juego();
        jugar.requestFocus();
        
        //this.setLayout(null);
        this.setLocation(0, 0);
        this.setPreferredSize(new Dimension(800, 600));
        this.add(menu);
      
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
    
}
