package Prestamos;

public class Prestamos {

    private static Prestamos[] arregloPrestamos = new Prestamos[100];
    private static String [][] cantidadPrestada = new String[100][2];
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

    public static void verificarCantidadPrestada(String idUsuario, int operacion){
        for (int i = 0; i < cantidadPrestada.length; i++) {
            if(cantidadPrestada[i][0] != null){
                if(cantidadPrestada[i][0].equals(idUsuario)){
                    if(operacion == 0){
                        cantidadPrestada[i][1] = String.valueOf(Integer.parseInt(cantidadPrestada[i][1]) + 1);
                        break;
                    } else if(operacion == 1){
                        cantidadPrestada[i][1] = String.valueOf(Integer.parseInt(cantidadPrestada[i][1]) - 1);
                        break;
                    } else{
                        cantidadPrestada[i][0] = idUsuario;
                        cantidadPrestada[i][1] = "1";
                        break;
                    }
                }
            } else{
                cantidadPrestada[i][0] = idUsuario;
                cantidadPrestada[i][1] = "1";
                break;
            }
        }

        for (int i = 0; i < cantidadPrestada.length; i++) {
            if(cantidadPrestada[i][0] != null){
                System.out.println("El id es: "+ cantidadPrestada[i][0]);
                System.out.println("La cantidad es: "+  cantidadPrestada[i][1]);
                System.out.println("-----------------------------------");
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
                if(prestamo.getIdUsuarioPrestamo().equals(idUsuario)){
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

    public static Prestamos[] getArregloPrestamos() {
        return arregloPrestamos;
    }

    public static void setArregloPrestamos(Prestamos[] arregloPrestamos) {
        Prestamos.arregloPrestamos = arregloPrestamos;
    }
}
