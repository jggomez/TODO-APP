package co.edu.ucc.todolist.dominio;

import java.util.List;

import co.edu.ucc.todolist.modelo.Tarea;

/**
 * Created by jggomez on 12-Sep-17.
 */

public interface ILtarea {

    void addTarea(Tarea tarea);

    List<Tarea> getTareas();

}
