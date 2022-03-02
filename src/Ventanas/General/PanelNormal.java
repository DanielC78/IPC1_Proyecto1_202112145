package Ventanas.General;

import GUI.Formularios;
import GUI.Paneles;

import javax.swing.*;
import java.awt.*;


public class PanelNormal extends Formularios {

    //Dimensiones de la ventana
    private static int sizeX = 700;
    private static int sizeY = 700;

    //Paneles princiaples
    private JPanel panelNormal = new Paneles();

    public PanelNormal() {
        super(sizeX, sizeY, "USUARIO NORMAL");

    }

}
