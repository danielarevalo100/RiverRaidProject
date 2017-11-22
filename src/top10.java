
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel
 */
public class top10 extends JPanel{
    
    Ventanas dueño;
    JTextArea ta1;
    JButton b1;
    JLabel l1;
    
    public top10(Ventanas v) throws FileNotFoundException, IOException {
        
        this.dueño=v;
        this.setPreferredSize(new Dimension(800, 600));
        this.setBackground(new Color(170, 38, 75));
        this.setLayout(null);
        
        l1=new JLabel("TOP 10 MEJORES JUGADORES");
        l1.setBounds(250, 0, 300, 50);
        l1.setOpaque(false);
        l1.setForeground(Color.white);
        l1.setFont(new Font(Font.DIALOG, Font.ROMAN_BASELINE, 20));
    
        b1=new JButton("Salir");
        b1.setBounds(30, 520, 200, 50);
        b1.setBackground(new Color(106,5, 22));
        
        //b1.setEnabled(true);
        b1.setForeground(Color.white);
        b1.setFont(new Font(Font.DIALOG, Font.ROMAN_BASELINE, 20));
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dueño.regresartop10();
                System.out.println("regreso");
            }
        });
        
        ta1=new JTextArea("");
        ta1.setBounds(250, 50, 700, 600);
        
        
        FileReader fr=new FileReader("top-10.txt");
        BufferedReader br=new BufferedReader(fr);
        
        int cantlineas=0;
        
        while(br.readLine()!=null){
            cantlineas++;
            
        }
        
        br.close();
        
        fr = new FileReader("top-10.txt");
        br = new BufferedReader(fr);

        int[] points=new int[cantlineas];
        String linea;
        String[] partes;
        for (int i = 0; i < cantlineas; i++) {

            linea = br.readLine();
            partes = linea.split("-");
            points[i]=Integer.parseInt(partes[0]);

        }
        Arrays.sort(points);
        br.close();
        
       
        
        
        if (cantlineas>10) {
            for (int i = points.length-1; i>points.length-9 ; i--) {
                 fr = new FileReader("top-10.txt");
                 br = new BufferedReader(fr);
                for (int j = 0; j < cantlineas; j++) {
                    
                    
                    linea=br.readLine();
                    partes=linea.split("-");
                    
                    if (points[i]==Integer.parseInt(partes[0])) {
                        ta1.setText(ta1.getText()+"nombres: "+partes[1]+" puntaje: "+partes[0]+"\n\n");
///aqui se incluye al text field  System.out.println("nombre: "+partes[1]+"puntaje"+partes[0]);
                    }
                }
                br.close();
                
            }
            
            
        }
        if (cantlineas<=10) {
            for (int i = points.length-1; i >= 0; i--) {
                fr = new FileReader("top-10.txt");
                 br = new BufferedReader(fr);
                for (int j = 0; j < cantlineas; j++) {
                    
                    
                    linea=br.readLine();
                    partes=linea.split("-");
                    
                    if (points[i]==Integer.parseInt(partes[0])) {
                        ///aqui se incluye al text field 
                        
                        ta1.setText(ta1.getText()+"nombres: "+partes[1]+" puntaje: "+partes[0]+"\n\n");
                    }
                }
                br.close();
            }
        }
        ta1.setOpaque(false);
        ta1.setEditable(false);
        ta1.setForeground(Color.white);
        ta1.setFont(new Font(Font.DIALOG, Font.ROMAN_BASELINE, 20));
        this.add(ta1);
        this.add(l1);
        this.add(b1);
        
        
    }
    
    
    
}
