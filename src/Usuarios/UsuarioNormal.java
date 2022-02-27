package Usuarios;

public class UsuarioNormal extends Usuario {

    private int indiceVacio = 0;
    private static String ID;
    private static String nombres;
    private static String apellidos;
    private static String user;
    private static String password;
    private static String rol;
    private String matrizUsuarios[][] = new String[5][100];

    public UsuarioNormal(String ID, String nombres, String apellidos, String user, String password, String rol) {
        super(ID, nombres, apellidos, user, password, rol);
        this.ID = ID;
        this.nombres = nombres;
        this.apellidos = apellidos ;
        this.user = user;
        this.password =password ;
        this.rol = rol;

        componentesUsuario();
    }

    private void componentesUsuario(){

        buscarIndiceVacio();
        matrizUsuarios[indiceVacio][0] = ID;
        matrizUsuarios[indiceVacio][1] = nombres;
        matrizUsuarios[indiceVacio][2] = apellidos;
        matrizUsuarios[indiceVacio][3] = user;
        matrizUsuarios[indiceVacio][4] = password;
        matrizUsuarios[indiceVacio][5] = rol;

        System.out.println("USUARIO CREADO");
        for (int i = 0; i < matrizUsuarios.length; i++){
            for (int j = 0; j < matrizUsuarios[i].length; j++){
                if(matrizUsuarios[i][j] != null){
                    System.out.print("|"+ matrizUsuarios[i][j]);
                    if(j == (matrizUsuarios.length)){
                        System.out.println();
                    }
                }
            }
        }
        System.out.println(indiceVacio);
    }

    private void buscarIndiceVacio(){
        for(int i = 0; i < matrizUsuarios.length; i++){
            if(matrizUsuarios[i][0] == null){
                indiceVacio = i;
                break;
            }
        }
    }
}
