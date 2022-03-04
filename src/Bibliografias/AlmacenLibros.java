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
        for (Bibliografias libro :
                arregloBibliografias) {
            if(libro != null){
                if(libro.getTitulo().equals(titulo)){
                    System.out.println("eliminao "+ titulo);
                }
            }
        }

    }


    public static String[][] buscarTemaLibro(String buscar){
        String datos[][] = new String[cantidadBibliografias][11];
        int pos = 0;
        boolean verificarTitulo = false;
        boolean verificarTema = false;
        for(Bibliografias bibliografias: arregloBibliografias){
            if(bibliografias != null){
                if(bibliografias.getTemas()[0].contains(buscar)){

                }
                if(bibliografias.getTitulo().contains(buscar)){
                    verificarTitulo = true;
                }
                for (String temas :
                        bibliografias.getTemas()) {
                    if (temas.trim().contains(buscar)) {
                        verificarTema = true;
                        break;
                    } else{
                        verificarTema = false;
                    }
                }

                if(verificarTitulo || verificarTema){
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
