package co.edu.ucc.todolist.dominio;

import co.edu.ucc.todolist.modelo.Usuario;
import co.edu.ucc.todolist.util.CallBackInteractor;

/**
 * Created by jggomez on 24-Oct-17.
 */

public interface ILUsuario {

    void crearUsuario(String password, Usuario usuario,
                      CallBackInteractor<String> callBackInteractor);

    void authUsuario(String email, String password,
                     CallBackInteractor<String> callBackInteractor);

    void recordarPassword(String email, CallBackInteractor<Boolean> callBackInteractor);

}
