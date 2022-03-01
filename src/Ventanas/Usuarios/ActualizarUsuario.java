package Ventanas.Usuarios;

import GUI.*;
import Usuarios.Usuario;
import Usuarios.ValidacionesUsuario;
import Ventanas.Alertas;
import Ventanas.PanelAdministrador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActualizarUsuario extends Formularios {

    private static int anchoVentana = 500;
    private static int altoVentana = 550;
    private String mensajeAlerta;
    private int indiceActualizar;

    public ActualizarUsuario(){
        super(anchoVentana,altoVentana,"ACTUALIZAR USUARIOS");
        botonMaximizar.setVisible(false);
        componentesActualizarUsuario();
    }


    //Lista de roles
    String[] roles = {"SELECCIONAR UN ROL","ESTUDIANTE", "CATEDRÁTICO"};

    //Paneles contenedores
    private JPanel panelCrearUsuario = new Paneles();
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
    private JButton botonGuardar = new Botones("GUARDAR");
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

    private void componentesActualizarUsuario(){
        this.getContentPane().add(panelCrearUsuario);

        //Layout de los paneles contenedores
        panelCrearUsuario.setLayout(new BorderLayout());

        contenedorBotones.setLayout(new BorderLayout());
        contenedorBotones.setPreferredSize(new Dimension(anchoVentana,100));

        contenedorCajas.setLayout(new GridLayout(7,1,0,30));

        rellenoCentralBotones.setLayout(new FlowLayout(FlowLayout.CENTER,25,15));


        contenedorPrincipalEtiquetas.setLayout(new BorderLayout());
        contenedorAuxiliarEtiquetas.setLayout(new GridLayout(7,1,24,30));
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
        agregarEtiqueta("CONTRASEÑA");
        agregarEtiqueta("CONFIRMAR CONTRASEÑA");

        //Diseño de los botones
        agregarRellenoBotones(rellenoSuperiorCajas, BorderLayout.PAGE_START,anchoVentana,10);
        agregarRellenoBotones(rellenoInferiorCajas, BorderLayout.PAGE_END, anchoVentana, 10);
        agregarRellenoBotones(rellenoDerechoCajas, BorderLayout.LINE_END, 10, altoVentana);
        agregarRellenoBotones(rellenoIzquierdoCajas, BorderLayout.LINE_START, 10, altoVentana);
        agregarRellenoBotones(rellenoCentralBotones,BorderLayout.CENTER, 10,10);

        agregarBotones(botonGuardar, FlowLayout.CENTER);
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
        contenedorCajas.add(listaRoles);
        agregarCajasPassword(cajaPassword);
        agregarCajasPassword(cajaConfirmPassword);

        //Agregar paneles al panel principal
        agregarPaneles(contenedorBotones, BorderLayout.PAGE_END);
        agregarPaneles(contenedorPrincipalEtiquetas, BorderLayout.WEST);
        agregarPaneles(rellenoCajas, BorderLayout.EAST);

        //Funcionalidad de los botones
        botonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                funcionBtnActualizar(e);
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
        panelCrearUsuario.add(panel, alineacion);
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
    private void funcionBtnActualizar(ActionEvent e){
        String id = cajaID.getText();
        String nombre = cajaNombre.getText();
        String apellido = cajaApellido.getText();
        String usuario = cajaUsuario.getText();
        String rol = (String)listaRoles.getSelectedItem();
        String password = cajaPassword.getText();
        String confirmPassword = cajaConfirmPassword.getText();

        ValidacionesUsuario validar = new ValidacionesUsuario();
        if(!validar.validacionCamposVacios(id,nombre,apellido,usuario,rol,password,confirmPassword)){
            Usuario actualizarUsuario = new Usuario();
            new Alertas(actualizarUsuario.actualizarUsuario(indiceActualizar,id,nombre,apellido,usuario,rol,password)).setVisible(true);
        }
    }

    private void funcionBtnCancelar(ActionEvent e){
        this.setVisible(false);
        new PanelAdministrador("Daniel Cuque").setVisible(true);
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
                listaRoles.setSelectedItem(matrizDatos[4]);
                cajaPassword.setText(matrizDatos[5]);
                indiceActualizar = Integer.valueOf(matrizDatos[6]);
            } else{
                new Alertas("NO SE ENCONTRÓ AL USUARIO").setVisible(true);
            }
        } else{
            new Alertas("DEBE ESCRIBIR UN ID").setVisible(true);
        }
    }

    //Validacion de campos
    private boolean validarCamposVacios(){
        boolean validacion;
        if(cajaID.getText().isEmpty() || cajaNombre.getText().isEmpty() || cajaApellido.getText().isEmpty() || cajaUsuario.getText().isEmpty()){
            mensajeAlerta = "<html><p style=\"text-align:center\">DEBE DE LLENAR <p>TODOS LOS CAMPOS<p></p><html>";
            validacion = true;

        } else if(listaRoles.getSelectedIndex() == 0){
            mensajeAlerta = "DEBE DE SELECCIONAR UN ROL";
            validacion = true;
        } else{
            validacion = false;
        }

        if(validacion){
            Alertas validacionesCrear = new Alertas(mensajeAlerta);
            validacionesCrear.setVisible(true);
            return true;
        }
        return false;
    }
}
