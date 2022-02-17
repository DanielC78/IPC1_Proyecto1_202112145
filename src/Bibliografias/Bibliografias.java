package Bibliografias;

public class Bibliografias {
    private String autor = "";
    private String titulo = "";
    private int edicion = 0;
    private String descripcion = "";
    private String temas = "";
    private int copias = 0;
    private int disponible = 0;

    public Bibliografias(String autor, String titulo, int edicion, String descripcion, String temas, int copias, int disponible) {
        this.autor = autor;
        this.titulo = titulo;
        this.edicion = edicion;
        this.descripcion = descripcion;
        this.temas = temas;
        this.copias = copias;
        this.disponible = disponible;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getEdicion() {
        return edicion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTemas() {
        return temas;
    }

    public int getCopias() {
        return copias;
    }

    public int getDisponible() {
        return disponible;
    }
}
