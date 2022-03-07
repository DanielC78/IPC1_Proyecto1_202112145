package Reportes;

public class EstilosReportes {

    public static String encabezadoReporte(String titulo){
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>"+titulo+"</title>\n" +
                "</head>\n" +
                "<style>\n" +
                "    .cuerpo{\n" +
                "        background-color:aqua;\n" +
                "    }\n" +
                "</style>\n" +
                "<body class=\"cuerpo\">\n" +
                "    <table>";
    }


    public static String footerReporte(){
        return "</table>\n" +
                "</body>\n" +
                "</html>";
    }
}
