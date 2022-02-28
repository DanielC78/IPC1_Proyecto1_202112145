package Usuarios;

public class Usuario {

    //Credenciales de administrador
    private String idAdmin = "admin";
    private String nombreAdmin = "Administrador";
    private String apellidoAdmin = "";
    private String usuarioAdmin = "admin";
    private String rolAdmin = "ADMINISTRADOR";
    private String passwordAdmin = "password";

    private String ID;
    private String nombres;
    private String apellidos;
    private String user;
    private String rol;
    private String password;
    private String matrizUsuarios[][] = new String[5][100];

    public Usuario(String ID, String nombres, String apellidos, String user, String password, String rol) {
        this.ID = ID;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.user = user;
        this.password = password;
        this.rol = rol;

        matrizUsuarios[0][0] = idAdmin ;
        matrizUsuarios[0][1] = nombreAdmin;
        matrizUsuarios[0][2] = apellidoAdmin;
        matrizUsuarios[0][3] = usuarioAdmin;
        matrizUsuarios[0][4] = rolAdmin ;
        matrizUsuarios[0][5] = passwordAdmin;
    }

    //Retorna verdadero si el usuario se creo corrrectamente
    //Retorna falso si el usuario no se ingreso a la matriz

    public boolean crearUsuario(){
        if(!usuarioExistente(this.ID)){
            boolean val = false;
            for(int i = 1; i< matrizUsuarios.length; i++){
                for(int j = 1; j<matrizUsuarios[i].length; j++){
                    matrizUsuarios[i][0] = this.ID;
                    matrizUsuarios[i][1] = this.nombres;
                    matrizUsuarios[i][2] = this.apellidos;
                    matrizUsuarios[i][3] = this.user;
                    matrizUsuarios[i][4] = this.rol;
                    matrizUsuarios[i][5] = this.password;
                    val = true;
                    break;
                }
                if(val){
                    break;
                }
            }
            for(int i = 0; i < matrizUsuarios.length; i++){
                for(int j = 0; j < matrizUsuarios[i].length; j++){
                    if(matrizUsuarios[i][j] != null){
                        System.out.print("|"+matrizUsuarios[i][j]);
                        if(j == matrizUsuarios.length){
                            System.out.println();
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    //Verifica si el id del usiario es identico a otro
    private boolean usuarioExistente(String id){
        for(int i = 0; i < matrizUsuarios.length; i++){
            if(matrizUsuarios[i][0] == id){
                return true;
            }
        }
        return false;
    }
}
