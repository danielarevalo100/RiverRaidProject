/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel
 */
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.*;
import javax.imageio.ImageIO;

/**
 *
 * @author YAVD
 */
public class instrucciones extends JPanel {

    private JTextField t;
    private JTextArea ta1;
    private JButton b1;
    private Ventanas dueño;

    public instrucciones(Ventanas dueños) {

        super(new GridBagLayout());
        
        this.dueño=dueños;
        setPreferredSize(new Dimension(800, 600));

        setBackground(new Color(170,38, 75));
        GridBagConstraints pos = new GridBagConstraints();

        t = new JTextField("Instructions");
        t.setFont(new Font(Font.SANS_SERIF, Font.ROMAN_BASELINE, 50));
        t.setBackground(new Color(106,5, 22));
        t.setHorizontalAlignment(JTextField.CENTER);
        t.setEditable(false);
        t.setForeground(Color.WHITE);
        
        pos.gridx = 0;
        pos.gridy = 0;
        pos.gridheight = 1;
        pos.gridwidth = 1;
        pos.weightx = 0;
        pos.weighty = 0;
        pos.fill = GridBagConstraints.CENTER;
        pos.anchor = GridBagConstraints.NORTH;

        add(t, pos);

        ta1 = new JTextArea("Follow these instructions to play and enjoy this game\n"
                + " 1-Use the left and right keyboard arrows to move the plane and avoid cransing with the enemies and land\n"
                + " 2-Use up and down keyboards arrows to increase or decrease the plane speed.\n"
                + " 3-To earn some points you will need to destroy the enemy ships by pressing the space bar to shoot them.");
        ta1.setFont(new Font(Font.SANS_SERIF, Font.ROMAN_BASELINE, 20));
        ta1.setBackground(new Color(106,5, 22));
        ta1.setEditable(false);
        ta1.setForeground(Color.WHITE);
       
        
        pos.gridx = 0;
        pos.gridy = 1;
        pos.gridheight = 3;
        pos.gridwidth = 3;
        pos.weightx = 1.0;
        pos.weighty = 1.0;
        pos.fill = GridBagConstraints.HORIZONTAL;
        pos.anchor = GridBagConstraints.CENTER;

        add(ta1, pos);

        b1 = new JButton("Salir");
        b1.setFont(new Font(Font.SANS_SERIF, Font.ROMAN_BASELINE, 30));
        b1.addActionListener(accion);
        b1.setBackground(new Color(106,5, 22));
        b1.setForeground(Color.WHITE);
        
        pos.gridx = 0;
        pos.gridy = 4;
        pos.gridheight = 1;
        pos.gridwidth = 1;
        pos.weightx = 1.0;
        pos.weighty = 0.09;
        pos.fill = GridBagConstraints.VERTICAL;
        pos.anchor = GridBagConstraints.CENTER;

        add(b1, pos);
        
        
        

    }

    ActionListener accion = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == b1) {
                dueño.regresar();
            }
        }
    };

}

