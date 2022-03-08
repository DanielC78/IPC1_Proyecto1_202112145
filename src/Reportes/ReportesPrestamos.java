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

        return headerReportePrestamos + tablaColumnas + tablaDatos + footerReportePrestamos;
    }
}
