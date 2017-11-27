package co.edu.ucc.todolist.dominio.repositorio;

import java.util.List;

import co.edu.ucc.todolist.data.modelo.TareaEntity;
import co.edu.ucc.todolist.modelo.Tarea;
import co.edu.ucc.todolist.util.CallBackInteractor;

/**
 * Created by jggomez on 23-Nov-17.
 */

public interface TareaRepository {

    void adicionar(Tarea tarea, CallBackInteractor<Boolean> callBackInteractor);

    void obtenerTodas(final CallBackInteractor<List<Tarea>> callBackInteractor);

    void obtenerxId(int id, CallBackInteractor<Tarea> callBackInteractor);

    void actualizar(Tarea tarea, CallBackInteractor<Boolean> callBackInteractor);

}
