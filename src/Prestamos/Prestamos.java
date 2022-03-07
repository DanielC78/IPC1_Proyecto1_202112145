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

    public static void crearPrestamo(Prestamos nuevoPrestamo, String idUsuario){
        for (int i = 0; i < arregloPrestamos.length; i++) {
            if(arregloPrestamos[i] == null){
                arregloPrestamos[i] = nuevoPrestamo;
                cantidadUsuarioPrestamo(0, idUsuario);
                cantidadPrestamos++;
                break;
            }
        }
    }

    public static void verificarCantidadPrestada(String idUsuario, int operacion){
        for (int i = 0; i < cantidadPrestada.length; i++) {
            if(cantidadPrestada[0] != null){
                if(cantidadPrestada[i][0].equals(idUsuario)){
                    cantidadPrestada[i][1] = "";
                }
            } else{

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
                    cantidadUsuarioPrestamo(1, idUsuario);
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

    //Verificar cuantos libros ha creado un mismo ID
    public static void cantidadUsuarioPrestamo(int operacion, String idUsuario){

        /*for(Prestamos prestamos: arregloPrestamos){
            if(prestamos != null){
                if(prestamos.getIdUsuarioPrestamo().equals(idUsuario)){
                    for (int i = 0; i < cantidadPrestada.length; i++) {
                        if (cantidadPrestada[i][0] != null){
                            if(cantidadPrestada[i][0].equals(idUsuario)){
                                System.out.println("Pasa varias veces por aca");

                                if(operacion == 0){
                                    cantidadPrestada[i][1] = String.valueOf(Integer.parseInt(cantidadPrestada[i][1]) + 1);
                                    System.out.println(cantidadPrestada[i][1]);
                                    break;
                                }

                                else if(operacion == 1){
                                    cantidadPrestada[i][1] = String.valueOf(Integer.parseInt(cantidadPrestada[i][1]) - 1);
                                    System.out.println(cantidadPrestada[i][1]);
                                    break;
                                }
                            }
                        } else{
                            cantidadPrestada[i][0] = prestamos.getIdUsuarioPrestamo();
                            cantidadPrestada[i][1] = "1";
                            break;
                        }
                    }
                }
            }
        }*/

        boolean validacion = false;
        //Recorremos la matriz de los prestamos que se repiten
        for (int i = 0; i < cantidadPrestada.length; i++) {
            /*Por cada iteracion en la cantidad prestada vamos a revisar
                cuantas veces el usuario aparece dentro del arrego de Prestamos*/
            for (Prestamos prestamos :
                    arregloPrestamos) {
                /*Solo comprobamos para aquellos espacios donde
                * el arreglo no esté vacío*/
                if(prestamos != null){
                    /*Miramos si el la casilla de
                    * las cantidades repetidas están vacías*/
                    if(cantidadPrestada[i][0] != null){
                        /*Si no está en null, significa que hay un
                        * usuario ingresado entonces buscamos su ID
                        * y le sumamos o restamos a la cantidad prestada*/

                    } else{
                        /*Si está en estado null
                        * entonces agregamos a ese espacio
                        * un nuevo usario*/
                        cantidadPrestada[i][0] = idUsuario;
                    }

                }
            }
            if(validacion){
                break;
            }
        }

        for (int i = 0; i < cantidadPrestada.length; i++) {
                if(cantidadPrestada[i][0] != null){
                    System.out.println("El id es "+cantidadPrestada[i][0]);
                    System.out.println("La cantidad es "+cantidadPrestada[i][1]);
                    System.out.println("----");
                }
        }
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
