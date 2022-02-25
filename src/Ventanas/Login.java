package Ventanas;
import GUI.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class Login extends Formularios{


    //Objetos de la clase Login
    public Login(){
        super(395,500,"INICIO DE SESIÓN");
        iniciarComponentesLogin();
    }

    private JPanel panelLogin = new Paneles();

    //Botones
    private JButton botonIngresar = new Botones("INGRESAR");
    private JButton botonCancelar = new Botones("CANCELAR");

    //Etiquetas
    private JLabel etUsuario = new Etiquetas(
            "USUARIO",
            null,
            grafica.Gris,
            grafica.Letra_fuerte

    );
    private JLabel etPassword = new Etiquetas(
            "CONTRASEÑA",
            null,
            grafica.Gris,
            grafica.Letra_fuerte

    );

    private JLabel etFoto = new Etiquetas("", null, null, null);


    //Cajas de texto
    private JTextField cajaUsuario = new CajasTexto();
    private JPasswordField cajaPassword = new JPasswordField();


    private void iniciarComponentesLogin(){
        this.getContentPane().add(panelLogin);

        cajaUsuario.setBounds(83, 204, 229, 50);
        cajaPassword.setBounds(83,284 ,229,50);
        cajaPassword.setOpaque(true);
        cajaPassword.setBorder(grafica.bordeCajas);
        cajaPassword.setFont(grafica.Letra_suave);
        cajaPassword.setForeground(grafica.Gris);
        cajaPassword.setCursor(new Cursor(Cursor.TEXT_CURSOR));

        botonIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botonIngresarActionPerformed(e);
            }
        });

        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botonCancelarActionPerformed(e);
            }
        });

        etUsuario.setHorizontalAlignment(2);
        etPassword.setHorizontalAlignment(2);
        etFoto.setBorder(grafica.bordeNegro);

        cajaUsuario.setFocusable(true);

        panelLogin.add(etFoto);
        panelLogin.add(etUsuario);
        panelLogin.add(etPassword);
        panelLogin.add(botonCancelar);
        panelLogin.add(botonIngresar);
        panelLogin.add(cajaUsuario);
        panelLogin.add(cajaPassword);
    }

    private void botonIngresarActionPerformed(ActionEvent e){
        new PanelAdministrador("Usuario".toUpperCase()).setVisible(true);
        this.dispose();
    }

    private void botonCancelarActionPerformed(ActionEvent e){
        this.setVisible(false);
        new Inicio().setVisible(true);
    }
}
