package Ventanas.Bibliografias;

import Bibliografias.AlmacenLibros;
import GUI.Botones;
import GUI.Etiquetas;
import GUI.Formularios;
import GUI.Paneles;
import Ventanas.General.PanelAdministrador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerLibros extends Formularios {

    private JPanel panelVerLibros = new Paneles();
    private JPanel panelEncabezado = new Paneles();

    //Rellenos para el encabezado
    private JPanel rellenoSup= new Paneles();
    private JPanel rellenoInf= new Paneles();
    private JPanel rellenoDer= new Paneles();
    private JPanel rellenoIzq= new Paneles();
    private JPanel contenedorEncabezado = new Paneles();

    private JTable tablaLibros;
    private JScrollPane contenedorTablaLibros = new JScrollPane();
    private JButton botonRegresar = new Botones("MENÚ PRINCIPAL");

    //Etiquetas
    private JLabel listaLibros = new Etiquetas("LISTA DE LIBROS",null,null,grafica.letraTitulos);

    //Dimensiones de la ventana
    private static int sizeX = 1300;
    private static int sizeY = 600;

    public VerLibros() throws HeadlessException {
        super(sizeX, sizeY, "VER LIBROS");
        componentesVerLibros();
    }

    private void componentesVerLibros(){
        this.getContentPane().add(panelVerLibros);
        panelVerLibros.setLayout(new BorderLayout());

        //Elementos del panel principal (CAPA 1)
        agregarPanelesPrincipal(panelEncabezado, BorderLayout.PAGE_START, sizeX, 50);

        //Elementos del panel de encabezado (CAPA 2)
        agregarPanelRellenoEncabezado(rellenoSup, BorderLayout.PAGE_START);
        agregarPanelRellenoEncabezado(rellenoInf,BorderLayout.PAGE_END);
        agregarPanelRellenoEncabezado(rellenoDer,BorderLayout.LINE_END);
        agregarPanelRellenoEncabezado(rellenoIzq,BorderLayout.LINE_START);
        agregarPanelRellenoEncabezado(contenedorEncabezado, BorderLayout.CENTER);

        //Elementos del contenedor central de encabezado
        contenedorEncabezado.setLayout(new BorderLayout());
        contenedorEncabezado.add(listaLibros, BorderLayout.LINE_START);
        contenedorEncabezado.add(botonRegresar, BorderLayout.LINE_END);

        mostrarLibros();

        //Funcion de los botones
        botonRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcionBtnRegresar(e);
            }
        });


    }

    //Métodos para la modificacion de  los elementos dentro de los paneles
    private void agregarPanelesPrincipal(JPanel contenedor, Object alineacion, int ancho, int alto){
        contenedor.setLayout(new BorderLayout());
        contenedor.setBorder(null);
        contenedor.setPreferredSize(new Dimension(ancho , alto));
        panelVerLibros.add(contenedor, alineacion);
    }

    private void agregarPanelRellenoEncabezado( JPanel relleno, Object alineacion){
        relleno.setBorder(null);
        relleno.setPreferredSize(new Dimension(10,10));
        panelEncabezado.add(relleno, alineacion);
    }

    private void mostrarLibros(){
        String datos[][] = AlmacenLibros.obtenerLibros();
        tablaLibros = new JTable(datos,AlmacenLibros.cabeceraLibros());
        tablaLibros.setAutoscrolls(true);
        contenedorTablaLibros.setBorder(grafica.margenPanelesAdmin);
        contenedorTablaLibros.setViewportView(tablaLibros);
        panelVerLibros.add(contenedorTablaLibros);
    }

    //Funcion de los botones
    private void funcionBtnRegresar(ActionEvent e){
        this.setVisible(false);
        new PanelAdministrador().setVisible(true);
        this.dispose();
    }
}
