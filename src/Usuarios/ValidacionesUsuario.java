package Usuarios;

import Ventanas.Alertas;

public class ValidacionesUsuario {
    private String mensajeAlerta;

    public boolean validacionCamposVacios(String id, String nombre, String apellido, String usuario, String rol, String password, String confirmPassword){
        boolean validacion;
        if(id.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || usuario.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
            mensajeAlerta = "<html><p style=\"text-align:center\">DEBE DE LLENAR <p>TODOS LOS CAMPOS<p></p><html>";
            validacion = true;
        } else if(rol.equals("SELECCIONAR UN ROL")){
            mensajeAlerta = "DEBE DE SELECCIONAR UN ROL";
            validacion = true;
        } else if(!password.equals(confirmPassword)){
            mensajeAlerta = "<html><p style=\"text-align:center\">LAS CONTRASEÑAS<p style=\"text-align:center\">NO COINCIDEN<p></p><html>";
            System.out.println(password);
            System.out.println(confirmPassword);
            validacion = true;
        } else{
            validacion = false;
        }

        if(validacion){
            Alertas validacionesCrear = new Alertas(mensajeAlerta, "ERROR");
            validacionesCrear.setVisible(true);
            return true;
        }
        return false;
    }

}
