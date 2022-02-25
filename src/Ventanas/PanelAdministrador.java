package Ventanas;

import GUI.Botones;
import GUI.Etiquetas;
import GUI.Formularios;
import GUI.Paneles;
import Ventanas.Usuarios.ActualizarUsuario;
import Ventanas.Usuarios.EliminarUsuario;
import Ventanas.Usuarios.VerUsuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    private JLabel tituloReportes = new Etiquetas("REPORTES", null, Color.black, grafica.Letra_fuerte);
    private JLabel tituloLibros = new Etiquetas("BIBLIOGRAFÍAS", null, Color.black, grafica.Letra_fuerte);
    private JLabel tituloUsuarios = new Etiquetas("USUARIOS", null, Color.black, grafica.Letra_fuerte);


    JLabel tituloInfo = new Etiquetas(
      informacionUser, null, grafica.Negro, grafica.Letra_fuerte);

    //Tamaños de los botones del repositorio
    private int sizeXBR = 5;
    private int sizeYBR = 5;

    //Tamaños de los botones de Usuario y Bibliografia
    private int sizeXUB = 1;
    private int sizeYUB = 1;

    //Botones para reportes
    private JButton userRepo = new Botones("USUARIO");
    private JButton biblioRepo = new Botones("BIBLIOGRAFÍA");
    private JButton prestamosRepo = new Botones("PRÉSTAMOS");

    //Botones para usuarios
    private JButton userCrear = new Botones("CREAR");
    private JButton userVer = new Botones("VER");
    private JButton userActualizar = new Botones("MODIFICAR");
    private JButton userEliminar = new Botones("ELIMINAR");

    //Botones para bibliografias
    private JButton biblioCrear = new Botones("CREAR");
    private JButton biblioVer = new Botones("VER");
    private JButton biblioActualizar = new Botones("MODIFICAR");
    private JButton biblioEliminar = new Botones("ELIMINAR");
    private JButton logout = new Botones("LOGOUT");

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

        grillasContenedor(contenedorUsuarios,userCrear);
        grillasContenedor(contenedorUsuarios,userVer);
        grillasContenedor(contenedorUsuarios, userActualizar);
        grillasContenedor(contenedorUsuarios,userEliminar);

        grillasContenedor(contenedorLibros,biblioCrear);
        grillasContenedor(contenedorLibros,biblioVer);
        grillasContenedor(contenedorLibros, biblioActualizar);
        grillasContenedor(contenedorLibros,biblioEliminar);


        userCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnUserCrear(e);
            }
        });

        userActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnUserActualizar(e);
            }
        });

        userEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnUserEliminar(e);
            }
        });

        userVer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnUserVer(e);
            }
        });
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

    public void informacionUsuario(JPanel panelContenedor, JButton botonPanel){

    }

    public void btnUserCrear(ActionEvent e){
        this.setVisible(false);
        new CrearUsuario().setVisible(true);
        this.dispose();
    }

    public void btnUserEliminar(ActionEvent e){
        this.setVisible(false);
        new EliminarUsuario().setVisible(true);
        this.dispose();
    }

    public void btnUserActualizar(ActionEvent e){
        this.setVisible(false);
        new ActualizarUsuario().setVisible(true);
        this.dispose();
    }

    public void btnUserVer(ActionEvent e){
        this.setVisible(false);
        new VerUsuario().setVisible(true);
        this.dispose();
    }

}
