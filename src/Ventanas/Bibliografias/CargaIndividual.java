package Ventanas.Bibliografias;

import GUI.Botones;
import GUI.CajasTexto;
import GUI.Formularios;
import GUI.Paneles;

import javax.swing.*;
import java.awt.*;

public class CargaIndividual extends Formularios {

    //Tamaño de la ventanas
    private static int sizeX = 700 ;
    private static int sizeY = 500;

    //Opciones de revista
    String [] tipoRevista = {"LIBRO","REVISTA","TESIS"};

    //Paneles CAPA 1
    private static JPanel panelCargaIndividual = new Paneles();
    private static JPanel contenedorIzquierdo = new JPanel();
    private static JPanel contenedorDerecho = new JPanel();

    //Paneles CAPA 2
    private static JPanel contenedorCentral1 = new Paneles();
    private static JPanel contenedorCentral2 = new Paneles();

    //Paneles CAPA 3
    private static JPanel contenedorCentral1_1 = new Paneles();
    private static JPanel contenedorCentral2_1 = new Paneles();


    //Paneles contenedores de etiquetas
    private static JPanel contenedorEtiquetas1 = new Paneles();
    private static JPanel contenedorEtiquetas2 = new Paneles();

    //Paneles contenedores de botones
    private static JPanel contenedorBotones1 = new Paneles();
    private static JPanel contenedorBotones2 = new Paneles();

    //Paneles contenedores de cajas de texto
    private static JPanel contenedorCajas1 = new Paneles();
    private static JPanel contenedorCajas2 = new Paneles();

    //Componentes de cajas de texto
    private static JTextField cajaAutor = new CajasTexto();
    private static JTextField cajaTitulo = new CajasTexto();
    private static JTextField cajaEdicion = new CajasTexto();
    private static JTextField cajaDescripcion = new CajasTexto();
    private static JTextField cajaTemas = new CajasTexto();
    private static JTextField cajaFrecuencia = new CajasTexto();
    private static JTextField cajaEjemplares = new CajasTexto();
    private static JTextField cajaCopias = new CajasTexto();
    private static JTextField cajaDisponibles = new CajasTexto();

    //Botones
    private static JButton botonCrear = new Botones("CREAR");
    private static JButton botonCancelar = new Botones("CANCELAR");

    //Lista de opciones
    private JComboBox<String> listaTipo = new JComboBox<>(tipoRevista);

    public CargaIndividual(){
        super(sizeX, sizeY, "CARGA INDIVIDUAL");
        componentenesCargaIndividual();
    }

    private void componentenesCargaIndividual(){
        this.getContentPane().add(panelCargaIndividual);
        panelCargaIndividual.setLayout(new GridLayout(1,2));
        panelCargaIndividual.add(contenedorIzquierdo);
        panelCargaIndividual.add(contenedorDerecho);

        contenedorCentral1.setLayout(new BorderLayout());
        contenedorCentral2.setLayout(new BorderLayout());

        //Contenedores de la capa 1
        agregarPanelesPrincipales(contenedorIzquierdo, contenedorCentral1);
        agregarPanelesPrincipales(contenedorDerecho, contenedorCentral2);

        contenedorBotones1.add(botonCrear);
        contenedorBotones2.add(botonCancelar);

        //Contenedores de la capa 2
        agregarPanelesCentrales(contenedorCentral1, contenedorCentral1_1, BorderLayout.CENTER);
        agregarPanelesCentrales(contenedorCentral1, contenedorBotones1, BorderLayout.PAGE_END);

        agregarPanelesCentrales(contenedorCentral2, contenedorCentral2_1, BorderLayout.CENTER);
        agregarPanelesCentrales(contenedorCentral2, contenedorBotones2, BorderLayout.PAGE_END);

    }


    private void agregarPanelesPrincipales(JPanel contenedor, JPanel central){
        /*Central se refiere al panel en donde estarán el contenedor de botones y
          el contenedor Central2 para las cajas de texto y etiquetas
         */
        contenedor.setLayout(new BorderLayout());
        central.setBorder(null);
        contenedor.add(panelRelleno(), BorderLayout.PAGE_START);
        contenedor.add(panelRelleno(), BorderLayout.LINE_END);
        contenedor.add(panelRelleno(), BorderLayout.LINE_START);
        contenedor.add(panelRelleno(), BorderLayout.PAGE_END);
        contenedor.add(central, BorderLayout.CENTER);
    }

    private void agregarPanelesCentrales(JPanel contenedor, JPanel contenedorObjetos, Object alineacion){
        contenedorObjetos.setBorder(null);
        contenedor.setPreferredSize(new Dimension(50,50));
        contenedor.add(contenedorObjetos, alineacion);
    }


    private JPanel panelRelleno(){
        JPanel panelRelleno = new Paneles();
        panelRelleno.setBorder(null);
        panelRelleno.setPreferredSize(new Dimension(20,20));
        return  panelRelleno;
    }

}
