package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ColoresFuentes {
    //Colores
    final public Color Azul = new Color(47, 113, 173);
    final public Color Blanco = new Color(255,255,255);
    final public Color Rojo = new Color(241,67,67);
    final public Color Amarillo = new Color(246, 191,79);
    final public Color Gris = new Color(0,0,0, 136);
    final public Color Negro = new Color(0,0,0);
    final public Color Verde = new Color(100,202,87);

    //Fuentes
    final public Font letraSuave = new Font("Work Sans", 0, 13);
    final public Font letraFuerte = new Font("Work Sans", 1, 13);
    final public Font letraTitulos = new Font("Work Sans",1,17);
    final public Font letraCargaMasiva = new Font("Work Sans", 0, 16);

    //Bordes simples
    final public Border bordeNegro = BorderFactory.createLineBorder(Negro, 2);
    final public Border bordeAzul = BorderFactory.createLineBorder(Azul,2);

    //Margenes
    final public Border margenCajas = new EmptyBorder(0, 20, 0, 0);
    final public Border margenPanelesAdmin = new EmptyBorder(10,10,10,10);

    //Bordes compuestos
    final public CompoundBorder bordeCajas = new CompoundBorder(bordeAzul, margenCajas);
    final public CompoundBorder bordePanelesAdmin = new CompoundBorder(margenPanelesAdmin, bordeNegro);
}
