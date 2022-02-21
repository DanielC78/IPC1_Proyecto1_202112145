package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;


public class Botones extends JButton{

    ColoresFuentes graficos = new ColoresFuentes();

    public Botones(){

        this.setBorder(new LineBorder(graficos.Azul, 2));
        this.setBorderPainted(true);
        this.setContentAreaFilled(false);
        this.setFocusable(false);
        this.setOpaque(true);
        this.setHorizontalAlignment(JButton.CENTER);
        this.setVerticalAlignment(JButton.CENTER);
        this.setVisible(true);
        this.setBackground(graficos.Azul);
        this.setForeground(graficos.Blanco);
        this.setFont(graficos.Letra_suave);
    }

}
