package Reportes;

import java.util.Objects;

public class ReporteUsuarios {

    private String headerReporteUsuarios = EstilosReportes.encabezadoReporte("REPORTE DE USUARIOS");
    private String footerReporteUsuarios = EstilosReportes.footerReporte();

    private String[][] datosUsuarios;
    private String [] encabezadoUsuarios;
    private String[][] datosPrestamos;

    public ReporteUsuarios(String[][] datosUsuarios, String[] encabezadoUsuarios, String[][]datosPrestamos) {
        this.datosUsuarios = datosUsuarios;
        this.encabezadoUsuarios = encabezadoUsuarios;
        this.datosPrestamos = datosPrestamos;
    }

    public String obtenerReporteUsuarios(){
        String tablaColumnas = "";
        tablaColumnas += "        <thead>\n";

        //Agregamos el encabezado a la tabla
        for (int i = 0; i < encabezadoUsuarios.length; i++) {
            tablaColumnas+="        <th>"+ encabezadoUsuarios[i]+"</th>\n";
        }
        tablaColumnas += "        </thead>\n";

        String tablaDatos = "";
        for (int i = 0; i < datosUsuarios.length; i++) {
            if(datosUsuarios[i][0] != null){
                if(!Objects.equals(datosUsuarios[i][0], "")){
                    tablaDatos += "        <tr>\n";
                    tablaDatos += "          <td>" + datosUsuarios[i][0] + "</td>\n";
                    tablaDatos += "          <td>" + datosUsuarios[i][1] + "</td>\n";
                    tablaDatos += "          <td>" + datosUsuarios[i][2] + "</td>\n";
                    tablaDatos += "          <td>" + datosUsuarios[i][3] + "</td>\n";
                    tablaDatos += "          <td>" + datosUsuarios[i][4] + "</td>\n";
                    tablaDatos += "          <td>" + buscarCantidadPrestada(datosUsuarios[i][0]) + "</td>\n";
                    tablaDatos += "        </tr>\n";
                }
            }
        }

        return headerReporteUsuarios + tablaColumnas + tablaDatos + footerReporteUsuarios;
    }

    private String buscarCantidadPrestada(String idUsuario){
        String cantidadPresta = "";
        for (int i = 0; i < datosPrestamos.length; i++) {
            if(datosPrestamos[i][0] != null){
                if(datosPrestamos[i][0].equals(idUsuario)){
                    cantidadPresta = datosPrestamos[i][1];
                    break;
                }else{
                    cantidadPresta = "0";
                }
            }
        }
        return cantidadPresta;
    }
}
