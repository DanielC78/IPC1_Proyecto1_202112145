package GUI;

import javax.swing.*;
import java.awt.*;

public class CajasTexto extends JTextField {

    private ColoresFuentes graficos = new ColoresFuentes();

    public CajasTexto() {
        iniciarComponentesCT();
    }

    public void iniciarComponentesCT(){
        this.setOpaque(true);
        this.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        this.setBorder(graficos.bordeCajas);
        this.setFont(graficos.letraSuave);
        this.setForeground(graficos.Gris);
        this.setBackground(graficos.Blanco);
    }
}
