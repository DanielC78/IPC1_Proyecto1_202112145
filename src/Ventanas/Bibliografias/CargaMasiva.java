package Ventanas.Bibliografias;

import Bibliografias.*;
import GUI.Botones;
import GUI.Formularios;
import GUI.Paneles;
import Ventanas.General.Alertas;
import Ventanas.General.PanelAdministrador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CargaMasiva extends Formularios {

    //Tamaño de la ventanas
    private static int sizeX = 700 ;
    private static int sizeY = 600;

    private int width = 20;
    private int height = 20;

    //Paneles
    //Generales
    private JPanel panelCargaMasiva = new Paneles();
    private JPanel panelBotones = new Paneles();
    private JPanel panelTexto = new Paneles();
    //Centrales
    private JPanel contenedorBotones = new Paneles();

    //Botones
    private JButton botonCargar = new Botones("CARGAR");
    private JButton botonCancelar = new Botones("CANCELAR");

    //Texto
    private JScrollPane scrollCarga = new JScrollPane();
    private JTextArea carga = new JTextArea();

    public CargaMasiva(){
        super(sizeX,sizeY,"CARGA MASIVA");
        componentesCargaMasiva();
    }

    private void componentesCargaMasiva(){
        this.getContentPane().add(panelCargaMasiva);
        panelCargaMasiva.setLayout(new BorderLayout());
        panelCargaMasiva.add(panelBotones, BorderLayout.PAGE_END);
        panelCargaMasiva.add(panelTexto, BorderLayout.CENTER);

        panelBotones.setPreferredSize(new Dimension(10,100));
        relleno(panelBotones);
        relleno(panelTexto);

        //Agregamos los botones
        panelBotones.add(contenedorBotones, BorderLayout.CENTER);
        contenedorBotones.setLayout(new FlowLayout(FlowLayout.CENTER,40,10));
        contenedorBotones.setBorder(null);

        botonCargar.setPreferredSize(new Dimension(110,40));
        botonCancelar.setPreferredSize(new Dimension(110,40));

        contenedorBotones.add(botonCargar);
        contenedorBotones.add(botonCancelar);

        //Colocamos el TextArea
        carga.setFont(grafica.letraCargaMasiva);
        scrollCarga.setBorder(grafica.bordeNegro);
        scrollCarga.setViewportView(carga);
        panelTexto.add(scrollCarga, BorderLayout.CENTER);

        //Funcion de los botones
        botonCargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String entradaText = carga.getText();
                cargarLibros(entradaText);
                carga.setText("");
                carga.requestFocus();
            }
        });

        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCancelar(e);
            }
        });
    }

    private void relleno(JPanel panel){
        panel.setBorder(null);
        panel.setLayout(new BorderLayout());
        panel.add(panelRelleno(), BorderLayout.PAGE_START);
        panel.add(panelRelleno(), BorderLayout.PAGE_END);
        panel.add(panelRelleno(), BorderLayout.LINE_END);
        panel.add(panelRelleno(), BorderLayout.LINE_START);
    }

    private JPanel panelRelleno(){
        JPanel panelRelleno = new Paneles();
        panelRelleno.setBorder(null);
        panelRelleno.setPreferredSize(new Dimension(width,height));
        return  panelRelleno;
    }

    private void btnCancelar(ActionEvent e){
        this.dispose();
        new PanelAdministrador().setVisible(true);
    }

    public void cargarLibros(String texto){
        String [] lineasTexto = texto.split("\n");

        for (String linea :
                lineasTexto) {
            String[] atributos = linea.split(";");
            if(atributos.length == 11 && atributos[0].matches("[0-2]") ){
                if(atributos[0].equals("0")){
                    atributos[0] = "Libro";
                    atributos[7] = "0";
                    atributos[8] = "0";
                    atributos[9] = "0";
                } else if(atributos[0].equals("1")){
                    atributos[0] = "Revista";
                    atributos[7] = atributos[7].trim();
                } else if(atributos[0].equals("2")){
                    atributos[0] = "Tesis";
                    atributos[7] = "0";
                    atributos[8] = "0";
                }
                Bibliografias nuevoLibro = new Bibliografias(
                        atributos[0],
                        atributos[1],
                        atributos[2],
                        atributos[3],
                        atributos[4].trim(),
                        atributos[5],
                        atributos[6],
                        atributos[7],
                        atributos[8],
                        atributos[9].trim(),
                        atributos[10].trim()
                        );
                AlmacenLibros.crearBibliografia(nuevoLibro);

            } else{
                System.out.println("Fila omitida, al no cumplir con la estructura de entrada"); //Mensaje en consola si existe una cadena que no tiene todos los atritutos
            }
        }
        new Alertas("CARGA COMPLETADA","").setVisible(true);
    }


}
