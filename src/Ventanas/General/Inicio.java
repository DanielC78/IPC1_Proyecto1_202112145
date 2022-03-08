package Ventanas.General;

import GUI.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Inicio extends Formularios{


    public Inicio(){
        super(855, 500, "BIBLIOTECA FACULTAD DE INGENIERIA USAC");
        botonMaximizar.setVisible(false);
        iniciarComponentesInicio();
    }


    //Objetos de la clase Inicio
    private JPanel panelInicio = new Paneles();

    //Botones
    private JButton botonIngresar = new Botones("INICAR SESIÓN");
    private JButton botonAbout = new Botones("ACERCA DE NOSOTROS");

    //Etiquetas
    private JLabel marcoLogin = new Etiquetas("", grafica.Blanco, null, grafica.letraTitulos);

    private JLabel marcoAbout = new Etiquetas("", null, null, null);
    private JLabel marcoLogo = new Etiquetas("", null, null, null);

    private void iniciarComponentesInicio(){
        this.getContentPane().add(panelInicio);

        //Paneles
        marcoLogin.setBounds(60,50,750,78);
        marcoLogin.setBorder(grafica.bordeNegro);

        marcoAbout.setBounds(492,160,300,155);
        marcoAbout.setBorder(grafica.bordeNegro);

        marcoLogo.setBorder(grafica.bordeNegro);
        marcoLogo.setBounds(60,160,385,155);

        //Botones
        botonIngresar.setBounds(660,70,132,33);
        botonAbout.setBounds(60,400,170,33);

        panelInicio.add(marcoLogin);
        panelInicio.add(botonIngresar);
        panelInicio.add(botonAbout);
        panelInicio.add(marcoAbout);
        panelInicio.add(marcoLogo);

        botonIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                IngresarActionPerformanced(e);
            }
        });

        botonAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnAbout(e);
            }
        });
    }

    private void IngresarActionPerformanced(ActionEvent e) {
        this.dispose();
        new Login().setVisible(true);
    }

    private void btnAbout(ActionEvent e){
        this.dispose();
        new AcercaDeNostros().setVisible(true);
    }


}
