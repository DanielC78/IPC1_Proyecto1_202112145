package Ventanas.General;

import GUI.Botones;
import GUI.Etiquetas;
import GUI.Formularios;
import GUI.Paneles;
import Usuarios.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelNormal extends Formularios {

    //Dimensiones de la ventana
    private static int sizeX = 1000;
    private static int sizeY = 600;

    //Dimensiones del relleno
    private int anchoRelleno = 10;
    private int altoRelleno = 30;

    //Paneles princiaples
    private JPanel panelNormal = new Paneles();
    private JPanel panelPrincipal = new Paneles();
    private JPanel panelSuperior = new Paneles();
    private JPanel panelInferior = new Paneles();

    //Paneles secundarios superiores
    private JPanel panelLogo = new Paneles();
    private JPanel panelLogOut = new Paneles();

    //Contenedores de informacion
    private JPanel panelFoto = new Paneles();
    private JPanel panelNombre = new Paneles();
    private JPanel panelBotonLogout = new Paneles();

    //Paneles secunadrios inferiores
    private JPanel panelBotones = new Paneles();
    private JPanel panelTabla = new Paneles();

    //Etiquetas
    private JLabel etLogo = new Etiquetas("",grafica.Blanco,null,null);
    private JLabel etNombre = new Etiquetas(
            "<html><p style=\"text-align:center\">BIENVENIDO<p style=\"text-align:center\">"+ Usuario.getNombreActivo().toUpperCase()+" "+Usuario.getApellidoActivo().toUpperCase()+"<p></p><html>",null,grafica.Negro,grafica.letra_titulos);
    private JLabel etFoto = new Etiquetas("",null,grafica.Blanco, null);

    //Imagenes
    private ImageIcon logo;
    private Icon icono;

    //Tabla de datos
    private JScrollPane scrollTabla = new JScrollPane();
    private JTable tablaInformacion = new JTable();

    //Botones
    private JButton botonLogOut = new Botones("LOGOUT");

    public PanelNormal() {
        super(sizeX, sizeY, "USUARIO NORMAL");
        componentesPanelNormal();

    }

    private void componentesPanelNormal(){
        this.getContentPane().add(panelNormal);
        //Elementos de la CAPA 1
        rellenoPaneles(panelNormal);

        panelPrincipal.setBorder(null);
        panelNormal.add(panelPrincipal, BorderLayout.CENTER);

        //Paneles de capa 2
        agregarPanelesContenedores(panelSuperior);
        agregarPanelesContenedores(panelInferior);

        //Paneles de capa 3
        panelSuperior.setLayout(new BorderLayout());

        agregarPanelesSuperiores(panelLogo, BorderLayout.LINE_START,400,100);
        agregarPanelesSuperiores(panelLogOut,BorderLayout.LINE_END, 550,100);

        //Agregando el logo al panel
        rellenoPaneles(panelLogo);

        etLogo.setSize(new Dimension(300,100));
        ajustarImagen(etLogo,"src/Imagenes/logoFiusac.png");
        panelLogo.add(etLogo, BorderLayout.CENTER);

        //Agregando los datos del usuario
        //Añadiendo los paneles que tendrán la infomracion del usuario
        panelLogOut.setLayout(new GridLayout(1,3));
        panelBotonLogout.setBorder(grafica.bordeNegro);
        panelLogOut.add(panelFoto);
        panelLogOut.add(panelNombre);
        panelLogOut.add(panelBotonLogout);

        etFoto.setBorder(grafica.bordeNegro);
        etFoto.setSize(100,100);
        ajustarImagen(etFoto,"src/Imagenes/user.png");
        agregarRellenoInformacion(panelFoto);
        agregarRellenoInformacion(panelNombre);
        agregarRellenoInformacion(panelBotonLogout);

        //Agregamos los elementos a los paneles de informacion
        panelFoto.add(etFoto, BorderLayout.CENTER);
        panelNombre.add(etNombre, BorderLayout.CENTER);
        panelBotonLogout.setLayout(new BorderLayout());
        panelBotonLogout.add(panelRelleno(10,100),BorderLayout.PAGE_START);
        panelBotonLogout.add(panelRelleno(10,100),BorderLayout.PAGE_END);
        panelBotonLogout.add(panelRelleno(10,100), BorderLayout.LINE_END);
        panelBotonLogout.add(botonLogOut, BorderLayout.CENTER);
        panelLogOut.setBorder(grafica.bordeNegro);

        //Funcion de los botones
        botonLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnLogout(e);
            }
        });
    }

    private void rellenoPaneles(JPanel panelNormal) {
        panelNormal.setLayout(new BorderLayout());
        panelNormal.add(panelRelleno(anchoRelleno,altoRelleno), BorderLayout.LINE_END);
        panelNormal.add(panelRelleno(anchoRelleno,altoRelleno), BorderLayout.PAGE_END);
        panelNormal.add(panelRelleno(anchoRelleno,altoRelleno), BorderLayout.LINE_START);
        panelNormal.add(panelRelleno(anchoRelleno,altoRelleno), BorderLayout.PAGE_START);
    }

    private void agregarRellenoInformacion(JPanel panelInfo){
        panelInfo.setBorder(null);
        panelInfo.setLayout(new BorderLayout());
        panelInfo.add(panelRelleno(anchoRelleno,altoRelleno), BorderLayout.LINE_END);
        panelInfo.add(panelRelleno(anchoRelleno,altoRelleno), BorderLayout.LINE_START);
        panelInfo.add(panelRelleno(anchoRelleno,altoRelleno), BorderLayout.PAGE_START);
        panelInfo.add(panelRelleno(anchoRelleno,altoRelleno), BorderLayout.PAGE_END);
    }


    private void agregarPanelesContenedores(JPanel panel){
        panel.setBorder(null);
        panelPrincipal.setLayout(new GridLayout(2,1));
        panelPrincipal.add(panel);
    }

    private void agregarPanelesSuperiores(JPanel panelDatos, Object alineacion, int width, int height){
        panelDatos.setPreferredSize(new Dimension(width,height));
        panelDatos.setBorder(null);
        panelSuperior.add(panelDatos, alineacion);
    }

    private void ajustarImagen(JLabel lbl, String ruta){
        this.logo = new ImageIcon(ruta);
        this.icono = new ImageIcon(this.logo.getImage().getScaledInstance(lbl.getWidth(),lbl.getHeight(), Image.SCALE_DEFAULT));
        lbl.setIcon(this.icono);

    }

    private JPanel panelRelleno(int width, int height){
        JPanel panelRelleno = new Paneles();
        panelRelleno.setBorder(null);
        panelRelleno.setPreferredSize(new Dimension(width,height));
        return  panelRelleno;
    }

    private void btnLogout(ActionEvent e){
        new Login().setVisible(true);
        this.dispose();
    }
}
