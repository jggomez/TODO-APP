package co.edu.ucc.todolist.vistas.presenters;

import co.edu.ucc.todolist.vistas.activities.ITestView;

/**
 * Created by jggomez on 24-Oct-17.
 */

public class TestPresenter implements ITestPresenter {

    private ITestView view;

    public TestPresenter(ITestView view){
        this.view = view;
    }

    @Override
    public void cambiarMayusculaNombre(String nombre) {
        String nomMayuscula = nombre.toUpperCase();
        view.deshabilitarBoton();
        view.mostrarNombre(nomMayuscula);
    }
}
