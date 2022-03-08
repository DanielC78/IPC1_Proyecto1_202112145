package Ventanas.General;

import GUI.Botones;
import GUI.Etiquetas;
import GUI.Formularios;
import GUI.Paneles;

import javax.swing.*;
import java.awt.*;

public class AcercaDeNostros extends Formularios {

    //Dimensiones de la ventana
    private final static int sizeX = 500;
    private final static int sizeY = 300;
    private final static String titulo = "ACERCA DE NOSOTROS";

    //Paneles
    private final JPanel panelAbout  = new Paneles();

    //Etiquetas
    private final JLabel textoAbout = new Etiquetas("<html>" +
            "<p text-align: center>" +
            " \t\n" +
            " \n" +
            "Biblioteca Central es la dependencia técnica y de servicio de la Universidad de San Carlos de Guatemala, encargada de seleccionar, adquirir, catalogar, clasificar, actualizar y mantener la conformación de un fondo bibliográfico acorde a las necesidades de los planes, programas y proyectos académicos de la Universidad." +
            "  </p>" +
            "</hmtl>",null,null, grafica.letraAbout);

    public AcercaDeNostros() throws HeadlessException {
        super(sizeX, sizeY, titulo);
        componentesInformacion();
    }

    private void componentesInformacion(){
        this.getContentPane().add(panelAbout);
        panelAbout.setLayout(new BorderLayout());
        panelAbout.add(paneRelleno(),BorderLayout.PAGE_START);
        panelAbout.add(paneRelleno(),BorderLayout.PAGE_END);
        panelAbout.add(paneRelleno(),BorderLayout.LINE_START);
        panelAbout.add(paneRelleno(),BorderLayout.LINE_END);
        panelAbout.add(textoAbout, BorderLayout.CENTER);
    }

    private JPanel paneRelleno(){
        JPanel panel = new Paneles();
        panel.setBorder(null);
        panel.setPreferredSize(new Dimension(20,20));
        return panel;
    }
}
