package Ventanas.Usuarios;

import GUI.Botones;
import GUI.Formularios;
import GUI.Paneles;
import Usuarios.Usuario;
import Ventanas.General.PanelAdministrador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerUsuario extends Formularios {

    private JPanel panelVerUsuario = new Paneles();
    private JPanel panelEncabezado = new Paneles();

    //Rellenos para el encabezado
    private JPanel rellenoSup= new Paneles();
    private JPanel rellenoInf= new Paneles();
    private JPanel rellenoDer= new Paneles();
    private JPanel rellenoIzq= new Paneles();
    private JPanel contenedorEncabezado = new Paneles();

    private JScrollPane scroller = new JScrollPane();
    private JButton botonRegresar = new Botones("MENÚ PRINCIPAL");

    //Dimensiones de la ventana
    private static int sizeX = 800;
    private static int sizeY = 600;

    public VerUsuario() throws HeadlessException {
        super(sizeX, sizeY,"VER USUARIOS");
        componentesVerUsuario();

    }

    private void componentesVerUsuario(){

        this.getContentPane().add(panelVerUsuario);
        panelVerUsuario.setLayout(new BorderLayout());

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
        contenedorEncabezado.add(new JLabel("LISTA DE USUARIOS"), BorderLayout.LINE_START);
        contenedorEncabezado.add(botonRegresar, BorderLayout.LINE_END);

        //Funcion de los botones
        botonRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcionBtnRegresar(e);
            }
        });

        mostrarUsuarios();

    }

    //Métodos para la modificacion de  los elementos dentro de los paneles
    private void agregarPanelesPrincipal(JPanel contenedor, Object alineacion, int ancho, int alto){
        contenedor.setLayout(new BorderLayout());
        contenedor.setBorder(null);
        contenedor.setPreferredSize(new Dimension(ancho , alto));
        panelVerUsuario.add(contenedor, alineacion);
    }

    private void agregarPanelRellenoEncabezado( JPanel relleno, Object alineacion){
        relleno.setBorder(null);
        relleno.setPreferredSize(new Dimension(10,10));
        panelEncabezado.add(relleno, alineacion);
    }

    private void mostrarUsuarios(){
        Usuario verUsuarios = new Usuario();
        String [] cabecera =  {
                "ID", "NOMBRE", "APELLIDO", "USER", "ROL", "CONTRASEÑA"
        };

        JTable tablaDatos = new JTable(verUsuarios.verDatos(), cabecera);
        tablaDatos.setAutoscrolls(true);
        tablaDatos.setOpaque(true);
        tablaDatos.setRowMargin(5);
        scroller.setBorder(grafica.bordePanelesAdmin);
        scroller.setViewportView(tablaDatos);
        panelVerUsuario.add(scroller, BorderLayout.CENTER);

    }

    //Funcion de los botones
    private void funcionBtnRegresar(ActionEvent e){
        this.setVisible(false);
        new PanelAdministrador().setVisible(true);
        this.dispose();
    }
}
