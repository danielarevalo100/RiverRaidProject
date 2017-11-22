
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Daniel
 */
public class Datos extends JPanel {

    private JLabel l1;
    private JTextField t1;
    private JButton b1;
    int puntos;

    public Datos() {
        this.puntos = 0;

        this.setBackground(new Color(170, 38, 75));
        this.setLayout(null);
        this.setPreferredSize(new Dimension(800, 600));
        l1 = new JLabel("Ingrese su Nombre");
        l1.setBounds(200, 50, 150, 50);

        this.setFocusable(true);

        t1 = new JTextField("");
        t1.setBounds(350, 50, 200, 70);
        t1.setEditable(true);

        b1 = new JButton("guardar y salir ");
        b1.setBounds(300, 300, 200, 50);
        b1.setBackground(new Color(106,5, 22));
        b1.setForeground(Color.white);
                
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                FileWriter f;
                try {
                    f = new FileWriter("top-10.txt", true);
                    BufferedWriter bf = new BufferedWriter(f);
                    PrintWriter pf = new PrintWriter(bf);
                    
                    pf.println(Integer.toString(puntos)+"-"+t1.getText());
                    pf.close();

                } catch (IOException ex) {
                    Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.exit(0);

            }
        });

        this.add(b1);
        this.add(t1);
        this.add(l1);
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

}
