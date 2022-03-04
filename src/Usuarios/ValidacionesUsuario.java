package Usuarios;

import Ventanas.General.Alertas;

public class ValidacionesUsuario {
    private String mensajeAlerta;

    public boolean validacionCamposVacios(String id, String nombre, String apellido, String usuario, String rol, String password, String confirmPassword){
        boolean validacion = false;
        if(id.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || usuario.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
            mensajeAlerta = "<html><p style=\"text-align:center\">DEBE DE LLENAR <p>TODOS LOS CAMPOS<p></p><html>";
            validacion = true;
        } else if(rol.equals("SELECCIONAR UN ROL")){
            mensajeAlerta = "DEBE DE SELECCIONAR UN ROL";
            validacion = true;
        } else if(!password.equals(confirmPassword)){
            mensajeAlerta = "<html>" +
                    "<p style=\"text-align:center\">LAS CONTRASEÑAS" +
                    "<p style=\"text-align:center\">NO COINCIDEN<p></p>" +
                    "<html>";
            validacion = true;
        } else{
            for (int i = 0; i < Usuario.matrizUsuarios.length; i++) {
                if(Usuario.matrizUsuarios[i][0] != null){
                    if(Usuario.matrizUsuarios[i][0].equals(id)){
                        mensajeAlerta = "<html>" +
                                "<p style=\"text-align:center\">EL ID" +
                                "<p style=\"text-align:center\">YA EXISTE<p></p>" +
                                "<html>";
                        validacion = true;
                        break;
                    } else if(Usuario.matrizUsuarios[i][3].equals(usuario)){
                        mensajeAlerta = "<html>" +
                                "<p style=\"text-align:center\">EL USUARIO" +
                                "<p style=\"text-align:center\">YA EXISTE<p></p>" +
                                "<html>";
                        validacion = true;
                        break;
                    } else{
                        validacion = false;
                    }
                }
            }
        }

        if(validacion){
            Alertas validacionesCrear = new Alertas(mensajeAlerta, "ERROR");
            validacionesCrear.setVisible(true);
            return true;
        }
        return false;
    }

}
