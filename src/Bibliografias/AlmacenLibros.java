package Bibliografias;

public class AlmacenLibros {
    private static Bibliografias[] matrizBibliografias = new Bibliografias[100];
    private static int  cantidadBibliografias = 0;


    public static void CrearBibliografia(Bibliografias nuevoLibro){
        for (int i = 0; i < matrizBibliografias.length; i++) {
            if(matrizBibliografias[i] == null){
                matrizBibliografias[i] = nuevoLibro;
                cantidadBibliografias++;
                return;
            }
        }
    }

    public static String[][] obtenerLibros(){
        String datos[][] = new String[cantidadBibliografias][10];

        int pos = 0;
        for(Bibliografias bibliografias: matrizBibliografias){
            if(bibliografias != null){
                String [] fila = {
                        bibliografias.getAutor(),
                        bibliografias.getTitulo(),
                        bibliografias.getStrEdicion(),
                        bibliografias.getDescripcion(),
                        bibliografias.getDescripcion(),
                        bibliografias.getTemasConcatenados(),
                        bibliografias.getStrCopias(),
                        bibliografias.getStrDisponibles(),
                };
                datos[pos] = fila;
                pos ++;
            }
        }

        return datos;
    }


}
