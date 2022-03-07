package Prestamos;

import Usuarios.Usuario;

public class Prestamos {

    private static Prestamos[] arregloPrestamos = new Prestamos[100];
    private static int cantidadPrestamos = 0;
    private String idUsuarioPrestamo;
    private String tituloPrestamo;
    private String tipoPrestamo;
    private String hora;

    public Prestamos(String idUsuarioPrestamo,
                     String tituloPrestamo,
                     String tipoPrestamo,
                     String hora) {

        this.idUsuarioPrestamo = idUsuarioPrestamo;
        this.tituloPrestamo = tituloPrestamo;
        this.tipoPrestamo = tipoPrestamo;
        this.hora = hora;
    }

    public static void crearPrestamo(Prestamos nuevoPrestamo){
        for (int i = 0; i < arregloPrestamos.length; i++) {
            if(arregloPrestamos[i] == null){
                arregloPrestamos[i] = nuevoPrestamo;
                cantidadPrestamos++;
                break;
            }
        }
    }

    public static void devolverLibro(String idUsuario,String tituloLibro,String hora){
        for (int i = 0; i < arregloPrestamos.length; i++) {
            if(arregloPrestamos[i] != null){
                if(idUsuario.equals(arregloPrestamos[i].getIdUsuarioPrestamo())
                        && tituloLibro.equals(arregloPrestamos[i].getTituloPrestamo())
                        && hora.equals(arregloPrestamos[i].getHora())
                ){
                    arregloPrestamos[i] = null;
                }
            }
        }

        for (int i = 0; i < (arregloPrestamos.length - 1); i++) {
            if (arregloPrestamos[i] == null && arregloPrestamos[i+1] != null) {
                arregloPrestamos[i] = arregloPrestamos[i+1];
                arregloPrestamos[i+1] = null;
            }
        }
    }

    //Es el encabezado de la tabla para ver los préstamos del usuario
    public static String[] cabecera(){
        return new String[]{
                "TÍTULO",
                "TIPO",
                "FECHA Y HORA"
        };
    }

    public static String[][] mostrarPrestamos(String idUsuario){
        String [][] datos = new String[cantidadPrestamos][3];
        int pos = 0;
        for (Prestamos prestamo :
                arregloPrestamos) {
            if(prestamo != null){
                if(prestamo.getIdUsuarioPrestamo().equals(Usuario.getIdActivo())){
                    String [] fila = {
                            prestamo.getTituloPrestamo(),
                            prestamo.getTipoPrestamo(),
                            prestamo.getHora()
                    };
                    datos[pos] = fila;
                    pos++;
                }
            }
        }
        return datos;
    }


    public String getIdUsuarioPrestamo() {
        return idUsuarioPrestamo;
    }

    public void setIdUsuarioPrestamo(String idUsuarioPrestamo) {
        this.idUsuarioPrestamo = idUsuarioPrestamo;
    }

    public String getTituloPrestamo() {
        return tituloPrestamo;
    }

    public void setTituloPrestamo(String tituloPrestamo) {
        this.tituloPrestamo = tituloPrestamo;
    }

    public String getTipoPrestamo() {
        return tipoPrestamo;
    }

    public void setTipoPrestamo(String tipoPrestamo) {
        this.tipoPrestamo = tipoPrestamo;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
