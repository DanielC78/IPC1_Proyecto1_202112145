package GUI;

import javax.swing.*;
import java.awt.*;

public class Formularios extends JFrame {

    private static String color_formulario = "#e8d227";

    public void FormularioBase(String titulo, int ancho, int alto, int cerrar){
        Formularios formulario = new Formularios();
        if(cerrar == 1){
            formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        formulario.setVisible(true);
        formulario.setTitle(titulo);
        formulario.setLocationRelativeTo(null);
        formulario.setResizable(false);
        formulario.setSize(ancho, alto);
        formulario.getContentPane().setBackground(Color.decode(color_formulario));

    }





}
