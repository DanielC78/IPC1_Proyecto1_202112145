package Reportes;

import Prestamos.Prestamos;

public class ReportesPrestamos {

    private String headerReportePrestamos = "";
    private String footerReportePrestamos = "";


    private Prestamos[] datos;
    private String [] columnas;

    public ReportesPrestamos(Prestamos[] datos, String[] columnas) {
        this.datos = datos;
        this.columnas = columnas;
    }

    public String obtenerReportePrestamos(){

        headerReportePrestamos = EstilosReportes.encabezadoReporte("PRESTAMOS");
        footerReportePrestamos = EstilosReportes.footerReporte();

        String tablaColumas = "";
        tablaColumas += "        <thead>\n";

        for (int i = 0; i < columnas.length; i++) {
            tablaColumas+="        <th>"+columnas[i]+"</th>\n";
        }

        tablaColumas += "</thead>\n";

        String tablaDatos = "";

        for (Prestamos dato : datos) {
            if (dato != null) {
                tablaDatos += "        <tr>\n";
                tablaDatos += "          <td>" + dato.getIdUsuarioPrestamo() + "</td>\n";
                tablaDatos += "          <td>" + dato.getTituloPrestamo() + "</td>\n";
                tablaDatos += "          <td>" + dato.getTipoPrestamo() + "</td>\n";
                tablaDatos += "          <td>" + dato.getHora() + "</td>\n";
                tablaDatos += "        </tr>\n";
            }
        }

        return headerReportePrestamos + tablaColumas + tablaDatos + footerReportePrestamos;
    }
}
