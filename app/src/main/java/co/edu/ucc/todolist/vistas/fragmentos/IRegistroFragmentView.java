package co.edu.ucc.todolist.vistas.fragmentos;

/**
 * Created by jggomez on 24-Oct-17.
 */

public interface IRegistroFragmentView {

    void habilitarControles();
    void deshabilitarControles();
    void mostrarProgress();
    void ocultarProgress();
    void registrar();
    void mostrarError(String error);
    void irALogin();
    void finalizarRegistro();

}
