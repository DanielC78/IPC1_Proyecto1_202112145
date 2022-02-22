package GUI;

import javax.swing.*;
import java.awt.*;

public class CajasTexto extends JTextField {

    private ColoresFuentes graficos = new ColoresFuentes();
    protected int posX;
    protected int posY;
    protected int ancho;
    protected int alto;

    public CajasTexto(int posX, int posY, int ancho, int alto) {
        this.posX = posX;
        this.posY = posY;
        this.ancho = ancho;
        this.alto = alto;
        iniciarComponentesCT();

    }

    public void iniciarComponentesCT(){
        this.setOpaque(true);
        this.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        this.setBorder(graficos.bordeCajas);
        this.setFont(graficos.Letra_suave);
        this.setForeground(graficos.Gris);
        this.setBackground(graficos.Blanco);
        this.setBounds(posX,posY,ancho,alto);
    }
}
