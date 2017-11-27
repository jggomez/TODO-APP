package co.edu.ucc.todolist.data.repository;

import java.util.List;

import co.edu.ucc.todolist.data.datasource.TareaDataStoreFactory;
import co.edu.ucc.todolist.data.datasource.db.TareaDataStore;
import co.edu.ucc.todolist.data.mapper.TareaDataMapper;
import co.edu.ucc.todolist.data.modelo.TareaEntity;
import co.edu.ucc.todolist.dominio.repositorio.TareaRepository;
import co.edu.ucc.todolist.modelo.Tarea;
import co.edu.ucc.todolist.util.CallBackInteractor;

/**
 * Created by jggomez on 23-Nov-17.
 */

public class TareaDataRepository implements TareaRepository {

    private TareaDataStoreFactory tareaDataStoreFactory;
    private TareaDataMapper tareaDataMapper;

    public TareaDataRepository(TareaDataStoreFactory tareaDataStoreFactory,
                               TareaDataMapper tareaDataMapper) {
        this.tareaDataStoreFactory = tareaDataStoreFactory;
        this.tareaDataMapper = tareaDataMapper;
    }


    @Override
    public void adicionar(Tarea tarea, CallBackInteractor<Boolean> callBackInteractor) {
        final TareaDataStore tareaDataStore = tareaDataStoreFactory.create();
        tareaDataStore.adicionar(tareaDataMapper.transformarTareaEntity(tarea), callBackInteractor);
    }

    @Override
    public void obtenerTodas(final CallBackInteractor<List<Tarea>> callBackInteractor) {
        final TareaDataStore tareaDataStore = tareaDataStoreFactory.createDBTareaDataStore();
        tareaDataStore.obtenerTodas(new CallBackInteractor<List<TareaEntity>>() {
            @Override
            public void success(List<TareaEntity> data) {
                callBackInteractor.success(tareaDataMapper.transformar(data));
            }

            @Override
            public void error(String error) {
                callBackInteractor.error(error);
            }
        });
    }

    @Override
    public void obtenerxId(int id, final CallBackInteractor<Tarea> callBackInteractor) {
        final TareaDataStore tareaDataStore = tareaDataStoreFactory.createDBTareaDataStore();
        tareaDataStore.obtenerxId(id, new CallBackInteractor<TareaEntity>() {
            @Override
            public void success(TareaEntity data) {
                callBackInteractor.success(tareaDataMapper.transformarTarea(data));
            }

            @Override
            public void error(String error) {
                callBackInteractor.error(error);
            }
        });
    }

    @Override
    public void actualizar(Tarea tarea, CallBackInteractor<Boolean> callBackInteractor) {
        final TareaDataStore tareaDataStore = tareaDataStoreFactory.create();
        tareaDataStore.adicionar(tareaDataMapper.transformarTareaEntity(tarea), callBackInteractor);
    }
}
