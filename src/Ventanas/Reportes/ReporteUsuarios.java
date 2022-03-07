package Ventanas.Reportes;

import GUI.Botones;
import GUI.Formularios;
import GUI.Paneles;

import javax.swing.*;
import java.awt.*;

public class ReporteUsuarios extends Formularios {

    private final static int sizeX = 400;
    private final static int sizeY = 500;

    //Paneles
    private final JPanel panelReporteUsuario = new Paneles();
    private final JPanel contenedorTexto = new Paneles();
    private final JPanel contenedorBoton = new Paneles();

    //Botones
    private String textoBoton = "GENERAR REPORTE";
    private final JButton botonReporteUsuario = new Botones(textoBoton,grafica.letraTitulos);
    private final JButton botonReporteBibliografia = new Botones(textoBoton);
    private final JButton botonPrestamos = new Botones(textoBoton);


    public ReporteUsuarios(String titulo) throws HeadlessException {
        super(sizeX, sizeY, titulo);
    }

    private void componentesReporteUsuario(){
        this.getContentPane().add(panelReporteUsuario);

    }
}
