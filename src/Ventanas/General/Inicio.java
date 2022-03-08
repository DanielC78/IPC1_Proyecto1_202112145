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
    private final JPanel panelInicio = new Paneles();

    //Botones
    private final JButton botonIngresar = new Botones("INICAR SESIÓN");
    private final JButton botonAbout = new Botones("ACERCA DE NOSOTROS");

    //Etiquetas
    private final JLabel etiquetaLogo = new Etiquetas("",null,null,null);
    private final JLabel etiquetaVision = new Etiquetas("VISIÓN", null, null,grafica.letraTitulos);
    private final JLabel etiquetaVisionTexto = new Etiquetas("<html>" +
            "<p text-align: center>" +
            " \t\n" +
            " \n" +
            "Constituirse como el Centro líder de información de la Universidad, con el apoyo de las nuevas tecnologías de la información y la comunicación para el almacenamiento, recuperación y difusión de la información" +
            "</p>" +
            "</html>", null,null, grafica.letraAbout);
    private final JLabel marcoLogo = new Etiquetas("", null, null, null);

    private void iniciarComponentesInicio(){
        this.getContentPane().add(panelInicio);

        //Marcos
        marcoLogo.setBorder(grafica.bordeNegro);
        marcoLogo.setBounds(60,160-10,385,155);

        //Textos
        etiquetaVision.setBounds(498,164-10,290,20);
        etiquetaVisionTexto.setBounds(496-10,162+20,290,130);

        //Logo
        etiquetaLogo.setBounds(60,160-10,390,155);
        ajustarImagen(etiquetaLogo,"Imagenes/logoFiusac.png");
        //Botones
        botonIngresar.setBounds(660,70-10,132,33);
        botonAbout.setBounds(60,400-5,170,33);

        panelInicio.add(etiquetaLogo);
        panelInicio.add(etiquetaVision);
        panelInicio.add(etiquetaVisionTexto);
        panelInicio.add(botonIngresar);
        panelInicio.add(botonAbout);
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
        new AcercaDeNostros().setVisible(true);
    }

    private void ajustarImagen(JLabel lbl, String ruta){
        ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource(ruta));
        Icon icono = new ImageIcon(logo.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
        lbl.setIcon(icono);
    }


}
