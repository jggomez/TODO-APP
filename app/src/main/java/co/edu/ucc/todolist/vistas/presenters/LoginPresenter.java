package co.edu.ucc.todolist.vistas.presenters;

import co.edu.ucc.todolist.dominio.CallBackInteractor;
import co.edu.ucc.todolist.dominio.ILUsuario;
import co.edu.ucc.todolist.dominio.LUsuario;
import co.edu.ucc.todolist.vistas.fragmentos.ILoginFragmentView;

/**
 * Created by jggomez on 24-Oct-17.
 */

public class LoginPresenter implements ILoginPresenter {

    private ILoginFragmentView view;
    private ILUsuario lUsuario;

    public LoginPresenter(ILoginFragmentView view) {
        this.view = view;
        lUsuario = new LUsuario();
    }

    @Override
    public void login(String email, String password) {
        view.deshabilitarVistas();
        view.mostrarProgress();

        try {
            lUsuario.authUsuario(email, password, new CallBackInteractor<String>() {
                @Override
                public void success(String data) {
                    view.habilitarVistas();
                    view.ocultarProgress();
                    view.finalizarLogin();
                }

                @Override
                public void error(String error) {
                    view.habilitarVistas();
                    view.ocultarProgress();
                    view.mostrarError(error);
                }
            });
        } catch (Exception e) {
            view.habilitarVistas();
            view.ocultarProgress();
            view.mostrarError(e.getMessage());
        }
    }
}
