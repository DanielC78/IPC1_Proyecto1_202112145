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
    public static String matrizUsuarios[][] = new String[100][6];


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

    public String crearUsuario(){
        if(!usuarioExistente()) {
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
            return "<html><p style=\"text-align:center\">¡USUARIO CREADO<p style=\"text-align:center\">CORRECTAMENTE!<p></p><html>";
        } else if(usuarioExistente()){
            return "¡Error!, el usuario ya existe";
        } else{
            return "Hubo un error";
        }
    }
    //Busca al usuario dentro del arreglo
    public String[] datosUsuario(String id){
        String[] matrizDatos = new String[7];
        String idComprobacion;
        for(int i = 0; i < matrizUsuarios.length; i++){
            idComprobacion = matrizUsuarios[i][0];
            if(matrizUsuarios[i][0] != null){
                if(idComprobacion.equals(id)){
                    for (int j = 0; j < matrizUsuarios[i].length; j++){
                        matrizDatos[j] = matrizUsuarios[i][j];
                        matrizDatos[6] = String.valueOf(i);
                    }
                }
            }
        }
        return matrizDatos;
    }

    public String eliminarUsuario(){
        return "Eliminacion exitosa";
    }

    public String actualizarUsuario(int indice, String id, String nombre, String apellido,String user, String rol, String password){
        matrizUsuarios[indice][0] = id;
        matrizUsuarios[indice][1] = nombre;
        matrizUsuarios[indice][2] = apellido;
        matrizUsuarios[indice][3] = user;
        matrizUsuarios[indice][4] = rol;
        matrizUsuarios[indice][5] = password;
        return "ACTUALIZACIÓN EXITOSA";
    }


    //Verifica si el id del usiario es identico a otro
    private boolean usuarioExistente(){
        boolean idExistente = false;
        String comprobacion;
        for(int i = 0; i < matrizUsuarios.length; i++){
            comprobacion = matrizUsuarios[i][0];
            if(comprobacion != null){
                if(comprobacion.equals(getID())){
                    idExistente = true;
                    break;
                }
            }
        }
        return idExistente;
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
