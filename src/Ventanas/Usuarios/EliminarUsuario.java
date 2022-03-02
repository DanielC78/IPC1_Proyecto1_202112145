package Ventanas.Usuarios;

import GUI.*;
import Usuarios.Usuario;
import Ventanas.General.Alertas;
import Ventanas.General.PanelAdministrador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EliminarUsuario extends Formularios {

    private static int anchoVentana = 500;
    private static int altoVentana = 450;
    private int indiceEliminar;

    public EliminarUsuario(){
        super(anchoVentana,altoVentana,"ELIMINAR USUARIOS");
        botonMaximizar.setVisible(false);
        componentesEliminarUsuario();
    }


    //Lista de roles

    //Paneles contenedores
    private JPanel panelEliminarUsuario = new Paneles();
    private JPanel contenedorAuxiliarEtiquetas = new Paneles();
    private JPanel contenedorCajas = new Paneles();
    private JPanel contenedorBotones = new Paneles();

    private JPanel contenedorPrincipalEtiquetas = new Paneles();

    //Relleno
    private JPanel rellenoSuperiorCajas = new Paneles();
    private JPanel rellenoInferiorCajas = new Paneles();
    private JPanel rellenoDerechoCajas = new Paneles();
    private JPanel rellenoIzquierdoCajas = new Paneles();
    private JPanel rellenoCajas = new Paneles();
    private JPanel rellenoCentralBotones = new Paneles();
    private JPanel rellenoIzquierdoEtiquetas = new Paneles();
    private JPanel rellenoSuperiorEtiquetas = new Paneles();


    //Botones
    private JButton botonBuscar = new Botones("BUSCAR");
    private JButton botonEliminar = new Botones("ELIMINAR");
    private JButton botonCancelar= new Botones("CANCELAR");

    //Cajas de texto
    private JTextField cajaID = new CajasTexto();
    private JTextField cajaNombre = new CajasTexto();
    private JTextField cajaApellido = new CajasTexto();
    private JTextField cajaUsuario = new CajasTexto();
    private JTextField cajaRol = new CajasTexto();


    private void componentesEliminarUsuario(){
        this.getContentPane().add(panelEliminarUsuario);

        //Layout de los paneles contenedores
        panelEliminarUsuario.setLayout(new BorderLayout());

        contenedorBotones.setLayout(new BorderLayout());
        contenedorBotones.setPreferredSize(new Dimension(anchoVentana,100));

        contenedorCajas.setLayout(new GridLayout(5,1,0,30));

        rellenoCentralBotones.setLayout(new FlowLayout(FlowLayout.CENTER,25,15));

        contenedorPrincipalEtiquetas.setLayout(new BorderLayout());
        contenedorAuxiliarEtiquetas.setLayout(new GridLayout(5,1,24,30));
        contenedorAuxiliarEtiquetas.setPreferredSize(new Dimension(220, altoVentana));

        //Diseño de las etiquetas de texto
        contenedorAuxiliarEtiquetas.setBorder(null);
        rellenoIzquierdoEtiquetas.setBorder(null);
        rellenoSuperiorEtiquetas.setBorder(null);

        rellenoIzquierdoEtiquetas.setPreferredSize(new Dimension(25,sizeY));
        rellenoSuperiorEtiquetas.setPreferredSize(new Dimension(40, 18));

        contenedorPrincipalEtiquetas.add(rellenoSuperiorEtiquetas, BorderLayout.PAGE_START);
        contenedorPrincipalEtiquetas.add(contenedorAuxiliarEtiquetas, BorderLayout.CENTER);
        contenedorPrincipalEtiquetas.add(rellenoIzquierdoEtiquetas, BorderLayout.WEST);

        contenedorAuxiliarEtiquetas.add(botonBuscar);
        agregarEtiqueta("NOMBRE");
        agregarEtiqueta("APELLIDOS");
        agregarEtiqueta("USUARIO");
        agregarEtiqueta("ROL");

        //Diseño de los botones
        agregarRellenoBotones(rellenoSuperiorCajas, BorderLayout.PAGE_START,anchoVentana,10);
        agregarRellenoBotones(rellenoInferiorCajas, BorderLayout.PAGE_END, anchoVentana, 10);
        agregarRellenoBotones(rellenoDerechoCajas, BorderLayout.LINE_END, 10, altoVentana);
        agregarRellenoBotones(rellenoIzquierdoCajas, BorderLayout.LINE_START, 10, altoVentana);
        agregarRellenoBotones(rellenoCentralBotones,BorderLayout.CENTER, 10,10);

        agregarBotones(botonEliminar, FlowLayout.CENTER);
        agregarBotones(botonCancelar, FlowLayout.CENTER);

        //Diseño de las cajas de texto
        rellenoCajas.setLayout(new BorderLayout());
        JPanel cajasIz = new Paneles();
        JPanel cajasSup = new Paneles();
        cajasSup.setPreferredSize(new Dimension(50,20));
        cajasIz.setPreferredSize(new Dimension(50,sizeY));

        cajasIz.setBorder(null);
        cajasSup.setBorder(null);
        rellenoCajas.setBorder(null);
        contenedorCajas.setBorder(null);

        rellenoCajas.add(cajasSup, BorderLayout.PAGE_START);
        rellenoCajas.add(cajasIz, BorderLayout.LINE_END);
        rellenoCajas.add(contenedorCajas, BorderLayout.CENTER);

        agregarCajasNormales(cajaID);
        agregarCajasNormales(cajaNombre);
        agregarCajasNormales(cajaApellido);
        agregarCajasNormales(cajaUsuario);
        agregarCajasNormales(cajaRol);


        //Agregar paneles al panel principal
        agregarPaneles(contenedorBotones, BorderLayout.PAGE_END);
        agregarPaneles(contenedorPrincipalEtiquetas, BorderLayout.WEST);
        agregarPaneles(rellenoCajas, BorderLayout.EAST);

        //Funcionalidad de los botones
        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcionBtnEliminar(e);
            }
        });

        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcionBtnCancelar(e);
            }
        });

        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcionBtnBuscar(e);
            }
        });

    }

    //Agregar elemenos a la ventana
    private void agregarEtiqueta(String texto){
        JLabel etiqueta = new Etiquetas("            " + texto,grafica.Blanco,grafica.Negro,grafica.Letra_fuerte);
        etiqueta.setHorizontalAlignment(SwingConstants.LEFT);
        contenedorAuxiliarEtiquetas.add(etiqueta);
    }
    private void agregarPaneles(JPanel panel, Object alineacion){
        panel.setBorder(null);
        panelEliminarUsuario.add(panel, alineacion);
    }
    private void agregarBotones(JButton boton, Object alineacion){
        boton.setPreferredSize(new Dimension(140, 50));
        rellenoCentralBotones.add(boton, alineacion);
    }
    private void agregarRellenoBotones(JPanel panel, Object alineacion, int ancho, int alto){
        panel.setBorder(null);
        panel.setBackground(grafica.Blanco);
        panel.setPreferredSize(new Dimension(ancho, alto));
        contenedorBotones.add(panel, alineacion);
    }
    private void agregarCajasNormales(JTextField txtNormal){
        if(txtNormal != cajaID){
            txtNormal.setEnabled(false);
        }
        txtNormal.setPreferredSize(new Dimension(180, 25));
        contenedorCajas.add(txtNormal);
    }

    //Funcion de los botones
    private void funcionBtnEliminar(ActionEvent e){
        cajaUsuario.setText("");
        cajaNombre.setText("");
        cajaApellido.setText("");
        cajaID.setText("");
        cajaRol.setText("");

        Usuario eliminacionUsuario = new Usuario();
        new Alertas(eliminacionUsuario.eliminarUsuario(indiceEliminar),"").setVisible(true);

    }

    private void funcionBtnCancelar(ActionEvent e){
        this.setVisible(false);
        new PanelAdministrador().setVisible(true);
        this.dispose();
    }

    private void funcionBtnBuscar(ActionEvent e){
        Usuario datosUsuario = new Usuario();
        String[] matrizDatos;
        if(cajaID.getText().length() > 0){
            matrizDatos = datosUsuario.datosUsuario(cajaID.getText());
            if(matrizDatos[0] != null){
                for (int i = 0; i < matrizDatos.length; i++){
                    System.out.println(matrizDatos[i]);
                }
                cajaNombre.setText(matrizDatos[1]);
                cajaApellido.setText(matrizDatos[2]);
                cajaUsuario.setText(matrizDatos[3]);
                cajaRol.setText(matrizDatos[4]);
                indiceEliminar = Integer.valueOf(matrizDatos[6]);
            } else{
                new Alertas("NO SE ENCONTRÓ AL USUARIO","ERROR").setVisible(true);
            }
        } else{
            new Alertas("DEBE ESCRIBIR UN ID","ERROR").setVisible(true);
        }
    }

}
