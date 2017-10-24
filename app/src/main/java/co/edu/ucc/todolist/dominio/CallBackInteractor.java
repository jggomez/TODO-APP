package co.edu.ucc.todolist.dominio;

/**
 * Created by jggomez on 24-Oct-17.
 */

public interface CallBackInteractor<T> {

    void success(T data);

    void error(String error);
}
