package Ventanas;

import GUI.Botones;
import GUI.Etiquetas;
import GUI.Formularios;
import GUI.Paneles;

import javax.swing.*;
import java.awt.*;

public class CrearUsuario extends Formularios {

    public CrearUsuario(){
        super(500,500,"CREAR USUARIOS");
        componentesCrearUsuario();
    }

    //Lista de roles
    String[] roles = {"ESTUDIANTE", "CATEDRÁTICO"};

    //Paneles
    private JPanel panelCrearUsuario = new Paneles();
    private JPanel contenedorEtiquetas = new Paneles();
    private JPanel contenedorCajas = new Paneles();
    private JPanel contenedorBotones = new Paneles();

    //Botones
    private JButton botonAceptar= new Botones("CREAR");
    private JButton botonCancelar= new Botones("CANCELAR");

    //Menu de opciones
    private JComboBox<String> listaRoles = new JComboBox<>(roles);

    private void componentesCrearUsuario(){
        this.getContentPane().add(panelCrearUsuario);

        panelCrearUsuario.setLayout(new BorderLayout());
        panelCrearUsuario.add(contenedorEtiquetas, BorderLayout.WEST);
        panelCrearUsuario.add(contenedorCajas, BorderLayout.EAST);
        panelCrearUsuario.add(contenedorBotones,BorderLayout.PAGE_END);

        contenedorEtiquetas.setLayout(new GridLayout(1,7));
        agregarEtiqueta("ID");
        agregarEtiqueta("NOMBRE");
        agregarEtiqueta("APELLIDOS");
        agregarEtiqueta("USUARIO");
        agregarEtiqueta("ROL");
        agregarEtiqueta("CONTRASEÑA");
        agregarEtiqueta("CONFIRMAR CONTRASEÑA");
    }

    private void agregarEtiqueta(String texto){
        JLabel etiqueta = new Etiquetas(texto,grafica.Blanco,grafica.Negro,grafica.Letra_fuerte);
        etiqueta.add(contenedorEtiquetas);

    }

}
