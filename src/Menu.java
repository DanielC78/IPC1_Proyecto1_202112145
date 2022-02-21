import GUI.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;


public class Menu {
    public static void iniciarComponentes(){
        Formularios frame = new Formularios(760,445, "BIBLIOTECA FACULTAD DE INGENIERIA USAC");
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        panel.setOpaque(true);
        panel.setBackground(Color.white);
        panel.setBorder(new LineBorder(Color.black, 2));

        JButton BIniciarSesion = new Botones();
        BIniciarSesion.setBounds(585,111,118,29);
        BIniciarSesion.setText("INICIAR SESIÓN");
        frame.efectoHover(BIniciarSesion);

        JButton BAbout = new Botones();
        BAbout.setBounds(52,381,118,29);
        BAbout.setText("ACERCA DE NOSOTROS");
        frame.efectoHover(BAbout);

        panel.add(BAbout);
        panel.add(BIniciarSesion);
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        iniciarComponentes();
    }


}
