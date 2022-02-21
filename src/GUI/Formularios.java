package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Formularios extends JFrame {

    private int LayoutX;
    private int LayoutY;

    protected int sizeX;
    protected int sizeY;
    protected String titulo;
    protected ColoresFuentes grafica = new ColoresFuentes();

    public Formularios(int sizeX, int sizeY, String titulo) throws HeadlessException {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.titulo = titulo;
        this.setSize(sizeX, sizeY);
        this.setUndecorated(true);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        iniciarComponentes();
    }
    private void iniciarComponentes(){
        JPanel BordeSuperior = new JPanel();

        this.getContentPane().add(BordeSuperior);
        BordeSuperior.setBounds(0,0,sizeX,45);
        BordeSuperior.setBackground(grafica.Azul);
        BordeSuperior.setLayout(new BorderLayout());
        BordeSuperior.setBorder(new LineBorder(Color.black,2));

        JLabel tituloPrincipal = new Etiquetas();
        tituloPrincipal.setText(titulo);
        tituloPrincipal.setBackground(grafica.Azul);
        tituloPrincipal.setBounds((sizeX)/2,16,300,16);
        tituloPrincipal.setForeground(grafica.Blanco);
        tituloPrincipal.setFont(grafica.Letra_fuerte);

        JLabel botonCerrar = new Etiquetas();
        botonCerrar.setBackground(grafica.Rojo);
        botonCerrar.setForeground(Color.black);
        botonCerrar.setBounds(17, 14, 18,18);
        botonCerrar.setText("");
        eventosEntradaSalida(botonCerrar, "X");
        botonCerrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0);
            }
        });

        JLabel botonMinimizar = new Etiquetas();
        botonMinimizar.setBackground(grafica.Amarillo);
        botonMinimizar.setForeground(Color.black);
        botonMinimizar.setBounds(42,14,18,18);
        botonMinimizar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Formularios.this.setExtendedState(ICONIFIED);

            }
        });
        eventosEntradaSalida(botonMinimizar, "_");

        BordeSuperior.add(botonMinimizar);
        BordeSuperior.add(botonCerrar);
        BordeSuperior.add(tituloPrincipal, "Center");
        BordeSuperior.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                LayoutX = e.getX();
                LayoutY = e.getY();
            }
        });

        BordeSuperior.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                Formularios.this.setLocation(e.getXOnScreen() - LayoutX, e.getYOnScreen() - LayoutY);
            }
        });
    }

    private void eventosEntradaSalida(JLabel etiqueta, String textoMostrado){
        etiqueta.setFont(grafica.Letra_fuerte);
        etiqueta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                etiqueta.setText(textoMostrado);
                etiqueta.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            public void mouseExited(MouseEvent e){
                super.mouseExited(e);
                etiqueta.setText("");
            }
        });
    }

    public void efectoHover(JButton boton){
        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                boton.setForeground(grafica.Azul);
                boton.setBackground(grafica.Blanco);
                boton.setBorder(new LineBorder(grafica.Azul, 2));
            }

            public void mouseExited(MouseEvent e){
                super.mouseExited(e);
                boton.setForeground(grafica.Blanco);
                boton.setBackground(grafica.Azul);
                boton.setBorder(new LineBorder(grafica.Azul, 2));

            }

        });
    }
}
