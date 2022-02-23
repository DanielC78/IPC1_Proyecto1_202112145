package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Botones extends JButton{

    ColoresFuentes graficos = new ColoresFuentes();

    protected String mensaje;
    protected int posicionX;
    protected int posicionY;
    protected int ancho;
    protected int alto;

    public Botones(String mensaje, int posicionX, int posicionY, int ancho, int alto) {
        this.mensaje = mensaje;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.ancho = ancho;
        this.alto = alto;
        inicarComponenteBotones();
    }

    public void inicarComponenteBotones(){
        this.setBorder(new LineBorder(graficos.Azul, 2));
        this.setBorderPainted(true);
        this.setContentAreaFilled(false);
        this.setOpaque(true);
        this.setHorizontalAlignment(JButton.CENTER);
        this.setVerticalAlignment(JButton.CENTER);
        this.setVisible(true);
        this.setBackground(graficos.Azul);
        this.setForeground(graficos.Blanco);
        this.setFont(graficos.Letra_fuerte);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setText(mensaje);
        this.setBounds(posicionX,posicionY,ancho,alto);
        efectoHover();
    }

    public void efectoHover(){
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                Botones.this.setForeground(graficos.Azul);
                Botones.this.setBackground(graficos.Blanco);
                Botones.this.setBorder(new LineBorder(graficos.Azul, 2, true));
            }

            public void mouseExited(MouseEvent e){
                super.mouseExited(e);
                Botones.this.setForeground(graficos.Blanco);
                Botones.this.setBackground(graficos.Azul);
                Botones.this.setBorder(new LineBorder(graficos.Azul, 2,true));
            }

        });

    }

}
