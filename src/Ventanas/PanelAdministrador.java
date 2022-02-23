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
    private JPanel panelContenedorRepo = new Paneles();
    private JPanel rellenoIzq = new JPanel();
    JPanel rellenoDer = new JPanel();

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
    private int sizeXBR = 115;
    private int sizeYBR = 30;

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
    private JButton bibioCrear = new Botones("CREAR",1,1, sizeXUB, sizeYUB);
    private JButton biblioVer = new Botones("VER",1,1, sizeXUB, sizeYUB);
    private JButton bilbioModificar= new Botones("MODIFICAR",1,1, sizeXUB, sizeYUB);
    private JButton biblioEliminar = new Botones("ELIMINAR",1,1, sizeXUB, sizeYUB);

    private JButton logout = new Botones("LOGOUT",1,1, sizeXUB, sizeYUB);



    public PanelAdministrador(String infoUser){
        super(760,500,"PANEL DE ADMINISTRADOR");

        this.informacionUser = infoUser;
        iniciarComponentesPanelAdmin();
    }

    public void iniciarComponentesPanelAdmin(){
        this.getContentPane().add(panelAdministrador);
        panelReportes.setBorder(grafica.bordePanelesAdmin);
        panelInfo.setBorder(grafica.bordePanelesAdmin);
        panelUsuario.setBorder(grafica.bordePanelesAdmin);
        panelLibros.setBorder(grafica.bordePanelesAdmin);

        panelContenedorRepo.setBackground(grafica.Blanco);
        panelContenedorRepo.setBorder(null);
        panelContenedorRepo.setLayout(new GridLayout(4,1));
        rellenoDer.setBackground(grafica.Blanco);
        rellenoIzq.setBackground(grafica.Blanco);

        userRepo.setBorder(grafica.bordeBotones);
        userRepo.setBorder(grafica.bordeBotones);
        prestamosRepo.setBorder(grafica.bordeBotones);

        tituloReportes.setBackground(Color.blue);

        panelContenedorRepo.add(tituloReportes);
        panelContenedorRepo.add(userRepo);
        panelContenedorRepo.add(biblioRepo);
        panelContenedorRepo.add(prestamosRepo);

        panelReportes.setLayout(new GridLayout(1,3));
        panelReportes.add(rellenoIzq);
        panelReportes.add(panelContenedorRepo);
        panelReportes.add(rellenoDer);

        panelAdministrador.setLayout(new GridLayout(2,2));
        panelAdministrador.add(panelReportes);
        panelAdministrador.add(panelInfo);
        panelAdministrador.add(panelUsuario);
        panelAdministrador.add(panelLibros);


    }
}
