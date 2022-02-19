package GUI;

import javax.swing.*;
import java.awt.*;

public class Formularios extends JFrame {

    public Formularios(){
        this.setSize(500, 500);
        this.setTitle("Prueba1");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        iniciarComponentes();

    }

    private void iniciarComponentes(){
        JPanel panel = new JPanel();
        this.getContentPane().add(panel);
        panel.setLayout(null);

        Botones boton = new Botones();
        boton.setBounds(100,100,100, 40);
        boton.setText("INICIAR SESIÓN");
        panel.add(boton);

    }
}
