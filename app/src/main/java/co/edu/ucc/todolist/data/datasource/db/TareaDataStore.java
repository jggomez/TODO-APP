package co.edu.ucc.todolist.data.datasource.db;

import java.util.List;

import co.edu.ucc.todolist.data.modelo.TareaEntity;
import co.edu.ucc.todolist.util.CallBackInteractor;

/**
 * Created by jggomez on 23-Nov-17.
 */

public interface TareaDataStore {

    void adicionar(TareaEntity tarea, CallBackInteractor<Boolean> callBackInteractor);

    void obtenerTodas(CallBackInteractor<List<TareaEntity>> callBackInteractor);

    void obtenerxId(int id, CallBackInteractor<TareaEntity> callBackInteractor);

    void actualizar(TareaEntity tarea, CallBackInteractor<Boolean> callBackInteractor);
}
