package Ventanas.General;
import GUI.*;
import Usuarios.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends Formularios{


    //Objetos de la clase Login
    public Login(){
        super(395,500,"INICIO DE SESIÓN");
        botonMaximizar.setVisible(false);
        iniciarComponentesLogin();
    }

    private JPanel panelLogin = new Paneles();

    //Botones
    private JButton botonIngresar = new Botones("INGRESAR");
    private JButton botonCancelar = new Botones("CANCELAR");

    //Etiquetas
    private JLabel etUsuario = new Etiquetas("USUARIO", null,grafica.Gris,grafica.Letra_fuerte

    );
    private JLabel etPassword = new Etiquetas("CONTRASEÑA", null,grafica.Gris,grafica.Letra_fuerte

    );

    private JLabel etFoto = new Etiquetas("", null, null, null);


    //Cajas de texto
    private JTextField cajaUsuario = new CajasTexto();
    private JPasswordField cajaPassword = new JPasswordField();


    private void iniciarComponentesLogin(){
        this.getContentPane().add(panelLogin);

        cajaUsuario.setBounds(83, 204, 229, 50);
        cajaPassword.setBounds(83,284 ,229,50);
        cajaPassword.setOpaque(true);
        cajaPassword.setBorder(grafica.bordeCajas);
        cajaPassword.setFont(grafica.Letra_suave);
        cajaPassword.setForeground(grafica.Gris);
        cajaPassword.setCursor(new Cursor(Cursor.TEXT_CURSOR));

        etUsuario.setBounds(83, 184, 85, 16);
        etPassword.setBounds(83, 264, 85, 16);
        etFoto.setBounds(162, 70, 80, 85);
        botonIngresar.setBounds(238, 367, 118, 29);
        botonCancelar.setBounds(42, 367, 118, 29);

        botonIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botonIngresarActionPerformed(e);
            }
        });

        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botonCancelarActionPerformed(e);
            }
        });

        etUsuario.setHorizontalAlignment(2);
        etPassword.setHorizontalAlignment(2);
        etFoto.setBorder(grafica.bordeNegro);

        cajaUsuario.setFocusable(true);

        panelLogin.add(etFoto);
        panelLogin.add(etUsuario);
        panelLogin.add(etPassword);
        panelLogin.add(botonCancelar);
        panelLogin.add(botonIngresar);
        panelLogin.add(cajaUsuario);
        panelLogin.add(cajaPassword);
    }

    private void botonIngresarActionPerformed(ActionEvent e){
        String user = cajaUsuario.getText();
        String password  = cajaPassword.getText();

        Usuario comprobarUsuario = new Usuario();
        String mensajeAlerta = "";

        String [][] datos = comprobarUsuario.verDatos();

        for (int i = 0; i < datos.length; i++) {
                if(datos[i][0] != null){
                    if(datos[i][3].equals(user)){
                        if(datos[i][5].equals(password)){
                            mensajeAlerta = "";
                            Usuario.setNombreActivo(datos[i][1]);
                            Usuario.setApellidoActivo(datos[i][2]);
                            break;
                        } else{
                            mensajeAlerta = "LA CONTRASEÑA ES INCORRECTA";
                            break;
                        }
                    } else{
                        mensajeAlerta = "EL USUARIO NO EXISTE";
                    }
                }
        }

        if(mensajeAlerta != ""){
            new Alertas(mensajeAlerta,"ERROR").setVisible(true);
        } else{
            if(Usuario.getNombreActivo().equals("Administrador")){
                new PanelAdministrador().setVisible(true);
                this.dispose();
            } else{
                new PanelNormal().setVisible(true);
                this.dispose();
            }
        }


    }

    private void botonCancelarActionPerformed(ActionEvent e){
        this.setVisible(false);
        new Inicio().setVisible(true);
    }
}
