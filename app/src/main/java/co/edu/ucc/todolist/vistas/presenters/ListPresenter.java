package co.edu.ucc.todolist.vistas.presenters;

import java.util.List;

import co.edu.ucc.todolist.dominio.ILtarea;
import co.edu.ucc.todolist.dominio.LTarea;
import co.edu.ucc.todolist.modelo.Tarea;
import co.edu.ucc.todolist.vistas.IListView;

/**
 * Created by jggomez on 12-Sep-17.
 */

public class ListPresenter implements IListPresenter {

    private IListView view;
    private ILtarea ltarea;

    public ListPresenter(IListView view){
        this.view = view;
        ltarea = new LTarea();
    }

    @Override
    public void addTarea(String descTarea) {
        Tarea objTarea = new Tarea();
        objTarea.setNombre(descTarea);
        objTarea.setRealizada(false);

        ltarea.addTarea(objTarea);

        view.refrescarListaTareas();
    }

    @Override
    public List<Tarea> obtenerTareas() {
        return ltarea.getTareas();
    }
}
