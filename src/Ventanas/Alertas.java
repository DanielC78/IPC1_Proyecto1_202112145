package Ventanas;

import GUI.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Alertas extends Formularios {

    public Alertas(){
        super(385,195,"ERROR");
        iniciarComponentesAlerta();
    }

    protected String mensajeAlerta;
    private ColoresFuentes graficos = new ColoresFuentes();

    private JLabel etMensaje = new Etiquetas(mensajeAlerta, Color.white, Color.black, graficos.Letra_fuerte);

    private JPanel panelAlerta = new Paneles();
    private JButton botonAceptar = new Botones("ACEPTAR");

    public void iniciarComponentesAlerta(){
        this.getContentPane().add(panelAlerta);

        botonAceptar.setBounds(133, 126, 115, 28);
        etMensaje.setBounds(92, 85, 200,40);
        mensajeAlerta = "POR FAVOR FUNCIONA";
        etMensaje.setText(mensajeAlerta);

        panelAlerta.add(etMensaje);
        panelAlerta.add(botonAceptar);

        this.getRootPane().setDefaultButton(botonAceptar);
        botonAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botonAceptarActionPerformed(e);
            }
        });
    }

    private void botonAceptarActionPerformed(ActionEvent e){
        this.dispose();
    }
}
