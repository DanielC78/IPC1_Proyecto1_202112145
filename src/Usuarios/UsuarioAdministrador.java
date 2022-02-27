package Usuarios;


public class UsuarioAdministrador extends Usuario{

    //Credenciales del administrador
    private static String ID_ad = "admin";
    private static String Apellidos_ad = "";
    private static String Nombre_ad = "Administrador";
    private static String Usuario_ad = "admin";
    private static String Rol = "";
    private static String Password_ad = "password";
    private static String matrizUsuarios[][];

    public UsuarioAdministrador(String ID, String nombres, String apellidos, String user, String password, String rol, String[][] matrizUsuarios) {
        super(ID, nombres, apellidos, user, password, rol);
    }

    //Getters y Setters
    public static String getID_ad() {
        return ID_ad;
    }

    public static void setID_ad(String ID_ad) {
        UsuarioAdministrador.ID_ad = ID_ad;
    }

    public static String getNombre_ad() {
        return Nombre_ad;
    }

    public static void setNombre_ad(String nombre_ad) {
        Nombre_ad = nombre_ad;
    }

    public static String getUsuario_ad() {
        return Usuario_ad;
    }

    public static void setUsuario_ad(String usuario_ad) {
        Usuario_ad = usuario_ad;
    }

    public static String getPassword_ad() {
        return Password_ad;
    }

    public static void setPassword_ad(String password_ad) {
        Password_ad = password_ad;
    }


    //Acciones del Usuario Administrador

    public void CrearUsuarios(){

    }

    public void VerUsuarios(){

    }

    public void EliminarUsuarios(){

    }

    public void ModificarUsuarios(){

    }

    public void CrearBiblio(){

    }

    public void CargaIndividual(){

    }

    public void CargaMasiva(){

    }

}
