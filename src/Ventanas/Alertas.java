package Ventanas;

import GUI.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Alertas extends Formularios {

    private String mensajeAlerta;
    private ColoresFuentes graficos = new ColoresFuentes();
    private JPanel panelAlerta = new Paneles();
    private JButton botonAceptar = new Botones("ACEPTAR");
    private JLabel etMensaje = new Etiquetas("", Color.white, Color.black, graficos.Letra_fuerte);

    public Alertas(String mensajeAlerta, String tipoMensaje){
        super(385,225,tipoMensaje);
        this.mensajeAlerta = mensajeAlerta;
        botonMaximizar.setVisible(false);
        iniciarComponentesAlerta();
    }

    public void iniciarComponentesAlerta(){
        this.getContentPane().add(panelAlerta);

        botonAceptar.setBounds(133, 126, 115, 28);
        etMensaje.setBounds(92, 50, 200,40);
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
