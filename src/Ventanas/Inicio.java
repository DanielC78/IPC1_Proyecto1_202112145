package Ventanas;

import GUI.*;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Inicio {


    //Objetos de otras clases
    private static Login login = new Login();
    private static ColoresFuentes graficos = new ColoresFuentes();

    //Objetos de la clase Inicio
    public Formularios frameInicio = new Formularios(760,445, "BIBLIOTECA FACULTAD DE INGENIERIA USAC");
    private JPanel panelInicio = new Paneles();
    //Botones
    private JButton botonIngresar = new Botones();
    private JButton botonAbout = new Botones();
    //Etiquetas
    private JLabel marcoLogin = new Etiquetas();
    private JLabel marcoAbout = new Etiquetas();
    private JLabel marcoLogo = new Etiquetas();

    public void iniciarComponentesInicio(){

        frameInicio.getContentPane().add(panelInicio);
        panelInicio.setBorder(graficos.line);

        botonIngresar.setBounds(585,111,118,29);
        botonIngresar.setText("INICIAR SESIÓN");
        frameInicio.efectoHover(botonIngresar);
        botonIngresar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frameInicio.setVisible(false);
                login.iniciarComponentesLogin();
            }
        });

        botonAbout.setBounds(52,381,150,29);
        botonAbout.setText("ACERCA DE NOSOTROS");
        frameInicio.efectoHover(botonAbout);


        marcoLogin.setBorder(graficos.line);
        marcoLogin.setBounds(53,91,665,69);

        marcoAbout.setBorder(graficos.line);
        marcoAbout.setBounds(437,182,280,138);

        marcoLogo.setBorder(graficos.line);
        marcoLogo.setBounds(53, 182, 345, 138);

        panelInicio.add(botonAbout);
        panelInicio.add(botonIngresar);
        panelInicio.add(marcoLogo);
        panelInicio.add(marcoAbout);
        panelInicio.add(marcoLogin);
        frameInicio.setVisible(true);
    }
}
