package Reportes;

import Bibliografias.Bibliografias;

public class ReporteBibliografias {

    private String headerReporteBibliogafia = EstilosReportes.encabezadoReporte("REPORTE DE BIBLIOGRAFÍA");
    private String footerReporteBibliografia = EstilosReportes.footerReporte();

    private String[][] datosLibros;
    private String[] encabezadoLibros;

    public ReporteBibliografias(String[][] datosLibros, String[] encabezadoLibros) {
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
        for (int i = 0; i < datosLibros.length; i++) {
            if(datosLibros[i][0] != null){
                tablaDatos += "        <tr>\n";
                tablaDatos += "          <td>" + datosLibros[i][0] + "</td>\n";
                tablaDatos += "          <td>" + datosLibros[i][1] + "</td>\n";
                tablaDatos += "        </tr>\n";
            }
        }
        return headerReporteBibliogafia + tablaColumnas + tablaDatos + footerReporteBibliografia;
    }
}
