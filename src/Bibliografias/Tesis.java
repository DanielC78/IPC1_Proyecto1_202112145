package Bibliografias;

public class Tesis extends Bibliografias{
    private String area = "";

    public Tesis(String autor, String titulo, int edicion, String descripcion, String temas, int copias, int disponible, String area) {
        super(autor, titulo, edicion, descripcion, temas, copias, disponible);
        this.area = area;
    }
}
