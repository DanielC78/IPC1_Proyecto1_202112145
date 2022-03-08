package Ventanas.General;

import GUI.Botones;
import GUI.Etiquetas;
import GUI.Formularios;
import GUI.Paneles;

import javax.swing.*;
import java.awt.*;

public class AcercaDeNostros extends Formularios {

    //Dimensiones de la ventana
    private static int sizeX = 300;
    private static int sizeY = 400;
    private static String titulo = "ACERCA DE NOSOTROS";

    //Paneles
    private final JPanel panelAbout  = new Paneles();

    //Etiquetas
    private final JLabel texto = new Etiquetas("",null,null, grafica.letraSuave);
    //Botones
    private final JButton botonRegresar = new Botones("REGRESAR",grafica.letraFuerte);

    public AcercaDeNostros() throws HeadlessException {
        super(sizeX, sizeY, titulo);
    }

    private void componentesInformacion(){
        this.getContentPane().add(panelAbout);
    }
}
