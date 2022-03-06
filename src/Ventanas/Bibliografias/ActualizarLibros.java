package Ventanas.Bibliografias;

import Bibliografias.AlmacenLibros;
import GUI.*;
import Ventanas.General.Alertas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActualizarLibros extends Formularios {

    /*
    * Desde esta ventana se podrá editar la información que reciba desde el método
    * constructor desde el panel para buscar y seleccionar la bibliografía que se
    * desea editar
    */

    //Propiedades de la ventana
    private static final int sizeX = 700 ;
    private static final int sizeY = 650;
    private static final String titulo = "ACTUALIZAR BIBLIOGRAFÍA";

    //Paneles
    private final JPanel panelActualizarBibliografia = new Paneles();

    private final JPanel panelIzquierdo = new Paneles();
    private final JPanel panelDerecho = new Paneles();
    private final JPanel panelBotones = new Paneles();

    //Paneles del lado izquierdo
    private final JPanel panelElementosDerechos = new Paneles();

    //Botones
    private final JButton botonActualizar = new Botones("ACTUALIZAR",grafica.letraTitulos);
    private final JButton botonCancelar = new Botones("CANCELAR",grafica.letraTitulos);

    //Opciones de revista
    String [] tipoRevista = {"LIBRO","REVISTA","TESIS"};

    //Cajas de texto
    private final JTextField cajaAutor = new CajasTexto();
    private final JTextField cajaTitulo = new CajasTexto();
    private final JTextField cajaEdicion = new CajasTexto();
    private final JTextField cajaDescripcion = new CajasTexto();
    private final JTextField cajaTemas = new CajasTexto();
    private final JTextField cajaFrecuencia = new CajasTexto();
    private final JTextField cajaEjemplares = new CajasTexto();
    private final JTextField cajaArea = new CajasTexto();
    private final JTextField cajaCopias = new CajasTexto();
    private final JTextField cajaDisponibles = new CajasTexto();

    //Lista
    private JComboBox<String> listaTipos = new JComboBox<>(tipoRevista);

    public ActualizarLibros(String tipo,
                            String autor,
                            String tituloLibro,
                            String descripcion,
                            String edicion,
                            String temas,
                            String frecuencia,
                            String ejemplares,
                            String area,
                            String copias,
                            String disponibles) throws HeadlessException {
        super(sizeX, sizeY, titulo);
        listaTipos.setSelectedItem(tipo);
        cajaAutor.setText(autor);
        cajaTitulo.setText(tituloLibro);
        cajaTitulo.setEnabled(false);
        cajaDescripcion.setText(descripcion);
        cajaEdicion.setText(edicion);
        cajaTemas.setText(temas);
        cajaFrecuencia.setText(frecuencia);
        cajaEjemplares.setText(ejemplares);
        cajaArea.setText(area);
        System.out.println(area);
        cajaCopias.setText(copias);
        cajaDisponibles.setText(disponibles);

        if(tipo.equals("LIBRO")) {
            metodoDesactivar(cajaFrecuencia,"---");
            metodoDesactivar(cajaArea, "---");
            metodoDesactivar(cajaEjemplares,"0");

        } else if(tipo.equals("REVISTA")){
            metodoDesactivar(cajaArea,"---");

        } else if(tipo.equals("TESIS")){
            metodoDesactivar(cajaFrecuencia,"---");
            metodoDesactivar(cajaEjemplares, "0");
        }
        componentesActualizarLibro();
    }

    private void componentesActualizarLibro(){
        this.getContentPane().add(panelActualizarBibliografia);

        panelActualizarBibliografia.setLayout(new BorderLayout());
        panelActualizarBibliografia.add(panelRelleno(),BorderLayout.PAGE_START);
        rellenoPaneles(panelIzquierdo, BorderLayout.WEST);
        rellenoPaneles(panelElementosDerechos, BorderLayout.EAST);
        rellenoPaneles(panelBotones, BorderLayout.PAGE_END);

        panelIzquierdo.setPreferredSize(new Dimension((sizeX/2),40));
        panelDerecho.setPreferredSize(new Dimension((sizeX/2), 40));
        panelBotones.setPreferredSize(new Dimension(10,100));


        //Agregamos los elementos izquierdos
        panelIzquierdo.setLayout(new GridLayout(6,2,5,65));
        panelIzquierdo.add(crearEtiquetas("TIPO"));
        panelIzquierdo.add(listaTipos);
        panelIzquierdo.add(crearEtiquetas("AUTOR"));
        panelIzquierdo.add(cajaAutor);
        panelIzquierdo.add(crearEtiquetas("TITULO"));
        panelIzquierdo.add(cajaTitulo);
        panelIzquierdo.add(crearEtiquetas("EDICIÓN"));
        panelIzquierdo.add(cajaEdicion);
        panelIzquierdo.add(crearEtiquetas("DESCRIPCIÓN"));
        panelIzquierdo.add(cajaDescripcion);
        panelIzquierdo.add(crearEtiquetas("TEMAS"));
        panelIzquierdo.add(cajaTemas);

        //Agregamos los elementos derechos
        panelElementosDerechos.setLayout(new BorderLayout());
        panelElementosDerechos.setBorder(null);
        panelElementosDerechos.add(panelRelleno(), BorderLayout.PAGE_START);
        panelElementosDerechos.add(panelRelleno(), BorderLayout.PAGE_END);
        panelElementosDerechos.add(panelRelleno(), BorderLayout.LINE_END);
        panelElementosDerechos.add(panelDerecho, BorderLayout.CENTER);

        panelDerecho.setLayout(new GridLayout(5,2,5,80));
        panelDerecho.setBorder(null);
        panelDerecho.add(crearEtiquetas("ÁREA"));
        panelDerecho.add(cajaArea);
        panelDerecho.add(crearEtiquetas("FRECUENCIA"));
        panelDerecho.add(cajaFrecuencia);
        panelDerecho.add(crearEtiquetas("EJEMPLARES"));
        panelDerecho.add(cajaEjemplares);
        panelDerecho.add(crearEtiquetas("COPIAS"));
        panelDerecho.add(cajaCopias);
        panelDerecho.add(crearEtiquetas("DISPONIBLES"));
        panelDerecho.add(cajaDisponibles);

        //Agregamos los botones
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER,75,25));
        agregarBotones(botonActualizar);
        agregarBotones(botonCancelar);

        //Funcion de los botones
        botonCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCancelar(e);
            }
        });

        listaTipos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambioTipo(e);
            }
        });

        botonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnActualizar(e);
            }
        });
    }

    private void rellenoPaneles(JPanel panel, Object alineacion){
        panel.setLayout(new BorderLayout());
        panel.setBorder(null);
        panelActualizarBibliografia.add(panel, alineacion);

    }

    private void agregarBotones(JButton boton){
        boton.setPreferredSize(new Dimension(150,40));
        panelBotones.add(boton);
    }

    private JLabel crearEtiquetas(String mensaje){
        JLabel etiqueta  = new Etiquetas(mensaje,null, null, grafica.letraFuerte);
        return  etiqueta;
    }

    private JPanel panelRelleno(){
        JPanel panelRelleno = new Paneles();
        panelRelleno.setBorder(null);
        panelRelleno.setPreferredSize(new Dimension(20,20));
        return  panelRelleno;
    }

    private void btnActualizar(ActionEvent e){
        String tipo = (String) listaTipos.getSelectedItem();
        String autor= cajaAutor.getText();
        String titulo= cajaTitulo.getText();
        String edicion = cajaEdicion.getText();
        String descripcion = cajaDescripcion.getText();
        String temas = cajaTemas.getText();
        String frecuencia = cajaFrecuencia.getText();
        String ejemplares = cajaEjemplares.getText();
        String area = cajaArea.getText();
        String copias = cajaCopias.getText();
        String disponibles = cajaDisponibles.getText();

        String mensaje = AlmacenLibros.validarCampos(
                autor,
                titulo,
                edicion,
                descripcion,
                temas,
                frecuencia,
                ejemplares,
                area,
                copias,
                disponibles
        );

        if( mensaje == ""){
            AlmacenLibros.actualizarLibro(
                    tipo,
                    autor,
                    titulo,
                    descripcion,
                    edicion,
                    temas,
                    frecuencia,
                    ejemplares,
                    area,
                    copias,
                    disponibles
            );

            AlmacenLibros.vaciarCajas(listaTipos, cajaAutor, cajaTitulo, cajaEdicion, cajaDescripcion, cajaTemas, cajaCopias, cajaDisponibles);
            new Alertas("ACTUALIZACIÓN EXITOSA","").setVisible(true);
        } else {
            new Alertas(mensaje,"ERROR").setVisible(true);
        }
    }

    private void btnCancelar(ActionEvent e){
        this.dispose();
        new PanelActualizarLibros().setVisible(true);
    }

    private void cambioTipo(Object e){
        if(listaTipos.getSelectedIndex() == 0) {
            metodoDesactivar(cajaFrecuencia,"---");
            metodoDesactivar(cajaArea, "---");
            metodoDesactivar(cajaEjemplares,"0");

        } else if(listaTipos.getSelectedIndex() == 1){
            metodoDesactivar(cajaArea,"---");
            metodoActivar(cajaFrecuencia);
            metodoActivar(cajaEjemplares);

        } else if(listaTipos.getSelectedIndex() == 2){
            metodoDesactivar(cajaFrecuencia,"---");
            metodoDesactivar(cajaEjemplares, "0");
            metodoActivar(cajaArea);
        }
    }

    private void metodoDesactivar(JTextField caja, String mostrar){
        caja.setText(mostrar);
        caja.setEnabled(false);
    }

    private void metodoActivar(JTextField caja){
        caja.setEnabled(true);
        caja.setText("");
    }

}
