package Reportes;

import Bibliografias.*;

public class ReporteBibliografias {

    private String headerReporteBibliogafia = EstilosReportes.encabezadoReporte("REPORTE DE BIBLIOGRAFÍA");
    private String footerReporteBibliografia = EstilosReportes.footerReporte();

    private String[] datosLibros;
    private String[] encabezadoLibros;

    public ReporteBibliografias(String[] datosLibros, String[] encabezadoLibros) {
        this.datosLibros = datosLibros;
        this.encabezadoLibros = encabezadoLibros;
    }

    public String obtenerReporteLibros(){
        String tablaColumnas = "";
        for (int i = 0; i < encabezadoLibros.length; i++) {
            tablaColumnas+="        <th>"+ encabezadoLibros[i]+"</th>\n";
        }
        tablaColumnas += "        </thead>\n";

        String tablaDatos = "";
        for (String temas: datosLibros) {
            if (temas != null) {
                if(AlmacenLibros.contarRepeticionTemas(temas) > 0){
                    tablaDatos += "        <tr>\n";
                    tablaDatos += "          <td>" + temas + "</td>\n";
                    tablaDatos += "          <td>" + AlmacenLibros.contarRepeticionTemas(temas) + "</td>\n";
                    tablaDatos += "        </tr>\n";
                }
            }
        }
        return headerReporteBibliogafia + tablaColumnas + tablaDatos + footerReporteBibliografia;
    }
}
