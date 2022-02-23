package Usuarios;

public class UsuarioNormal extends Usuario {

    private static String ID;
    private static String nombres;
    private static String apellidos;
    private static String user;
    private static String password;
    private static String rol;
    private String usuarios[][];

    public UsuarioNormal(String ID, String nombres, String apellidos, String user, String password, String rol, String[][] matrizUsuarios, String[][] usuarios) {
        super(ID, nombres, apellidos, user, password, rol, matrizUsuarios);
        this.usuarios = usuarios;
    }
}
