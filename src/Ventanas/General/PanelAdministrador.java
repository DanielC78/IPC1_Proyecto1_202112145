package Ventanas.General;

import GUI.Botones;
import GUI.Etiquetas;
import GUI.Formularios;
import GUI.Paneles;
import Usuarios.Usuario;
import Ventanas.Bibliografias.*;
import Ventanas.Usuarios.ActualizarUsuario;
import Ventanas.Usuarios.CrearUsuario;
import Ventanas.Usuarios.EliminarUsuario;
import Ventanas.Usuarios.VerUsuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAdministrador extends Formularios {

    //Credenciales del usuario activo
    private static String nombre = new Usuario().getNombreActivo();
    private static String apellido = new Usuario().getApellidoActivo();

    //Paneles principales
    private JPanel panelAdministrador = new Paneles();
    private JPanel panelReportes = new Paneles();
    private JPanel panelInfo = new Paneles();
    private JPanel panelUsuario = new Paneles();
    private JPanel panelLibros = new Paneles();

    //Contenedores
    private JPanel contenedorReportes = new JPanel();
    private JPanel contenedorLibros= new JPanel();
    private JPanel contenedorUsuarios= new JPanel();

    //Etiquetas de los paneles
    private final JLabel tituloReportes = new Etiquetas("REPORTES", null, grafica.Negro, grafica.letraTitulos);
    private final JLabel tituloLibros = new Etiquetas("BIBLIOGRAFÍAS", null, grafica.Negro, grafica.letraTitulos);
    private final JLabel tituloUsuarios = new Etiquetas("USUARIOS", null, grafica.Negro, grafica.letraTitulos);

    //Informaciond del usuario
    private JLabel tituloInfo = new Etiquetas(nombre+" "+apellido, null, grafica.Negro, grafica.letraTitulos);
    private JLabel fotoInfo = new Etiquetas("", null, grafica.Negro, null);

    //Botones para reportes
    private JButton userRepo = new Botones("USUARIO",grafica.letraTitulos);
    private JButton biblioRepo = new Botones("BIBLIOGRAFÍA",grafica.letraTitulos);
    private JButton prestamosRepo = new Botones("PRÉSTAMOS",grafica.letraTitulos);

    //Botones para usuarios
    private JButton userCrear = new Botones("CREAR", grafica.letraTitulos);
    private JButton userVer = new Botones("VER",grafica.letraTitulos);
    private JButton userActualizar = new Botones("MODIFICAR",grafica.letraTitulos);
    private JButton userEliminar = new Botones("ELIMINAR",grafica.letraTitulos);

    //Botones para bibliografias
    private JButton biblioCrear = new Botones("CREAR",grafica.letraTitulos);
    private JButton biblioVer = new Botones("VER",grafica.letraTitulos);
    private JButton biblioActualizar = new Botones("MODIFICAR",grafica.letraTitulos);
    private JButton biblioEliminar = new Botones("ELIMINAR",grafica.letraTitulos);

    //Logout
    private JButton logout = new Botones("LOGOUT",grafica.letraTitulos);


    public PanelAdministrador(){
        super(1100,700,"PANEL DE ADMINISTRADOR");
        iniciarComponentesPanelAdmin();
    }

    public void iniciarComponentesPanelAdmin(){
        this.getContentPane().add(panelAdministrador);
        panelAdministrador.setLayout(new GridLayout(2,2));

        //Agregando paneles principales
        panelAdministrador.add(panelReportes);
        panelAdministrador.add(panelInfo);
        panelAdministrador.add(panelUsuario);
        panelAdministrador.add(panelLibros);


        //Borde espaciado para los paneles principales
        panelReportes.setBorder(grafica.bordePanelesAdmin);
        panelInfo.setBorder(grafica.bordePanelesAdmin);
        panelUsuario.setBorder(grafica.bordePanelesAdmin);
        panelLibros.setBorder(grafica.bordePanelesAdmin);


        //Agregando paneles contenedores
        agregarContenedores(panelReportes, contenedorReportes, tituloReportes);
        agregarContenedores(panelLibros, contenedorLibros, tituloLibros);
        agregarContenedores(panelUsuario, contenedorUsuarios, tituloUsuarios);

        //Separacion de botones en el panel contenedor de reportes
        grillasContenedor(contenedorReportes,userRepo);
        grillasContenedor(contenedorReportes,biblioRepo);
        grillasContenedor(contenedorReportes,prestamosRepo);

        //Seperacion de botones en el panel de Usuarios
        grillasContenedor(contenedorUsuarios,userCrear);
        grillasContenedor(contenedorUsuarios,userVer);
        grillasContenedor(contenedorUsuarios, userActualizar);
        grillasContenedor(contenedorUsuarios,userEliminar);

        //Seperacion de botones en el panel de Bibliografias
        grillasContenedor(contenedorLibros,biblioCrear);
        grillasContenedor(contenedorLibros,biblioVer);
        grillasContenedor(contenedorLibros, biblioActualizar);
        grillasContenedor(contenedorLibros,biblioEliminar);

        //Agregamos el Panel de LogOut en el panel principal
        informacionUsuario(panelInfo, logout, tituloInfo);

        //Funcion de los botones para Usuarios
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

        //Funcion de los botones para Bibliografias

        biblioCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnBiblioCrear(e);
            }
        });

        biblioActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnBiblioActualizar(e);
            }
        });

        biblioEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnBiblioEliminar(e);
            }
        });

        biblioVer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnBiblioVer(e);
            }
        });

        //Funcion de los botones para los Reportes


        //LogOut
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnLogOut(e);
            }
        });
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

    public void informacionUsuario(JPanel panelContenedor, JButton botonPanel, JLabel nombre){
        JPanel foto = new Paneles();
        foto.setBorder(null);
        foto.setLayout(new BorderLayout());
        foto.add(fotoInfo,BorderLayout.CENTER);

        JPanel informacion = new Paneles();
        informacion.setBorder(null);
        informacion.setLayout(new GridLayout(4,3));
        informacion.add(new JLabel());
        informacion.add(new JLabel());
        informacion.add(new JLabel());
        informacion.add(new JLabel());
        informacion.add(nombre);
        informacion.add(new JLabel());
        informacion.add(new JLabel());
        informacion.add(botonPanel);
        informacion.add(new JLabel());
        informacion.add(new JLabel());


        panelContenedor.setLayout(new BorderLayout());
        panelContenedor.add(foto, BorderLayout.PAGE_START);
        panelContenedor.add(informacion, BorderLayout.CENTER);
    }

    private void btnUserCrear(ActionEvent e){
        this.setVisible(false);
        new CrearUsuario().setVisible(true);
        this.dispose();
    }

    private void btnUserEliminar(ActionEvent e){
        this.setVisible(false);
        new EliminarUsuario().setVisible(true);
        this.dispose();
    }

    private void btnUserActualizar(ActionEvent e){
        this.setVisible(false);
        new ActualizarUsuario().setVisible(true);
        this.dispose();
    }

    private void btnUserVer(ActionEvent e){
        this.setVisible(false);
        new VerUsuario().setVisible(true);
        this.dispose();
    }

    private void btnBiblioCrear(ActionEvent e){
        this.dispose();
        new CrearLibros().setVisible(true);
    }


    private void btnBiblioEliminar(ActionEvent e){

        this.dispose();
        new EliminarLibros().setVisible(true);
    }

    private void btnBiblioActualizar(ActionEvent e){
        this.dispose();
        new PanelActualizarLibros().setVisible(true);

    }

    private void btnBiblioVer(ActionEvent e){
        this.dispose();
        new VerLibros().setVisible(true);
    }

    private void btnLogOut(ActionEvent e){
        Usuario.setNombreActivo(null);
        Usuario.setApellidoActivo(null);
        this.setVisible(false);
        new Login().setVisible(true);
        this.dispose();
    }


}
