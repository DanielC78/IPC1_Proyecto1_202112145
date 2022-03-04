package Ventanas.Bibliografias;

import GUI.Botones;
import GUI.Formularios;
import GUI.Paneles;
import Ventanas.General.PanelAdministrador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearLibros extends Formularios {

    //Dimensiones de la ventana
    private static int sizeX = 500;
    private static int sizeY = 500;

    //Tamaño del relleno
    int width = 20;
    int heigth = 20;

    JPanel panelCrearLibros = new Paneles(); //Panel principal del frame
    JPanel panelCentral = new Paneles(); //En este panel estarán los contenedores de los botones
    JPanel panelRegresar = new Paneles();
    JPanel panelBotones = new Paneles();


    //Botones
    private JButton botonCargaMasiva = new Botones("CARGA MASIVA", grafica.letra_titulos);
    private JButton botonCargaIndividual = new Botones("CARGA INDIVIDUAL", grafica.letra_titulos);
    private JButton botonRegresar = new Botones("MENÚ PRINCIPAL", grafica.Letra_fuerte);

    public CrearLibros(){
        super(sizeX,sizeY, "CREAR BIBLIOGRAFIAS");
        componentesCrearLibros();
    }

    private void componentesCrearLibros(){
        this.getContentPane().add(panelCrearLibros);
        panelCrearLibros.setLayout(new BorderLayout());
        agregarRelleno(panelCentral);

        quitarBorde(panelRegresar);
        quitarBorde(panelBotones);

        panelRegresar.setPreferredSize(new Dimension(100,40));

        panelCentral.setLayout(new BorderLayout());
        panelCentral.add(panelRegresar, BorderLayout.PAGE_START);
        panelCentral.add(panelBotones, BorderLayout.CENTER);

        panelRegresar.setLayout(new BorderLayout());
        botonRegresar.setPreferredSize(new Dimension(150, 40));
        panelRegresar.add(botonRegresar, BorderLayout.LINE_END);

        panelBotones.setBorder(grafica.margenPanelesAdmin);
        panelBotones.setLayout(new GridLayout(2,1,20,20));
        panelBotones.add(botonCargaIndividual);
        panelBotones.add(botonCargaMasiva);

        botonRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnMenu(e);
            }
        });
        botonCargaIndividual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCargaIndividual(e);
            }
        });

        botonCargaMasiva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCargaMasiva(e);
            }
        });
    }

    private void agregarRelleno(JPanel panel){
        panelCrearLibros.add(panelRelleno(width,heigth), BorderLayout.PAGE_END);
        panelCrearLibros.add(panelRelleno(width,heigth), BorderLayout.PAGE_START);
        panelCrearLibros.add(panelRelleno(width,heigth), BorderLayout.LINE_END);
        panelCrearLibros.add(panelRelleno(width,heigth), BorderLayout.LINE_START);
        quitarBorde(panel);
        panelCrearLibros.add(panel);
    }

    private void quitarBorde(JPanel panel){
        panel.setBorder(null);
    }

    private JPanel panelRelleno(int width, int height){
        JPanel panelRelleno = new Paneles();
        panelRelleno.setBorder(null);
        panelRelleno.setPreferredSize(new Dimension(width,height));
        return  panelRelleno;
    }

    private void btnMenu(ActionEvent e){
        this.dispose();
        new PanelAdministrador().setVisible(true);
    }

    private void btnCargaMasiva(ActionEvent e){
        this.dispose();
        new CargaMasiva().setVisible(true);
    }

    private void btnCargaIndividual(ActionEvent e){
        this.dispose();
        new CargaIndividual().setVisible(true);

    }
}
