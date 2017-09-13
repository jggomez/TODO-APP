package co.edu.ucc.todolist.vistas;

import java.util.List;

import co.edu.ucc.todolist.modelo.Tarea;

/**
 * Created by jggomez on 12-Sep-17.
 */

public interface IListView {

    void clickAddTarea();

    void refrescarListaTareas();

    void refrescarTarea(int posicion, boolean estado);

}
