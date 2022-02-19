package GUI;

import javax.swing.*;
import java.awt.*;

public class Botones extends JButton {


    ColoresFuentes variableGrafica = new ColoresFuentes();
    public Botones(){
        this.setOpaque(true);
        this.setVisible(true);
        this.setSize(65, 16);
        this.setLocation(100,100);
        this.setBackground(Color.decode(variableGrafica.ColorFuente));
        this.setForeground(Color.decode(variableGrafica.ColorBase));
        this.setFont(variableGrafica.FuenteBaseFuerte);
    }
}
