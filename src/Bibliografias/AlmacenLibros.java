package Bibliografias;

public class AlmacenLibros {
    private static Bibliografias[] arregloBibliografias = new Bibliografias[100];
    private static int  cantidadBibliografias = 0;

    public AlmacenLibros(){
    }

    public static void crearBibliografia(Bibliografias nuevoLibro){
        for (int i = 0; i < arregloBibliografias.length; i++) {
            if(arregloBibliografias[i] == null){
                arregloBibliografias[i] = nuevoLibro;
                cantidadBibliografias++;
                return;
            }
        }
    }

    public static void actualizarLibro(String titulo){

    }

    public static void eliminarLibro(String titulo){

    }


    public static String[][] buscarTemaLibro(String buscar){
        String datos[][] = new String[cantidadBibliografias][11];
        int pos = 0;
        for(Bibliografias bibliografias: arregloBibliografias){
            if(bibliografias != null){
                if(bibliografias.getTemasConcatenados().contains(buscar) || bibliografias.getTitulo().contains(buscar)){
                    System.out.println(bibliografias.getTemasConcatenados().contains(buscar));
                    String [] fila = {
                            bibliografias.getStrTipo(),
                            bibliografias.getAutor(),
                            bibliografias.getTitulo(),
                            bibliografias.getDescripcion(),
                            bibliografias.getStrEdicion(),
                            bibliografias.getTemasConcatenados(),
                            bibliografias.getFrecuenciaActual(),
                            bibliografias.getStrEjemplares(),
                            bibliografias.getStrCopias(),
                            bibliografias.getStrDisponibles(),
                            bibliografias.getStrDisponibles(),
                    };
                    datos[pos] = fila;
                    pos++;
                }
            }
        }

        return datos;
    }

    public static String[] cabeceraLibros(){
        String [] cabecera =  {
                "TIPO", "AUTOR", "TITULO",  "EDICION", "DESCRIPCION","TEMAS","FRECUENCIA ACTUAL","EJEMPLARES","COPIAS"
        };
        return cabecera;
    }

    public static String[][] obtenerLibros(){
        String datos[][] = new String[cantidadBibliografias][11];
        int pos = 0;
        for(Bibliografias bibliografias: arregloBibliografias){
            if(bibliografias != null){
                String [] fila = {
                        bibliografias.getStrTipo(),
                        bibliografias.getAutor(),
                        bibliografias.getTitulo(),
                        bibliografias.getStrEdicion(),
                        bibliografias.getTemasConcatenados(),
                        bibliografias.getFrecuenciaActual(),
                        bibliografias.getStrEjemplares(),
                        bibliografias.getStrCopias(),
                        bibliografias.getStrDisponibles(),
                        bibliografias.getStrDisponibles(),

                };
                datos[pos] = fila;
                pos ++;
            }
        }
        return datos;
    }




}
