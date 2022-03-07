package Reportes;

public class EstilosReportes {

    public static String encabezadoReporte(String titulo){
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "  <head>\n" +
                "    <meta charset=\"UTF-8\" />\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" +
                "    <title>"+titulo+"</title>\n" +
                "  </head>\n" +
                "  <style>\n" +
                "    *{\n" +
                "      box-sizing: border-box;\n" +
                "    }\n" +
                "    body {\n" +
                "      margin: 0;\n" +
                "      padding: 20px;\n" +
                "      font-family: 'Work Sans';\n" +
                "    }\n" +
                "    h1{\n" +
                "      text-align: center;\n" +
                "      font-size: 40px;\n" +
                "    }\n" +
                "    table {\n" +
                "      width: 100%;\n" +
                "      border-collapse: collapse;\n" +
                "    }\n" +
                "\n" +
                "    table td, table th{\n" +
                "      padding: 12px 15px;\n" +
                "      border: 1px solid #ddd;\n" +
                "      text-align: center;\n" +
                "      font-size: 16px;\n" +
                "      font-weight: bold;\n" +
                "    }\n" +
                "\n" +
                "    table th{\n" +
                "      background-color: rgb(40, 113, 173);\n" +
                "      font-size: 18px;\n" +
                "      color: #fff;\n" +
                "    }\n" +
                "\n" +
                "    table tbody tr:nth-child(even){\n" +
                "      background-color: #f5f5f5;\n" +
                "    }\n" +
                "  </style>\n" +
                "  <body>\n" +
                "    <h1>"+titulo+"</h1>\n" +
                "    <table>";
    }


    public static String footerReporte(){
        return "</table>\n" +
                "</body>\n" +
                "</html>";
    }
}
