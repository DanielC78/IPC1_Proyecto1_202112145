package GUI;

import javax.swing.*;


public class Botones extends JButton{

    ColoresFuentes graficos = new ColoresFuentes();

    public Botones(){

        this.setBorder(null);
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        this.setFocusable(false);
        this.setOpaque(true);
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
        this.setVisible(true);
        this.setBackground(graficos.Azul);
        this.setForeground(graficos.Blanco);
        this.setFont(graficos.Letra_suave);
    }

}
