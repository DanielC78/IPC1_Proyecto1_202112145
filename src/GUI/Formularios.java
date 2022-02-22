package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Formularios extends JFrame {

    private int LayoutX;
    private int LayoutY;

    protected int sizeX;
    protected int sizeY;
    protected String titulo;
    protected ColoresFuentes grafica = new ColoresFuentes();

    private JPanel BordeSuperior = new JPanel();

    JLabel botonCerrar = new Etiquetas(
            "",
            17,
            14,
            20,
            20,
            grafica.Rojo,
            Color.black,
            grafica.Letra_fuerte
    );

    JLabel botonMinimizar = new Etiquetas(
            "",
            42,
            14,
            20,
            20,
            grafica.Amarillo,
            Color.black,
            grafica.Letra_fuerte
    );



    public Formularios(int sizeX, int sizeY, String titulo) throws HeadlessException {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.titulo = titulo;
        this.setSize(sizeX, sizeY);
        this.setUndecorated(true);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        iniciarComponentesFormularios();
    }
    private void iniciarComponentesFormularios(){

        this.getContentPane().add(BordeSuperior);
        BordeSuperior.setBounds(0,0,sizeX,45);
        BordeSuperior.setBackground(grafica.Azul);
        BordeSuperior.setLayout(new BorderLayout());
        BordeSuperior.setBorder(new LineBorder(Color.black,2));

        eventosEntradaSalida(botonCerrar, "X");
        eventosEntradaSalida(botonMinimizar, "_");

        JLabel tituloPrincipal = new JLabel();
        tituloPrincipal.setText(titulo);
        tituloPrincipal.setBackground(null);
        tituloPrincipal.setFont(grafica.Letra_fuerte);
        tituloPrincipal.setForeground(Color.white);
        tituloPrincipal.setHorizontalAlignment(0);

        BordeSuperior.add(botonMinimizar);
        BordeSuperior.add(botonCerrar);
        BordeSuperior.add(tituloPrincipal);

        botonCerrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                botonCerrarMouseClicked(e);
            }
        });

        botonMinimizar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                botonMinimizarMouseClicked(e);
            }
        });

        BordeSuperior.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
               bordeSuperiorMousePressed(e);
            }
        });

        BordeSuperior.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                bordeSuperiorMouseDragged(e);
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

    private void botonCerrarMouseClicked(MouseEvent e){
        this.dispose();
    }

    private void botonMinimizarMouseClicked(MouseEvent e){
        this.setExtendedState(ICONIFIED);
    }

    private void bordeSuperiorMouseDragged(MouseEvent e){
        this.setLocation(e.getXOnScreen() - LayoutX, e.getYOnScreen() - LayoutY);
    }

    private void bordeSuperiorMousePressed(MouseEvent e){
        LayoutX = e.getX();
        LayoutY = e.getY();
    }
}

