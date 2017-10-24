package co.edu.ucc.todolist.vistas.activities;

import java.util.List;

import co.edu.ucc.todolist.modelo.Tarea;

/**
 * Created by jggomez on 12-Sep-17.
 */

public interface IListView {

    void clickAddTarea();

    void refrescarListaTareas(List<Tarea> lstTarea);

    void refrescarTarea(Tarea tarea, int posicion);

}
