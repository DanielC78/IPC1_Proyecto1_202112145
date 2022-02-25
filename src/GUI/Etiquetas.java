package GUI;

import javax.swing.*;
import java.awt.*;

public class Etiquetas extends JLabel {

    protected String mensaje;
    protected Color backgroundEt;
    protected Color foregroundEt;
    protected Font fuenteLetra;

    public Etiquetas(String mensaje, Color backgroundEt, Color foregroundEt, Font fuenteLetra) {
        this.mensaje = mensaje;
        this.backgroundEt = backgroundEt;
        this.foregroundEt = foregroundEt;
        this.fuenteLetra = fuenteLetra;
        iniciarComponentesEt();
    }

    public void iniciarComponentesEt(){
        this.setOpaque(true);
        this.setVerticalAlignment(0);
        this.setHorizontalAlignment(0);
        this.setText(mensaje);
        this.setBackground(backgroundEt);
        this.setForeground(foregroundEt);
        this.setFont(fuenteLetra);

    }
}
