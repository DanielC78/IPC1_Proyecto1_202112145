package Bibliografias;

public class Revistas extends Bibliografias{

    private String frecuencia_actual = "";
    private int ejemplares = 0;

    public Revistas(String autor, String titulo, int edicion, String descripcion, String temas, int copias, int disponible, String frecuencia_actual, int ejemplares) {
        super(autor, titulo, edicion, descripcion, temas, copias, disponible);
        this.frecuencia_actual = frecuencia_actual;
        this.ejemplares = ejemplares;
    }
}
