package Ventanas.Bibliografias;

import Bibliografias.AlmacenLibros;
import Bibliografias.Bibliografias;
import GUI.*;
import Ventanas.General.Alertas;
import Ventanas.General.PanelAdministrador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EliminarLibros extends Formularios {

    //Dimensiones de la ventana
    private static int sizeX = 1300;
    private static int sizeY = 600;
    private static String titulo = "ELIMINAR BIBLIOGRAFÍA";

    //Paneles
    private JPanel panelEliminarLibros = new Paneles();
    private JPanel contenedorTabla = new Paneles();
    private JPanel contenedorSuperior = new Paneles();
    private JPanel contenedorInferior = new Paneles();

    //Componentes de la parte superior
    JLabel etiquetaBuscar = new Etiquetas("BUSCAR",null, grafica.Negro,grafica.letra_titulos);
    JTextField cajaBuscar = new CajasTexto();

    //Componentes de la parte inferior
    JButton botonEliminar = new Botones("ELIMINAR", grafica.letra_titulos);
    JButton botonRegresar = new Botones("MENÚ PRINCIPAL", grafica.letra_titulos);

    //Componenentes de la tabla
    private DefaultTableModel modeloTabla;
    private JTable tablaLibros;
    private JScrollPane scrollTablaLibros = new JScrollPane();


    public EliminarLibros() throws HeadlessException {
        super(sizeX, sizeY, titulo);
        componentesEliminarLibros();
    }

    private void componentesEliminarLibros(){
        AlmacenLibros.crearBibliografia(new Bibliografias("0","daniel"," porque","","1"," inge, sistemas","anual","3","no","1","1"));
        AlmacenLibros.crearBibliografia(new Bibliografias("1","daniel"," nos dejaron","","1"," medicina, vacuna","anual","3","no","1","1"));
        AlmacenLibros.crearBibliografia(new Bibliografias("2","daniel"," este","","1"," derecho","anual","3","no","1","1"));
        AlmacenLibros.crearBibliografia(new Bibliografias("0","daniel"," proyecto","","1"," sistemas","anual","3","no","1","1"));
        AlmacenLibros.crearBibliografia(new Bibliografias("1","daniel"," en","","1"," javascript","anual","3","no","1","1"));
        AlmacenLibros.crearBibliografia(new Bibliografias("2","daniel"," java","","1"," python","anual","3","no","1","1"));

        this.getContentPane().add(panelEliminarLibros);
        panelEliminarLibros.setLayout(new BorderLayout());
        agregarPaneles(contenedorTabla, BorderLayout.CENTER);
        agregarPaneles(contenedorSuperior, BorderLayout.PAGE_START);
        agregarPaneles(contenedorInferior, BorderLayout.PAGE_END);

        //Dimensiones de los elementos superiores
        cajaBuscar.setPreferredSize(new Dimension(950,40));
        etiquetaBuscar.setPreferredSize(new Dimension(75,50));

        //Dimensiones d elos elementos inferiores
        botonEliminar.setPreferredSize(new Dimension((sizeX - 40),40));
        botonRegresar.setPreferredSize(new Dimension(170,40));

        contenedorSuperior.add(etiquetaBuscar);
        contenedorSuperior.add(cajaBuscar);
        contenedorSuperior.add(botonRegresar);

        contenedorInferior.add(botonEliminar);

        cajaBuscar.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                cajaMostrarDatos(e);
            }
        });

        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnEliminar(e);
            }
        });

        mostrarLibros();
    }

    private void agregarPaneles(JPanel panel, Object alineacionPanelCentral){
        panel.setBorder(null);
        if (panel == contenedorTabla) {
            panel.setLayout(new BorderLayout());
        } else{
            panel.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
            dimensionesContenedores(panel,10,70);
        }
        panelEliminarLibros.add(panel, alineacionPanelCentral);
    }

    private void mostrarLibros(){
        String [][] datos = AlmacenLibros.obtenerLibros();
        cargarTabla(datos);
    }

    private void dimensionesContenedores(JPanel panel, int width, int height){
        panel.setPreferredSize(new Dimension(width,height));
    }

    private void buscarLibros(){
        String tema = cajaBuscar.getText();
        String [][] datos = AlmacenLibros.buscarTemaLibro(tema);
        cargarTabla(datos);

    }

    private void cargarTabla(String[][] datos) {
        modeloTabla = new DefaultTableModel(datos, AlmacenLibros.cabeceraLibros());
        tablaLibros = new JTable(modeloTabla);
        tablaLibros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaLibros.setAutoscrolls(true);
        scrollTablaLibros.setViewportView(tablaLibros);
        scrollTablaLibros.setBorder(grafica.margenPanelesAdmin);
        contenedorTabla.add(scrollTablaLibros, BorderLayout.CENTER);
    }

    private void cajaMostrarDatos(KeyEvent e){
        String tema = cajaBuscar.getText();
        if(tema.equals("")){
            mostrarLibros();
        } else{
            buscarLibros();
        }

    }

    private void btnEliminar(ActionEvent e){
        String titulo;
        int fila = tablaLibros.getSelectedRow();
        if(!(fila == -1)){
            titulo = (String)tablaLibros.getValueAt(fila,2);
            modeloTabla.removeRow(fila);
            AlmacenLibros.eliminarLibro(titulo);
        } else{
            new Alertas("DEBE SELECCIONAR UNA FILA","ERROR").setVisible(true);
        }
    }

    private void btnRegresar(ActionEvent e){
        this.dispose();
        new PanelAdministrador().setVisible(true);
    }
}
