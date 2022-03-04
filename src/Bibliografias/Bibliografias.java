package Bibliografias;

public class Bibliografias {

    //Atributos fijos
    private String tipo;
    private String autor ;
    private String titulo;
    private int edicion;
    private String descripcion;
    private String[] temas;
    private int copias;
    private int disponibles;

    //Atributos de revistas
    private String frecuenciaActual;
    private int ejemplares;

    //Atributos de tesis
    private String area;

    //Temas separados por comas
    private String strTipo;
    private String strTemas;
    private String strEdicion;
    private String strCopias;
    private String strDisponibles;
    private String strEjemplares;
    private String temasConcatenados;


    public Bibliografias(
            String tipo,
            String autor,
            String titulo,
            String descripcion,
            String edicion,
            String temas,
            String frecuenciaActual,
            String ejemplares,
            String area,
            String copias,
            String disponibles

    ) {
        this.tipo = tipo;
        this.autor = autor;
        this.titulo = titulo;
        this.edicion = Integer.parseInt(edicion);
        this.descripcion = descripcion;
        this.temas = temas.trim().split(",");
        this.frecuenciaActual = frecuenciaActual;
        this.ejemplares = Integer.parseInt(ejemplares);
        this.area = area;
        this.copias = Integer.parseInt(copias);
        this.disponibles = Integer.parseInt(disponibles);

        this.strTipo = tipo;
        this.strEdicion = edicion;
        this.strCopias = copias;
        this.strDisponibles = disponibles;
        this.temasConcatenados = temas;
        this.strEjemplares = ejemplares;

    }

    public void MostrarTemas(){
        for(String tema: getTemas()){

        }
    }

    //Getters y setters
    public String getStrTipo() {
        return strTipo;
    }

    public void setStrTipo(String strTipo) {
        this.strTipo = strTipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getEdicion() {
        return edicion;
    }

    public void setEdicion(int edicion) {
        this.edicion = edicion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String[] getTemas() {
        return temas;
    }

    public void setTemas(String[] temas) {
        this.temas = temas;
    }

    public int getCopias() {
        return copias;
    }

    public void setCopias(int copias) {
        this.copias = copias;
    }

    public int getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(int disponibles) {
        this.disponibles = disponibles;
    }

    public String getFrecuenciaActual() {
        return frecuenciaActual;
    }

    public void setFrecuenciaActual(String frecuenciaActual) {
        this.frecuenciaActual = frecuenciaActual;
    }

    public int getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(int ejemplares) {
        this.ejemplares = ejemplares;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStrTemas() {
        return strTemas;
    }

    public void setStrTemas(String strTemas) {
        this.strTemas = strTemas;
    }

    public String getStrEdicion() {
        return strEdicion;
    }

    public void setStrEdicion(String strEdicion) {
        this.strEdicion = strEdicion;
    }

    public String getStrCopias() {
        return strCopias;
    }

    public void setStrCopias(String strCopias) {
        this.strCopias = strCopias;
    }

    public String getStrDisponibles() {
        return strDisponibles;
    }

    public void setStrDisponibles(String strDisponibles) {
        this.strDisponibles = strDisponibles;
    }

    public String getTemasConcatenados() {
        return temasConcatenados;
    }

    public void setTemasConcatenados(String temasConcatenados) {
        this.temasConcatenados = temasConcatenados;
    }

    public String getStrEjemplares() {
        return strEjemplares;
    }

    public void setStrEjemplares(String strEjemplares) {
        this.strEjemplares = strEjemplares;
    }
}
