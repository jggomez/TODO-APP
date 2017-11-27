package co.edu.ucc.todolist.data.mapper;

import java.util.ArrayList;
import java.util.List;

import co.edu.ucc.todolist.data.modelo.TareaEntity;
import co.edu.ucc.todolist.modelo.Tarea;

/**
 * Created by jggomez on 23-Nov-17.
 */

public class TareaDataMapper {

    public TareaEntity transformarTareaEntity(Tarea tarea) {

        TareaEntity tareaEntity = new TareaEntity();

        tareaEntity.setId(tarea.getId());
        tareaEntity.setNombre(tarea.getNombre());
        tareaEntity.setRealizada(tarea.isRealizada());

        return tareaEntity;
    }

    public Tarea transformarTarea(TareaEntity tareaEntity) {

        Tarea tarea = new Tarea();

        tarea.setId(tareaEntity.getId());
        tarea.setNombre(tareaEntity.getNombre());
        tarea.setRealizada(tareaEntity.isRealizada());

        return tarea;
    }

    public List<Tarea> transformar(List<TareaEntity> tareasEntity) {

        Tarea tarea;
        List<Tarea> lstTarea = new ArrayList<>();

        for (TareaEntity tareaEntity : tareasEntity) {
            tarea = new Tarea();
            tarea.setId(tareaEntity.getId());
            tarea.setNombre(tareaEntity.getNombre());
            tarea.setRealizada(tareaEntity.isRealizada());
            lstTarea.add(tarea);
        }

        return lstTarea;
    }


}
