package Ventanas;

import GUI.Botones;
import GUI.Etiquetas;
import GUI.Formularios;
import GUI.Paneles;

import javax.swing.*;
import java.awt.*;

public class PanelAdministrador extends Formularios {

    private String informacionUser;

    private JPanel panelAdministrador = new Paneles();
    private JPanel panelReportes = new Paneles();
    private JPanel panelInfo = new Paneles();
    private JPanel panelUsuario = new Paneles();
    private JPanel panelLibros = new Paneles();

    private JPanel contenedorReportes = new JPanel();
    private JPanel rellenoIzq = new JPanel();
    private JPanel rellenoDer = new JPanel();

    private JPanel contenedorLibros= new JPanel();
    private JPanel contenedorUsuarios= new JPanel();

    private int sizeContRellenX = 25;
    private int sizeContRellenY = 500;

    private JLabel tituloReportes = new Etiquetas(
            "REPORTES",
            108,
            13,
            96,
            22,
            null,
            Color.black,
            grafica.Letra_fuerte
    );

    private JLabel tituloLibros = new Etiquetas(
            "BIBLIOGRAFÍAS",
            108,
            13,
            96,
            22,
            null,
            Color.black,
            grafica.Letra_fuerte
    );

    private JLabel tituloUsuarios = new Etiquetas(
            "USUARIOS",
            108,
            13,
            96,
            22,
            null,
            Color.black,
            grafica.Letra_fuerte
    );


    JLabel tituloInfo = new Etiquetas(
      informacionUser,
            141,
            32,
            123,
            48,
            null,
            grafica.Negro,
            grafica.Letra_fuerte
    );

    //Tamaños de los botones del repositorio
    private int sizeXBR = 5;
    private int sizeYBR = 5;

    //Tamaños de los botones de Usuario y Bibliografia
    private int sizeXUB;
    private int sizeYUB;

    //Botones para reportes
    private JButton userRepo = new Botones("USUARIO",1,1, sizeXBR, sizeYBR);
    private JButton biblioRepo = new Botones("BIBLIOGRAFÍA",1,1, sizeXBR, sizeYBR);
    private JButton prestamosRepo = new Botones("PRÉSTAMOS",1,1, sizeXBR, sizeYBR);

    //Botones para usuarios
    private JButton userCrear = new Botones("CREAR",1,1, sizeXUB, sizeYUB);
    private JButton userVer = new Botones("VER",1,1, sizeXUB, sizeYUB);
    private JButton userModificar = new Botones("MODIFICAR",1,1, sizeXUB, sizeYUB);
    private JButton userEliminar = new Botones("ELIMINAR",1,1, sizeXUB, sizeYUB);
    //Botones para bibliografias
    private JButton biblioCrear = new Botones("CREAR",1,1, sizeXUB, sizeYUB);
    private JButton biblioVer = new Botones("VER",1,1, sizeXUB, sizeYUB);
    private JButton biblioModificar= new Botones("MODIFICAR",1,1, sizeXUB, sizeYUB);
    private JButton biblioEliminar = new Botones("ELIMINAR",1,1, sizeXUB, sizeYUB);

    private JButton logout = new Botones("LOGOUT",1,1, sizeXUB, sizeYUB);


    public void iniciarComponentesPanelAdmin(){
        this.getContentPane().add(panelAdministrador);
        panelAdministrador.setLayout(new GridLayout(2,2));

        panelAdministrador.add(panelReportes);
        panelAdministrador.add(panelInfo);
        panelAdministrador.add(panelUsuario);
        panelAdministrador.add(panelLibros);

        panelReportes.setBorder(grafica.bordePanelesAdmin);
        panelInfo.setBorder(grafica.bordePanelesAdmin);
        panelUsuario.setBorder(grafica.bordePanelesAdmin);
        panelLibros.setBorder(grafica.bordePanelesAdmin);


        agregarContenedores(panelReportes, contenedorReportes, tituloReportes);
        agregarContenedores(panelLibros, contenedorLibros, tituloLibros);
        agregarContenedores(panelUsuario, contenedorUsuarios, tituloUsuarios);

        grillasContenedor(contenedorReportes,userRepo);
        grillasContenedor(contenedorReportes,biblioRepo);
        grillasContenedor(contenedorReportes,prestamosRepo);

        grillasContenedor(contenedorLibros,userCrear);
        grillasContenedor(contenedorLibros,userVer);
        grillasContenedor(contenedorLibros,userModificar);
        grillasContenedor(contenedorLibros,userEliminar);

        grillasContenedor(contenedorUsuarios,biblioCrear);
        grillasContenedor(contenedorUsuarios,biblioVer);
        grillasContenedor(contenedorUsuarios,biblioModificar);
        grillasContenedor(contenedorUsuarios,biblioEliminar);
    }

    public PanelAdministrador(String infoUser){
        super(760,500,"PANEL DE ADMINISTRADOR");

        this.informacionUser = infoUser;
        iniciarComponentesPanelAdmin();
    }


    public void agregarContenedores(JPanel panelPrincipal, JPanel contenedor, JLabel tituloPrincipal){
        panelPrincipal.setLayout(new BorderLayout());
        JPanel encabezado = new JPanel();
        JPanel relleno1 = new JPanel();
        JPanel relleno2 = new JPanel();
        JPanel pie = new JPanel();

        encabezado.setBackground(grafica.Blanco);
        relleno1.setBackground(grafica.Blanco);
        relleno2.setBackground(grafica.Blanco);
        pie.setBackground(grafica.Blanco);
        contenedor.setBackground(grafica.Blanco);

        encabezado.add(tituloPrincipal);
        panelPrincipal.add(relleno1, BorderLayout.LINE_START);
        panelPrincipal.add(relleno2, BorderLayout.LINE_END);
        panelPrincipal.add(encabezado, BorderLayout.PAGE_START);
        panelPrincipal.add(contenedor, BorderLayout.CENTER);
        panelPrincipal.add(pie, BorderLayout.PAGE_END);
    }

    public void grillasContenedor(JPanel panelContenedor, JButton botonPanel){
        if(panelContenedor == contenedorLibros || panelContenedor == contenedorUsuarios){
            panelContenedor.setLayout(new GridLayout(2,2,10,10));
        } else if(panelContenedor == contenedorReportes){
            panelContenedor.setLayout(new GridLayout(3,1,10,10));
        }
        panelContenedor.add(botonPanel);

    }

}
