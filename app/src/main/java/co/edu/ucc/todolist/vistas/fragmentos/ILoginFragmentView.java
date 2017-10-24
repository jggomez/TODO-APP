package co.edu.ucc.todolist.vistas.fragmentos;

/**
 * Created by jggomez on 24-Oct-17.
 */

public interface ILoginFragmentView {

    void habilitarVistas();
    void deshabilitarVistas();
    void mostrarProgress();
    void ocultarProgress();
    void login();
    void irARegistro();
    void finalizarLogin();
    void mostrarError(String mensaje);

}
