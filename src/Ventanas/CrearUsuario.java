package Ventanas;

import GUI.*;
import Usuarios.Usuario;
import Usuarios.ValidacionesUsuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CrearUsuario extends Formularios {

    private static int anchoVentana = 500;
    private static int altoVentana = 550;

    public CrearUsuario(){
        super(anchoVentana, altoVentana,"CREAR USUARIOS");
        botonMaximizar.setVisible(false);
        componentesCrearUsuario();
    }

    //Lista de roles
    String[] roles = {"SELECCIONAR UN ROL","ESTUDIANTE", "CATEDRÁTICO"};

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
    private JPanel rellenoCajas = new Paneles();

    //Botones
    private JButton botonCrear = new Botones("CREAR");
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

        contenedorCajas.setLayout(new GridLayout(7,1,0,30));

        rellenoCentral.setLayout(new FlowLayout(FlowLayout.CENTER,25,15));

        agregarRellenoBotones(rellenoSuperior, BorderLayout.PAGE_START,anchoVentana,10);
        agregarRellenoBotones(rellenoInferior, BorderLayout.PAGE_END, anchoVentana, 10);
        agregarRellenoBotones(rellenoDerecho, BorderLayout.LINE_END, 10, altoVentana);
        agregarRellenoBotones(rellenoIzquierdo, BorderLayout.LINE_START, 10, altoVentana);
        agregarRellenoBotones(rellenoCentral,BorderLayout.CENTER, 10,10);

        agregarBotones(botonCrear, FlowLayout.CENTER);
        agregarBotones(botonCancelar, FlowLayout.CENTER);

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
        contenedorCajas.add(listaRoles);
        agregarCajasPassword(cajaPassword);
        agregarCajasPassword(cajaConfirmPassword);

        agregarPaneles(contenedorBotones, BorderLayout.PAGE_END);
        agregarPaneles(contenedorEtiquetas, BorderLayout.WEST);
        agregarPaneles(rellenoCajas, BorderLayout.EAST);

        botonCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcionBtnCrear(e);
            }
        });

        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcionBtnCancelar(e);
            }
        });


    }

    //Agregar elemenos a la ventana
    private void agregarEtiqueta(String texto){
        JLabel etiqueta = new Etiquetas("                    " + texto,grafica.Blanco,grafica.Negro,grafica.Letra_fuerte);
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

    //Funcion de los botones
    private void funcionBtnCrear(ActionEvent e){
        String id = cajaID.getText();
        String nombre = cajaNombre.getText();
        String apellido = cajaApellido.getText();
        String usuario = cajaUsuario.getText();
        String rol = (String)listaRoles.getSelectedItem();
        String password = cajaPassword.getText();
        String confirmPassword = cajaConfirmPassword.getText();

        ValidacionesUsuario validar = new ValidacionesUsuario();
        if(!validar.validacionCamposVacios(id,nombre,apellido,usuario,rol,password,confirmPassword)){
            Usuario crearUsuario = new Usuario();
            crearUsuario.setID(id);
            crearUsuario.setNombres(nombre);
            crearUsuario.setApellidos(apellido);
            crearUsuario.setUser(usuario);
            crearUsuario.setRol(rol);
            crearUsuario.setPassword(password);

            if(crearUsuario.crearUsuario()){
                System.out.println("Usuario creado con exito");
            } else{
                System.out.println("No se pudo crear");
            }
        }

    }
    private void funcionBtnCancelar(ActionEvent e){
        this.setVisible(false);
        new PanelAdministrador("Daniel Cuque").setVisible(true);
        this.dispose();
    }

}
