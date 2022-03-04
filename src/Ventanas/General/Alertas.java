package Ventanas.General;

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
    private JLabel etMensaje = new Etiquetas("", Color.white, Color.black, graficos.letraFuerte);

    public Alertas(String mensajeAlerta, String tipoMensaje){
        super(400,250,tipoMensaje);
        this.mensajeAlerta = mensajeAlerta;
        botonMaximizar.setVisible(false);
        iniciarComponentesAlerta();
    }

    public void iniciarComponentesAlerta(){
        this.getContentPane().add(panelAlerta);
        panelAlerta.setLayout(new BorderLayout());

        botonAceptar.setPreferredSize( new Dimension(10,30));
        panelAlerta.add(botonAceptar, BorderLayout.PAGE_END);
        panelAlerta.add(etMensaje, BorderLayout.CENTER);
        etMensaje.setText(mensajeAlerta);

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
