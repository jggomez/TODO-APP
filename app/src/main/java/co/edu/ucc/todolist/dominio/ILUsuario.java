package co.edu.ucc.todolist.dominio;

import co.edu.ucc.todolist.modelo.Usuario;

/**
 * Created by jggomez on 24-Oct-17.
 */

public interface ILUsuario {

    void crearUsuario(String password, Usuario usuario,
                      CallBackInteractor<String> callBackInteractor);

    void authUsuario(String email, String password,
                     CallBackInteractor<String> callBackInteractor);
}
