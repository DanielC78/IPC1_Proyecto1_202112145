package Ventanas;

import GUI.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Inicio extends Formularios{


    public Inicio(){
        super(760, 500, "BIBLIOTECA FACULTAD DE INGENIERIA USAC");
        iniciarComponentesInicio();
    }

    //Objetos de otras clases
    private static ColoresFuentes graficos = new ColoresFuentes();

    //Objetos de la clase Inicio
    private JPanel panelInicio = new Paneles();
    //Botones

    private JButton botonIngresar = new Botones("INICAR SESIÓN",
            585,
            111,
            118,
            29);

    private JButton botonAbout = new Botones("ACERCA DE NOSOTROS",
            52,
            381,
            150,
            29);

    //Etiquetas
    private JLabel marcoLogin = new Etiquetas(
            "",
            53,
            91,
            665,
            69,
            graficos.Blanco,
            Color.black,
            graficos.Letra_fuerte
    );

    private JLabel marcoAbout = new Etiquetas(
            "",
            437,
            182,
            280,
            138,
            null,
            null,
            null

    );
    private JLabel marcoLogo = new Etiquetas("",
            53,
            182,
            345,
            138,
            null,
            null,
            null

    );

    private void iniciarComponentesInicio(){
        botonIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                IngresarActionPerformanced(e);
            }
        });

        this.getContentPane().add(panelInicio);
        marcoLogin.setBorder(graficos.bordeNegro);
        marcoAbout.setBorder(graficos.bordeNegro);
        marcoLogo.setBorder(graficos.bordeNegro);

        panelInicio.add(botonAbout);
        panelInicio.add(botonIngresar);
        panelInicio.add(marcoLogo);
        panelInicio.add(marcoAbout);
        panelInicio.add(marcoLogin);
    }

    private void IngresarActionPerformanced(ActionEvent e) {
        new Login().setVisible(true);
        this.dispose();
    }


}
