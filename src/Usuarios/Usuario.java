package Usuarios;

public class Usuario {


    private String ID;
    private String nombres;
    private String apellidos;
    private String user;
    private String rol;
    private String password;
    private String usuarios[][];

    public Usuario(String ID, String nombres, String apellidos, String user, String password, String rol, String[][] matrizUsuarios) {
        this.ID = ID;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.user = user;
        this.password = password;
        this.rol = rol;
        this.matrizUsuarios = matrizUsuarios;
    }

    private String matrizUsuarios[][] = new String[5][50];




}
