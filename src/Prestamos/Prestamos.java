package Prestamos;

import Bibliografias.*;
import Usuarios.Usuario;

import java.time.LocalDateTime;

public class Prestamos {

    private static Prestamos[] arregloPrestamos = new Prestamos[100];
    private static int cantidadPrestamos = 0;
    private String idUsuarioPrestamo;
    private String tituloPrestamo;
    private String tipoPrestamo;

    public Prestamos(String idUsuarioPrestamo, String tituloPrestamo, String tipoPrestamo) {
        this.idUsuarioPrestamo = idUsuarioPrestamo;
        this.tituloPrestamo = tituloPrestamo;
        this.tipoPrestamo = tipoPrestamo;
    }

    public static void crearPrestamo(Prestamos nuevoPrestamo){
        for (int i = 0; i < arregloPrestamos.length; i++) {
            if(arregloPrestamos[i] == null){
                arregloPrestamos[i] = nuevoPrestamo;
                cantidadPrestamos++;
            }
        }
        System.out.println("Tipo "+arregloPrestamos[0].getTipoPrestamo());
        System.out.println("Titulo: "+arregloPrestamos[0].getTituloPrestamo());
        System.out.println("ID"+arregloPrestamos[0].getIdUsuarioPrestamo());

    }

    public static void devolverPrestamo(String idUsuario, String titulo){

    }

    public void mostrarPrestamos(){
        String titulo ="";
        String tipo ="";
        String fecha = LocalDateTime.now().toString();
        System.out.println("El titulo es: "+ titulo);
        System.out.println("El tipo es: " + tipo);
        System.out.println("La fecha es: "+ fecha);
    }

    public void buscarPrestamos(String idUsuario){

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
}
