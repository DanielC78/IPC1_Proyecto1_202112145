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
    private static final int sizeX = 750 ;
    private static final int sizeY = 600;

    //Paneles
    //Generales
    private final JPanel panelCargaMasiva = new Paneles();
    private final JPanel panelBotones = new Paneles();
    private final JPanel panelTexto = new Paneles();
    //Centrales
    private final JPanel contenedorBotones = new Paneles();

    //Botones
    private final JButton botonCargar = new Botones("CARGAR");
    private final JButton botonCancelar = new Botones("CANCELAR");

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
        carga.setFont(grafica.letraAreasDeTexto);
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
        //Tamaño de los paneles de relleno
        int width = 20;
        int height = 20;
        panelRelleno.setPreferredSize(new Dimension(width, height));
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
                switch (atributos[0]) {
                    case "0":
                        atributos[0] = "LIBRO";
                        atributos[6] = "---";
                        atributos[7] = "0";
                        atributos[8] = "---";
                        break;
                    case "1":
                        atributos[0] = "REVISTA";
                        atributos[7] = atributos[7].trim();
                        atributos[8] = "---";
                        break;
                    case "2":
                        atributos[0] = "TESIS";
                        atributos[6] = "---";
                        atributos[7] = "0";
                        break;
                }
                Bibliografias nuevoLibro = new Bibliografias(
                        atributos[0], //Tipo
                        atributos[1], //Autor
                        atributos[2], //Título
                        atributos[3], //Descripción
                        atributos[4].trim(), //Edición
                        atributos[5], //Temas
                        atributos[6], //Frecuencia Actual
                        atributos[7], //Ejemplares
                        atributos[8], //Área
                        atributos[9].trim(), //Copias
                        atributos[10].trim() //Disponibles
                        );
                AlmacenLibros.buscarTemasRelacionados();
               /* for (int i = 0; i < AlmacenLibros.buscarTemasRelacionados().length; i++) {
                    if(AlmacenLibros.buscarTemasRelacionados()[i][0] != null){
                        System.out.println("El tema es: "+AlmacenLibros.buscarTemasRelacionados()[i][0]);
                        System.out.println("--------------------------------------------");
                    }
                }*/
                AlmacenLibros.crearBibliografia(nuevoLibro);

            } else{
                System.out.println("Fila omitida, al no cumplir con la estructura de entrada"); //Mensaje en consola si existe una cadena que no tiene todos los atritutos
            }
        }
        new Alertas("CARGA COMPLETADA","").setVisible(true);
    }


}
