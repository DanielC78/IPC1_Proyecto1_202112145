package Ventanas;

import GUI.*;

import javax.swing.*;
import java.awt.*;

public class CrearUsuario extends Formularios {

    private static int anchoVentana = 500;
    private static int altoVentana = 600;

    public CrearUsuario(){
        super(anchoVentana, altoVentana,"CREAR USUARIOS");
        componentesCrearUsuario();
    }

    //Lista de roles
    String[] roles = {"ESTUDIANTE", "CATEDRÁTICO"};

    //Paneles contenedores
    private JPanel panelCrearUsuario = new Paneles();
    private JPanel contenedorEtiquetas = new Paneles();
    private JPanel contenedorCajas = new Paneles();
    private JPanel contenedorBotones = new Paneles();

    //Relleno
    private JPanel rellenoSuperior = new Paneles();
    private JPanel rellenoInferior = new Paneles();
    private JPanel rellenoDerecho = new Paneles();
    private JPanel rellenoIzquierdo = new Paneles();
    private JPanel rellenoCentral = new Paneles();

    //Botones
    private JButton botonAceptar= new Botones("CREAR");
    private JButton botonCancelar= new Botones("CANCELAR");

    //Cajas de texto
    private JTextField cajaID = new CajasTexto();
    private JTextField cajaNombre = new CajasTexto();
    private JTextField cajaApellido = new CajasTexto();
    private JTextField cajaUsuario = new CajasTexto();

    //Caja de contraseñas
    private JPasswordField cajaPassword = new JPasswordField();
    private JPasswordField cajaConfirmPassword = new JPasswordField();

    //Menu de opciones
    private JComboBox<String> listaRoles = new JComboBox<>(roles);

    private void componentesCrearUsuario(){
        this.getContentPane().add(panelCrearUsuario);
        
        panelCrearUsuario.setLayout(new BorderLayout());
        contenedorEtiquetas.setLayout(new GridLayout(7,1));
        contenedorEtiquetas.setPreferredSize(new Dimension(220, altoVentana));

        agregarEtiqueta("ID");
        agregarEtiqueta("NOMBRE");
        agregarEtiqueta("APELLIDOS");
        agregarEtiqueta("USUARIO");
        agregarEtiqueta("ROL");
        agregarEtiqueta("CONTRASEÑA");
        agregarEtiqueta("CONFIRMAR CONTRASEÑA");

        contenedorBotones.setLayout(new BorderLayout());
        contenedorBotones.setPreferredSize(new Dimension(anchoVentana,100));

        contenedorCajas.setLayout(new GridLayout(7,1));

        rellenoCentral.setLayout(new FlowLayout(FlowLayout.CENTER,25,15));

        agregarRellenoBotones(rellenoSuperior, BorderLayout.PAGE_START,anchoVentana,10);
        agregarRellenoBotones(rellenoInferior, BorderLayout.PAGE_END, anchoVentana, 10);
        agregarRellenoBotones(rellenoDerecho, BorderLayout.LINE_END, 10, altoVentana);
        agregarRellenoBotones(rellenoIzquierdo, BorderLayout.LINE_START, 10, altoVentana);
        agregarRellenoBotones(rellenoCentral,BorderLayout.CENTER, 10,10);

        agregarBotones(botonAceptar, FlowLayout.CENTER);
        agregarBotones(botonCancelar, FlowLayout.CENTER);

        agregarCajasNormales(cajaID);
        agregarCajasNormales(cajaNombre);
        agregarCajasNormales(cajaApellido);
        agregarCajasNormales(cajaUsuario);
        contenedorCajas.add(listaRoles);
        agregarCajasPassword(cajaPassword);
        agregarCajasPassword(cajaConfirmPassword);

        agregarPaneles(contenedorBotones, BorderLayout.PAGE_END);
        agregarPaneles(contenedorEtiquetas, BorderLayout.WEST);
        agregarPaneles(contenedorCajas, BorderLayout.EAST);

    }

    private void agregarEtiqueta(String texto){
        JLabel etiqueta = new Etiquetas("         " + texto,grafica.Blanco,grafica.Negro,grafica.Letra_fuerte);
        etiqueta.setHorizontalAlignment(SwingConstants.LEFT);
        contenedorEtiquetas.add(etiqueta);
    }

    private void agregarPaneles(JPanel panel, Object alineacion){
        panel.setBorder(null);
        panelCrearUsuario.add(panel, alineacion);
    }

    private void agregarBotones(JButton boton, Object alineacion){
        boton.setPreferredSize(new Dimension(140, 50));
        rellenoCentral.add(boton, alineacion);
    }

    private void agregarRellenoBotones(JPanel panel, Object alineacion, int ancho, int alto){
        panel.setBorder(null);
        panel.setBackground(grafica.Blanco);
        panel.setPreferredSize(new Dimension(ancho, alto));
        contenedorBotones.add(panel, alineacion);
    }

    private void agregarCajasPassword(JPasswordField txtPassword){
        txtPassword.setBorder(grafica.bordeCajas);
        txtPassword.setFont(grafica.Letra_suave);
        txtPassword.setForeground(grafica.Gris);
        txtPassword.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        contenedorCajas.add(txtPassword);
    }

    private void agregarCajasNormales(JTextField txtNormal){
        contenedorCajas.add(txtNormal);
    }


}
