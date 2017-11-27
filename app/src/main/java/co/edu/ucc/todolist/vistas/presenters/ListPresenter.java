package co.edu.ucc.todolist.vistas.presenters;

import android.content.Context;

import java.util.List;

import co.edu.ucc.todolist.data.datasource.TareaDataStoreFactory;
import co.edu.ucc.todolist.data.mapper.TareaDataMapper;
import co.edu.ucc.todolist.data.repository.TareaDataRepository;
import co.edu.ucc.todolist.dominio.ILtarea;
import co.edu.ucc.todolist.dominio.LTarea;
import co.edu.ucc.todolist.dominio.repositorio.TareaRepository;
import co.edu.ucc.todolist.modelo.Tarea;
import co.edu.ucc.todolist.util.CallBackInteractor;
import co.edu.ucc.todolist.vistas.activities.IListView;

/**
 * Created by jggomez on 12-Sep-17.
 */

public class ListPresenter implements IListPresenter {

    private IListView view;
    private ILtarea ltarea;
    private Context context;

    public ListPresenter(IListView view, Context context) {
        this.view = view;
        this.context = context;
        TareaRepository tareaRepository =
                new TareaDataRepository(new TareaDataStoreFactory(context),
                        new TareaDataMapper());
        ltarea = new LTarea(tareaRepository);
    }

    @Override
    public void addTarea(String descTarea) {
        Tarea objTarea = new Tarea();
        objTarea.setNombre(descTarea);
        objTarea.setRealizada(false);

        ltarea.add(objTarea, new CallBackInteractor<Boolean>() {
            @Override
            public void success(Boolean data) {
                obtenerTareas();
            }

            @Override
            public void error(String error) {
                //TODO: crear mensaje de error en la view
            }
        });

    }

    @Override
    public void obtenerTareas() {
        ltarea.getTareas(new CallBackInteractor<List<Tarea>>() {
            @Override
            public void success(List<Tarea> data) {
                view.refrescarListaTareas(data);
            }

            @Override
            public void error(String error) {
                //TODO: crear mensaje de error en la view
            }
        });
    }

    @Override
    public void itemCambioEstado(final int posicion, final boolean realizado) {
        ltarea.obtenerXID(posicion + 1, new CallBackInteractor<Tarea>() {
            @Override
            public void success(final Tarea tarea) {
                tarea.setRealizada(realizado);
                ltarea.actualizar(tarea, new CallBackInteractor<Boolean>() {
                    @Override
                    public void success(Boolean data) {
                        view.refrescarTarea(tarea, posicion);
                    }

                    @Override
                    public void error(String error) {

                    }
                });

            }

            @Override
            public void error(String error) {

            }
        });

    }
}
