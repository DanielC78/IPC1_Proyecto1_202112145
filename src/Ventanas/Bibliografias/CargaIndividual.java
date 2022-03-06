package Ventanas.Bibliografias;

import Bibliografias.AlmacenLibros;
import Bibliografias.Bibliografias;
import GUI.*;
import Ventanas.General.Alertas;
import Ventanas.General.PanelAdministrador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CargaIndividual extends Formularios {

    //Tamaño de la ventanas
    private static final int sizeX = 700 ;
    private static final int sizeY = 650;

    //Paneles
    private final JPanel panelCargaIndividual = new Paneles();

    private final JPanel panelIzquierdo = new Paneles();
    private final JPanel panelDerecho = new Paneles();
    private final JPanel panelBotones = new Paneles();

    //Paneles del lado izquierdo
    private final JPanel panelElementosDerechos = new Paneles();

    //Botones
    private final JButton botonCrear = new Botones("CREAR",grafica.letraTitulos);
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
    private final JComboBox<String> listaTipos = new JComboBox<>(tipoRevista);

    public CargaIndividual(){
        super(sizeX,sizeY,"CARGA INDIVIDUAL");
        componentesCargaIndividual();

    }

    private void componentesCargaIndividual(){
        this.getContentPane().add(panelCargaIndividual);
        panelCargaIndividual.setLayout(new BorderLayout());
        panelCargaIndividual.add(panelRelleno(),BorderLayout.PAGE_START);
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
        agregarBotones(botonCrear);
        agregarBotones(botonCancelar);

        //Se inicializa ya que el inidce 0 es Libro
        //A menos de que el usario lo cambie
        metodoDesactivar(cajaFrecuencia,"---");
        metodoDesactivar(cajaArea, "---");
        metodoDesactivar(cajaEjemplares,"0");

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

        botonCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCrear(e);
            }
        });
    }

    private void rellenoPaneles(JPanel panel, Object alineacion){
        panel.setLayout(new BorderLayout());
        panel.setBorder(null);
        panelCargaIndividual.add(panel, alineacion);

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

    private void btnCrear(ActionEvent e){
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
            AlmacenLibros.crearBibliografia(new Bibliografias(
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
                    disponibles)
            );

            AlmacenLibros.vaciarCajas(listaTipos, cajaAutor, cajaTitulo, cajaEdicion, cajaDescripcion, cajaTemas, cajaCopias, cajaDisponibles);
            new Alertas("CREACION EXITOSA","").setVisible(true);
        } else {
            new Alertas(mensaje,"ERROR").setVisible(true);
        }
    }

    private void btnCancelar(ActionEvent e){
        this.dispose();
        new PanelAdministrador().setVisible(true);
    }

    private void cambioTipo(ActionEvent e){
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
