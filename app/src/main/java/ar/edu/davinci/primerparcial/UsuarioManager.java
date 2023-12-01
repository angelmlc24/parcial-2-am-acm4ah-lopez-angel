package ar.edu.davinci.primerparcial;

import java.util.ArrayList;
import java.util.List;

public class UsuarioManager {
    private static List<Usuario> userList = new ArrayList<>();

    public static List<Usuario> getUserList() {
        return userList;
    }

    public static void agregarUsuario(Usuario usuario) {
        userList.add(usuario);
    }
}
