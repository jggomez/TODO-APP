package co.edu.ucc.todolist.vistas.presenters;

import java.util.List;

import co.edu.ucc.todolist.modelo.Tarea;

/**
 * Created by jggomez on 12-Sep-17.
 */

public interface IListPresenter {

    void addTarea(String descTarea);

    List<Tarea> obtenerTareas();

    void itemCambioEstado(int posicion, boolean realizado);

}
