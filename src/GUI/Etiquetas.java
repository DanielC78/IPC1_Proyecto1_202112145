package GUI;

import javax.swing.*;
import java.awt.*;

public class Etiquetas extends JLabel {

    protected String mensaje;
    protected int posicionX;
    protected int posicionY;
    protected int ancho;
    protected int alto;
    protected Color backgroundEt;
    protected Color foregroundEt;
    protected Font fuenteLetra;

    public Etiquetas(String mensaje, int posicionX, int posicionY, int ancho, int alto, Color backgroundEt, Color foregroundEt, Font fuenteLetra) {
        this.mensaje = mensaje;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.ancho = ancho;
        this.alto = alto;
        this.backgroundEt = backgroundEt;
        this.foregroundEt = foregroundEt;
        this.fuenteLetra = fuenteLetra;
        iniciarComponentesEt();
    }

    public void iniciarComponentesEt(){
        this.setOpaque(true);
        this.setBounds(posicionX,posicionY,ancho,alto);
        this.setVerticalAlignment(0);
        this.setHorizontalAlignment(0);
        this.setText(mensaje);
        this.setBackground(backgroundEt);
        this.setForeground(foregroundEt);
        this.setFont(fuenteLetra);

    }
}
