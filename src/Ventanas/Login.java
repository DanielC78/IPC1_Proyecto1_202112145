package Ventanas;
import GUI.*;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Login {
    //Objetos de otras clases
    private ColoresFuentes graficos = new ColoresFuentes();
    private Inicio inicio = new Inicio();
    //Objetos de la clase Login
    public Formularios frameLogin = new Formularios(395,445,"INICIO DE SESIÓN");
    private JPanel panelLogin = new Paneles();
    //Botones
    private JButton botonIngresar = new Botones();
    private JButton botonCancelar = new Botones();
    //Etiquetas


    public void iniciarComponentesLogin(){
        frameLogin.getContentPane().add(panelLogin);
        frameLogin.setVisible(true);

        botonIngresar.setBounds(238,367,118,29);
        botonIngresar.setText("INGRESAR");
        botonIngresar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });

        botonCancelar.setText("CANCELAR");
        botonCancelar.setBounds(42,367,118,29);
        botonCancelar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                frameLogin.setVisible(false);
                inicio.iniciarComponentesInicio();

            }
        });

        frameLogin.efectoHover(botonCancelar);
        frameLogin.efectoHover(botonIngresar);

        panelLogin.add(botonCancelar);
        panelLogin.add(botonIngresar);
    }



}
