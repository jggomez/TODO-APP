package co.edu.ucc.todolist.dominio;

import java.util.List;

import co.edu.ucc.todolist.dominio.repositorio.TareaRepository;
import co.edu.ucc.todolist.modelo.Tarea;
import co.edu.ucc.todolist.util.CallBackInteractor;

/**
 * Created by jggomez on 05-Sep-17.
 */

public class LTarea implements ILtarea {

    private final TareaRepository tareaRepository;

    public LTarea(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    @Override
    public void add(Tarea tarea, CallBackInteractor<Boolean> callBackInteractor) {
        tareaRepository.adicionar(tarea, callBackInteractor);
    }

    @Override
    public void getTareas(CallBackInteractor<List<Tarea>> callBackInteractor) {
        tareaRepository.obtenerTodas(callBackInteractor);
    }

    @Override
    public void obtenerXID(int id, CallBackInteractor<Tarea> callBackInteractor) {
        tareaRepository.obtenerxId(id, callBackInteractor);
    }

    @Override
    public void actualizar(Tarea tarea, CallBackInteractor<Boolean> callBackInteractor) {
        tareaRepository.actualizar(tarea, callBackInteractor);
    }
}
