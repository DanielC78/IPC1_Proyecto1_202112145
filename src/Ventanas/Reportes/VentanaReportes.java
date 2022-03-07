package Ventanas.Reportes;

import GUI.Botones;
import GUI.Formularios;
import GUI.Paneles;
import Prestamos.Prestamos;
import Reportes.ReportesPrestamos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaReportes extends Formularios {

    private final static int sizeX = 700;
    private final static int sizeY = 600;

    //Paneles
    private final JPanel panelReporteUsuario = new Paneles();
    private final JPanel contenedorTexto = new Paneles();
    private final JPanel contenedorBoton = new Paneles();

    //Posibles titulos
    private final String tituloUsuarios = "REPORTE DE USUARIOS";
    private final String tituloLibros = "REPORTE DE BIBLIOGRAFIAS";
    private final String tituloPrestamos = "REPORTE DE PRESTAMOS";

    //Botones
    private String textoBoton = "GENERAR REPORTE";
    private final JButton botonReporteUsuario = new Botones(textoBoton + " DE USUARIO",grafica.letraTitulos);
    private final JButton botonReporteBibliografia = new Botones(textoBoton + " DE BIBLIOGRAFIA",grafica.letraTitulos);
    private final JButton botonReportePrestamos = new Botones(textoBoton + " DE PRESTAMOS", grafica.letraTitulos);
    private final JButton botonMenuPrincipal = new Botones("REGRESAR",grafica.letraTitulos);

    //Area de texto
    private final JTextArea areaDeTexto = new JTextArea();
    private final JScrollPane scrollAreaDeTexto = new JScrollPane();

    public VentanaReportes(String titulo) throws HeadlessException {
        super(sizeX, sizeY, titulo);
        componentesReporteUsuario(titulo);
    }

    private void componentesReporteUsuario(String opcion){
        this.getContentPane().add(panelReporteUsuario);
        panelReporteUsuario.setLayout(new BorderLayout());

        //Dimensiones de los paneles contenedores
        int altoContenedorTexto = 10;
        agregarPaneles(contenedorTexto, BorderLayout.CENTER,10, altoContenedorTexto);
        int altoContenedorBoton = 100;
        agregarPaneles(contenedorBoton, BorderLayout.PAGE_END, 10, altoContenedorBoton);
        agregarAreaTexto(areaDeTexto);

        switch (opcion){
            case tituloUsuarios:
                agregarBoton(botonReporteUsuario);
                botonReporteUsuario.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        btnReporteUsuarios(e);
                    }
                });
                break;
            case tituloLibros:
                agregarBoton(botonReporteBibliografia);
                botonReporteBibliografia.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        btnReporteLibros(e);
                    }
                });
                break;
            case tituloPrestamos:
                agregarBoton(botonReportePrestamos);
                botonReportePrestamos.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        btnReportePrestamos(e);
                    }
                });
                break;
        }
    }

    private void agregarPaneles(JPanel panelContenedor, Object alineacion, int ancho, int alto){
        panelContenedor.setBorder(null);
        panelContenedor.setLayout(new BorderLayout());
        panelContenedor.setPreferredSize(new Dimension( ancho, alto));
        panelContenedor.add(panelRelleno(10,20), BorderLayout.PAGE_END);
        panelContenedor.add(panelRelleno(10,20), BorderLayout.PAGE_START);
        panelContenedor.add(panelRelleno(20,10), BorderLayout.LINE_END);
        panelContenedor.add(panelRelleno(20,10), BorderLayout.LINE_START);
        panelReporteUsuario.add(panelContenedor,alineacion);
    }

    private void agregarAreaTexto(JTextArea areaTexto){
        areaTexto.setFont(grafica.letraAreasDeTexto);
        scrollAreaDeTexto.setViewportView(areaTexto);
        scrollAreaDeTexto.setBorder(grafica.margenPanelesAdmin);
        contenedorTexto.add(areaTexto, BorderLayout.CENTER);
    }

    private void agregarBoton(JButton boton){
        contenedorBoton.add(boton, BorderLayout.CENTER);
    }

    private JPanel panelRelleno(int width, int height){
        JPanel panelRelleno = new Paneles();
        panelRelleno.setBorder(null);
        panelRelleno.setPreferredSize(new Dimension(width,height));
        return  panelRelleno;
    }

    private void btnReporteUsuarios(ActionEvent e){

    }

    private void btnReporteLibros(ActionEvent e){

    }
    private void btnReportePrestamos(ActionEvent e){
        String [] theadPrestamos = {
                "ID DEL USUARIO",
                "TITULO",
                "TIPO",
                "HORA"
        };

        Prestamos [] datos = Prestamos.getArregloPrestamos();
        ReportesPrestamos generadorHTML = new ReportesPrestamos(datos,theadPrestamos);
        String reporteHTML = generadorHTML.obtenerReportePrestamos();
        areaDeTexto.setText(reporteHTML);
    }

}
