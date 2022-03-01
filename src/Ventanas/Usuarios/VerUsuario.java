package Ventanas.Usuarios;

import GUI.Etiquetas;
import GUI.Formularios;
import GUI.Paneles;
import Usuarios.Usuario;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VerUsuario extends Formularios {

    private JPanel panelVerUsuario = new Paneles();
    private JPanel contenedorTabla = new Paneles();
    private JPanel contenedorEncabezado = new Paneles();
    private JTable tablaDatos = new JTable();

    private static int sizeX = 700;
    private static int sizeY = 500;

    public VerUsuario() throws HeadlessException {
        super(sizeX, sizeY,"VER USUARIOS");
        componentesVerUsuario();

    }

    private void componentesVerUsuario(){

        this.getContentPane().add(panelVerUsuario);
        panelVerUsuario.setLayout(new BorderLayout());
        addPanelesPrincipal(contenedorEncabezado, BorderLayout.PAGE_START, sizeX, 50);
        addPanelesPrincipal(contenedorTabla, BorderLayout.CENTER, sizeX, sizeY);

        tablaDatos.setBorder(new CompoundBorder(new EmptyBorder(10,10,10,10), grafica.bordeNegro));
        tablaDatos.setPreferredSize(new Dimension(200,200));

        contenedorEncabezado.add(new JLabel("LISTA DE USUARIOS"), BorderLayout.LINE_START);
        contenedorTabla.add(tablaDatos, BorderLayout.CENTER);
        mostrarUsuarios();

    }

    private void addPanelesPrincipal(JPanel contenedor,  Object alineacion, int ancho, int alto){
        contenedor.setLayout(new BorderLayout());
        contenedor.setBorder(null);
        contenedor.setPreferredSize(new Dimension(ancho , alto));

        panelVerUsuario.add(contenedor, alineacion);
    }

    private void mostrarUsuarios(){
        Usuario verUsuarios = new Usuario();
        DefaultTableModel modelo = (DefaultTableModel) tablaDatos.getModel();
        for(int i = 0; i < verUsuarios.verDatos().length; i++){
            for(int j = 0; j < verUsuarios.verDatos()[i].length; j++){
                tablaDatos.setValueAt(verUsuarios.verDatos()[i][j], i, j);
            }
        }
    }
}
