package Reportes;

import Usuarios.Usuario;

public class ReportesPrestamos {

    private final String headerReportePrestamos = "";
    private final String footerReportePrestamos = "";


    private Usuario[][] datos;
    private String [] columnas;

    public ReportesPrestamos(Usuario[][] datos, String[] columnas) {
        this.datos = datos;
        this.columnas = columnas;
    }

    public String obtenerReportePrestamos(){

        String tablaColumnas = "";

        tablaColumnas += " <tr>\n";

        for (int i = 0; i < columnas.length; i++) {
            tablaColumnas += "          <th>"+columnas[i]+"<th>\n";
        }
        tablaColumnas += " </tr>\n";

        String tablaDatos = "";
        for (int i = 0; i < datos.length; i++) {
            if(datos[i] != null){
                tablaDatos += "";
            }
        }

        return tablaDatos;
    }
}
