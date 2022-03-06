package Ventanas.Prestamos;

import Bibliografias.AlmacenLibros;
import GUI.*;
import Usuarios.Usuario;
import Ventanas.General.Alertas;
import Ventanas.General.PanelNormal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerPrestamos extends Formularios {

    //Dimensiones de la ventana
    private final static int sizeX = 550 ;
    private final static int sizeY = 500;
    private final static String tituloVentana = "VER PRÉSTAMOS";

    //Paneles
    private final JPanel panelVerPrestamos = new Paneles();
    private final JPanel contenedorTabla = new Paneles();
    private final JPanel contenedorSuperior = new Paneles();
    private final JPanel contenedorInferior = new Paneles();

    //Parte superior
    private final JLabel etiquetaListado = new Etiquetas("LISTADO DE PRÉSTAMOS",null, grafica.Negro,grafica.letraTitulos);

    //Botones
    private final JButton botonMenuPrincipal = new Botones("REGRESAR",grafica.letraTitulos);
    private final JButton botonDevolver = new Botones("DEVOLVER");

    //Componentes de la tabla
    private DefaultTableModel modeloTabla;
    private final JScrollPane scrollTabla = new JScrollPane();
    private JTable tablaPrestamos;

    public VerPrestamos() throws HeadlessException {
        super(sizeX, sizeY, tituloVentana);
        componentesVerPrestamos();
    }

    private void componentesVerPrestamos(){
        this.getContentPane().add(panelVerPrestamos);
        panelVerPrestamos.setLayout(new BorderLayout());
        agregarPaneles(contenedorTabla, BorderLayout.CENTER);
        agregarPaneles(contenedorSuperior, BorderLayout.PAGE_START);
        agregarPaneles(contenedorInferior, BorderLayout.PAGE_END);

        //Dimensiones de los elementos superiores
        contenedorSuperior.setPreferredSize(new Dimension(50,60));
        botonMenuPrincipal.setPreferredSize(new Dimension(170,40));
        etiquetaListado.setPreferredSize(new Dimension(275,50));
        botonDevolver.setPreferredSize(new Dimension(sizeX-40, 40));

        JLabel relleno = new JLabel(" ");
        relleno.setPreferredSize(new Dimension(100,100));
        contenedorSuperior.add(etiquetaListado);
        contenedorSuperior.add(botonMenuPrincipal);


        /*
        * Funcion de los botones dentro
        * de la ventana
        * */

        botonMenuPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnMenuPrincipal();
            }
        });

        botonDevolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnDevolver();
            }
        });

    }

    private void agregarPaneles(JPanel panel, Object alineacionPanelCentral){
        panel.setBorder(null);
        if (panel == contenedorTabla) {
            panel.setLayout(new BorderLayout());
        } else{
            panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
            dimensionesContenedores(panel,10,70);
        }
        panelVerPrestamos.add(panel, alineacionPanelCentral);
    }

    private void dimensionesContenedores(JPanel panel, int width, int height){
        panel.setPreferredSize(new Dimension(width,height));
    }

    //Funcion del boton
    private void btnDevolver(){
        int fila = tablaPrestamos.getSelectedRow();
        if(!(fila == - 1)){
            String tituloLibro = (String)tablaPrestamos.getValueAt(fila, 0);
            String idUsuario = Usuario.getIdActivo();
            String hora = (String)tablaPrestamos.getValueAt(fila,3);

            AlmacenLibros.disponibilidadLibros(tituloLibro,1);

        } else{
            new Alertas("DEBE SELECCIONAR UNA FILA ", "ERROR").setVisible(true);
        }
    }

    private void btnMenuPrincipal(){
        this.dispose();
        new PanelNormal().setVisible(true);
    }

}
