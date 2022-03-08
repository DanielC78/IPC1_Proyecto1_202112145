package Reportes;

import Prestamos.Prestamos;

public class ReportesPrestamos {

    private String headerReportePrestamos = "";
    private String footerReportePrestamos = "";


    private Prestamos[] datos;
    private String [] encabezado;

    public ReportesPrestamos(Prestamos[] datos, String[] encabezado) {
        this.datos = datos;
        this.encabezado = encabezado;
    }

    public String obtenerReportePrestamos(){

        headerReportePrestamos = EstilosReportes.encabezadoReporte("PRESTAMOS");
        footerReportePrestamos = EstilosReportes.footerReporte();

        String tablaColumnas = "";
        tablaColumnas += "        <thead>\n";

        for (int i = 0; i < encabezado.length; i++) {
            tablaColumnas+="        <th>"+ encabezado[i]+"</th>\n";
        }

        tablaColumnas += "</thead>\n";

        String tablaDatos = "";

        for (int i = (datos.length-1); i >= 0; i--) {
            if (datos[i] != null) {
                tablaDatos += "        <tr>\n";
                tablaDatos += "          <td>" + datos[i].getIdUsuarioPrestamo() + "</td>\n";
                tablaDatos += "          <td>" + datos[i].getTituloPrestamo() + "</td>\n";
                tablaDatos += "          <td>" + datos[i].getTipoPrestamo() + "</td>\n";
                tablaDatos += "          <td>" + datos[i].getHora() + "</td>\n";
                tablaDatos += "        </tr>\n";
            }
        }

        return headerReportePrestamos + tablaColumnas + tablaDatos + footerReportePrestamos;
    }
}
