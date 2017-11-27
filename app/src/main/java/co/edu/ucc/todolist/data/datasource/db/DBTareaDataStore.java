package co.edu.ucc.todolist.data.datasource.db;

import java.util.List;

import co.edu.ucc.todolist.data.modelo.TareaEntity;
import co.edu.ucc.todolist.util.CallBackInteractor;

/**
 * Created by jggomez on 23-Nov-17.
 */

public class DBTareaDataStore implements TareaDataStore {

    private TareaDAO tareaDAO;

    public DBTareaDataStore(TareaDAO tareaDAO) {
        this.tareaDAO = tareaDAO;
    }

    @Override
    public void adicionar(TareaEntity tarea, CallBackInteractor<Boolean> callBackInteractor) {
        try {
            tareaDAO.insertar(tarea);
            callBackInteractor.success(true);
        } catch (Exception ex) {
            callBackInteractor.error(ex.getMessage());
        }

    }

    @Override
    public void obtenerTodas(CallBackInteractor<List<TareaEntity>> callBackInteractor) {
        try {
            callBackInteractor.success(tareaDAO.obtenerTodos());
        } catch (Exception ex) {
            callBackInteractor.error(ex.getMessage());
        }
    }

    @Override
    public void obtenerxId(int id, CallBackInteractor<TareaEntity> callBackInteractor) {
        try {
            callBackInteractor.success(tareaDAO.obtenerXID(id));
        } catch (Exception ex) {
            callBackInteractor.error(ex.getMessage());
        }
    }

    @Override
    public void actualizar(TareaEntity tarea, CallBackInteractor<Boolean> callBackInteractor) {
        try {
            tareaDAO.actualizar(tarea);
            callBackInteractor.success(true);
        } catch (Exception ex) {
            callBackInteractor.error(ex.getMessage());
        }
    }
}
