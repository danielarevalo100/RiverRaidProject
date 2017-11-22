
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
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
public class creditos extends JPanel {

    Ventanas dueño;
    JTextArea l1;
    Timer  timecredits;
    
    public creditos(Ventanas v ){
        
        this.dueño=v;
        this.setLayout(null);
        this.setPreferredSize(new Dimension(800, 600));
        this.setBackground(new Color(170, 38, 75));
        l1=new JTextArea("PROYECTO DE PROGRAMACION 1\n"+
                "REALIZADO POR :\n"+
                "DANIEL AREVALO\n"+
                "   Y   \n"+
                "YOEL VEGA");
        
        l1.setLocation(0, 600);
        l1.setSize(new Dimension(800, 600));
        l1.setFont(new Font(Font.DIALOG, Font.BOLD, 50));
        l1.setForeground(Color.white);
        l1.setOpaque(false);
        
        this.add(l1);
        
        timecredits=new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                l1.setLocation(l1.getX(), l1.getY()-1);
                if(l1.getY()<-400){
                    timecredits.stop();
                    dueño.salircreditos();
                }
            }
        });
        timecredits.start();
        
        
    }
    
    
    
}
