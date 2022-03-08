package Ventanas.Reportes;

import Bibliografias.Bibliografias;
import GUI.Botones;
import GUI.Formularios;
import GUI.Paneles;
import Prestamos.Prestamos;
import Reportes.ReporteUsuarios;
import Reportes.ReportesPrestamos;
import Usuarios.Usuario;
import Ventanas.General.PanelAdministrador;

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
    private final String textoBoton = "GENERAR REPORTE";
    private final JButton botonReporteUsuario = new Botones(textoBoton + " DE USUARIO",grafica.letraFuerte);
    private final JButton botonReporteBibliografia = new Botones(textoBoton + " DE BIBLIOGRAFIA",grafica.letraFuerte);
    private final JButton botonReportePrestamos = new Botones(textoBoton + " DE PRÉSTAMOS", grafica.letraFuerte);
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
            //GENERA EL REPORTE DE USUARIOS
            case tituloUsuarios:
                agregarBoton(botonReporteUsuario);
                botonReporteUsuario.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        btnReporteUsuarios(e);
                    }
                });
                break;
                //GENERA EL REPORTE DE LIBROS
            case tituloLibros:
                agregarBoton(botonReporteBibliografia);
                botonReporteBibliografia.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        btnReporteLibros(e);
                    }
                });
                break;
                //GENERA EL REPORTE DE PRESTAMOS
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

        botonMenuPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnMenuPrincipal(e);
            }
        });
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
        areaTexto.setBorder(grafica.bordeNegro);
        contenedorTexto.add(scrollAreaDeTexto, BorderLayout.CENTER);
    }

    private void agregarBoton(JButton boton){
        JPanel panelBotones = new Paneles();
        panelBotones.setBorder(null);
        panelBotones.setLayout(new GridLayout(1,2,15,20));
        panelBotones.add(boton);
        panelBotones.add(botonMenuPrincipal);
        contenedorBoton.add(panelBotones, BorderLayout.CENTER);
    }

    private JPanel panelRelleno(int width, int height){
        JPanel panelRelleno = new Paneles();
        panelRelleno.setBorder(null);
        panelRelleno.setPreferredSize(new Dimension(width,height));
        return  panelRelleno;
    }

    private void btnReporteUsuarios(ActionEvent e){
        String [] theadUsuarios = {
                "ID",
                "NOMBRE",
                "APELLIDO",
                "NICKNAME",
                "ROL",
                "BIBLIOGRAFIAS PRESTADAS"
        };

        Usuario tablaUsuarios = new Usuario();
        String[][] datosUsuario = tablaUsuarios.verDatos();
        String[][] datosPrestamos = Prestamos.getCantidadPrestada();
        ReporteUsuarios generadorHTML = new ReporteUsuarios(datosUsuario,theadUsuarios,datosPrestamos);
        String reporteHTMLUsuarios = generadorHTML.obtenerReporteUsuarios();
        areaDeTexto.setText(reporteHTMLUsuarios);
    }

    private void btnReporteLibros(ActionEvent e){
        String [] theadLibros = {
                "TEMAS",
                "BIBLIOGRAFIAS ASOCIADAS"
        };

        Bibliografias[] datosLibros;

        String reporteHTMLBibliografia = "";
        areaDeTexto.setText(reporteHTMLBibliografia);
    }

    private void btnReportePrestamos(ActionEvent e){
        String [] theadPrestamos = {
                "ID DEL USUARIO",
                "TITULO",
                "TIPO",
                "HORA"
        };

        Prestamos [] datosPrestamos = Prestamos.getArregloPrestamos();
        ReportesPrestamos generadorHTML = new ReportesPrestamos(datosPrestamos,theadPrestamos);
        String reporteHTMLPrestamos = generadorHTML.obtenerReportePrestamos();
        areaDeTexto.setText(reporteHTMLPrestamos);
    }

    private void btnMenuPrincipal(ActionEvent e){
        this.dispose();
        new PanelAdministrador().setVisible(true);
    }

}
