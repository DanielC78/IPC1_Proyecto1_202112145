package GUI;

import javax.swing.*;

public class Paneles extends JPanel {
    private ColoresFuentes graficos = new ColoresFuentes();
    public Paneles() {
        this.setLayout(null);
        this.setBackground(graficos.Blanco);
        this.setBorder(graficos.bordeNegro);

    }
}
