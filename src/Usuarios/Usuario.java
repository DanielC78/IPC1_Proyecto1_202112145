package Usuarios;

public class Usuario {

    //Credenciales de administrador
    private static String idAdmin = "admin";
    private static String nombreAdmin = "Administrador";
    private static String apellidoAdmin = "";
    private static String usuarioAdmin = "admin";
    private static String rolAdmin = "ADMINISTRADOR";
    private static String passwordAdmin = "password";

    private static String ID;
    private static String nombres;
    private static String apellidos;
    private static String user;
    private static String rol;
    private static String password;
    private static String matrizUsuarios[][] = new String[100][6];


    public Usuario() {
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
        usuarioExistente(getID());
        if(usuarioExistente(getID())) {
            return false;
        } else{
            for (int i = 0; i < matrizUsuarios.length; i++){
                if(matrizUsuarios[i][0] == null){
                    matrizUsuarios[i][0] = getID();
                    matrizUsuarios[i][1] = getNombres();
                    matrizUsuarios[i][2] = getApellidos();
                    matrizUsuarios[i][3] = getUser();
                    matrizUsuarios[i][4] = getRol();
                    matrizUsuarios[i][5] = getPassword();
                    break;
                }
            }

            for(int i = 0; i < matrizUsuarios.length; i++){
                for(int j = 0; j < matrizUsuarios[i].length; j++){
                    if(matrizUsuarios[i][j] != null){
                        System.out.print("|"+matrizUsuarios[i][j]);
                        if(j == (matrizUsuarios[i].length-1)){
                            System.out.println();
                        }
                    }
                }
            }
            for(int i = 0; i < matrizUsuarios.length; i++){
                if(matrizUsuarios[i][0] == getID()){
                    System.out.println("El indice es: "+i+"\nEl Id es: "+matrizUsuarios[i][0]+"\nEl id ingresado es: "+ getID());
                    return true;
                }
            }
            return true;
        }
    }

    //Verifica si el id del usiario es identico a otro
    private boolean usuarioExistente(String id){
        for(int i = 0; i < matrizUsuarios.length; i++){
            if(matrizUsuarios[i][0] == id){
                System.out.println("El indice es: "+i+"\nEl Id es: "+matrizUsuarios[i][0]+"\nEl id ingresado es: "+ id);
                return true;
            }
        }
        return false;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
