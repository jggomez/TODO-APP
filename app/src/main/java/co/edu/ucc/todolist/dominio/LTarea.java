package co.edu.ucc.todolist.dominio;

import java.util.ArrayList;
import java.util.List;

import co.edu.ucc.todolist.modelo.Tarea;
import co.edu.ucc.todolist.repository.AppDB;

/**
 * Created by jggomez on 05-Sep-17.
 */

public class LTarea implements ILtarea {

    private AppDB database;

    public LTarea(){
        database = AppDB.getInstancia();
    }

    @Override
    public void addTarea(Tarea tarea){
        database.getTareaDAO().insert(tarea);
    }

    @Override
    public List<Tarea> getTareas(){
        return database.getTareaDAO().obtenerTodos();
    }

    @Override
    public void actualizar(Tarea... tareas) {
        database.getTareaDAO().update(tareas);
    }

    @Override
    public Tarea obtenerXID(int id) {
        return database.getTareaDAO().obtenerXID(id);
    }
}
