package co.edu.ucc.todolist.vistas.fragmentos;

/**
 * Created by jggomez on 22-Nov-17.
 */

public interface IRecordarPasswordView {

    void habilitarControles();
    void deshabilitarControles();
    void mostrarProgress();
    void ocultarProgress();
    void recordarPassword();
    void mostrarError(String error);
    void irLogin();
    void finalizarRecordarPassword();

}
