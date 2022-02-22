package Ventanas;
import GUI.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Login extends Formularios{

    //Objetos de otras clases
    private ColoresFuentes graficos = new ColoresFuentes();

    //Objetos de la clase Login
    public Login(){
        super(395,445,"INICIO DE SESIÓN");
        iniciarComponentesLogin();
    }
    private JPanel panelLogin = new Paneles();

    //Botones
    private JButton botonIngresar = new Botones("INGRESAR",
            238,
            367,
            118,
            29);
    private JButton botonCancelar = new Botones("CANCELAR",
            42,
            367,
            118,
            29);

    //Etiquetas
    private JLabel etUsuario = new Etiquetas(
            "USUARIO",
            83,
            184,
            85,
            16,
            null,
            graficos.Gris,
            graficos.Letra_fuerte

    );
    private JLabel etPassword = new Etiquetas(
            "CONTRASEÑA",
            83,
            264,
            85,
            16,
            null,
            graficos.Gris,
            graficos.Letra_fuerte

    );

    private JLabel etFoto = new Etiquetas(
            "",
            162,
            70,
            80,
            85,
            null,
            null,
            null
    );


    //Cajas de texto
    private JTextField cajaUsuario = new CajasTexto(
            83,
            204,
            229,
            50
    );
    private JTextField cajaPassword = new CajasTexto(
            83,
            284 ,
            229,
            50
    );


    private void iniciarComponentesLogin(){
        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botonIngresarActionPerformed(e);
            }
        });

        this.getContentPane().add(panelLogin);

        etUsuario.setHorizontalAlignment(2);
        etPassword.setHorizontalAlignment(2);
        etFoto.setBorder(graficos.bordeNegro);

        cajaUsuario.setFocusable(true);

        panelLogin.add(etUsuario);
        panelLogin.add(etPassword);
        panelLogin.add(botonCancelar);
        panelLogin.add(botonIngresar);
        panelLogin.add(cajaUsuario);
        panelLogin.add(cajaPassword);
    }

    private void botonIngresarActionPerformed(ActionEvent e){
        new Inicio().setVisible(true);
        this.dispose();
    }

    private void botonCancelarActionPerformed(ActionEvent e){
        new Alertas().setVisible(true);
    }
}
