package co.edu.ucc.todolist.dominio;

import java.util.List;

import co.edu.ucc.todolist.modelo.Tarea;
import co.edu.ucc.todolist.util.CallBackInteractor;

/**
 * Created by jggomez on 12-Sep-17.
 */

public interface ILtarea {

    void add(Tarea tarea, CallBackInteractor<Boolean> callBackInteractor);

    void getTareas(CallBackInteractor<List<Tarea>> callBackInteractor);

    void obtenerXID(int id, CallBackInteractor<Tarea> callBackInteractor);

    void actualizar(Tarea tarea, CallBackInteractor<Boolean> callBackInteractor);

}
