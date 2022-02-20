package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;

public class Formularios extends JFrame {

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
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        iniciarComponentes();
    }
    private void iniciarComponentes(){
        JPanel BordeSuperior = new JPanel();
        this.getContentPane().add(BordeSuperior);
        BordeSuperior.setBounds(0,0,sizeX,45);
        BordeSuperior.setBackground(grafica.Azul);
        BordeSuperior.setLayout(null);
        BordeSuperior.setBorder(new LineBorder(Color.black));

        JLabel tituloPrincipal = new JLabel();
        tituloPrincipal.setText(titulo);
        tituloPrincipal.setBounds(222,16,300,16);
        tituloPrincipal.setForeground(grafica.Blanco);
        tituloPrincipal.setFont(grafica.Letra_fuerte);
        BordeSuperior.add(tituloPrincipal);
    }



}
