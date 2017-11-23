package co.edu.ucc.todolist.vistas.presenters;

import co.edu.ucc.todolist.dominio.CallBackInteractor;
import co.edu.ucc.todolist.dominio.ILUsuario;
import co.edu.ucc.todolist.dominio.LUsuario;
import co.edu.ucc.todolist.vistas.fragmentos.IRecordarPasswordView;

/**
 * Created by jggomez on 22-Nov-17.
 */

public class RecordarPasswordPresenter implements IRecordarPasswordPresenter {

    private IRecordarPasswordView recordarPasswordView;
    private ILUsuario lUsuario;

    public RecordarPasswordPresenter(IRecordarPasswordView view) {
        this.recordarPasswordView = view;
        lUsuario = new LUsuario();
    }

    @Override
    public void recordarPassword(String email) {
        recordarPasswordView.deshabilitarControles();
        recordarPasswordView.mostrarProgress();

        try {

            lUsuario.recordarPassword(email, new CallBackInteractor<Boolean>() {
                @Override
                public void success(Boolean data) {
                    recordarPasswordView.habilitarControles();
                    recordarPasswordView.ocultarProgress();
                    recordarPasswordView.finalizarRecordarPassword();
                }

                @Override
                public void error(String error) {
                    recordarPasswordView.habilitarControles();
                    recordarPasswordView.ocultarProgress();
                    recordarPasswordView.mostrarError(error);
                }
            });

        } catch (Exception ex) {
            recordarPasswordView.habilitarControles();
            recordarPasswordView.ocultarProgress();
            recordarPasswordView.mostrarError(ex.getMessage());
        }
    }
}
