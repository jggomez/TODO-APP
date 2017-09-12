package co.edu.ucc.todolist.dominio;

import java.util.ArrayList;
import java.util.List;

import co.edu.ucc.todolist.modelo.Tarea;

/**
 * Created by jggomez on 05-Sep-17.
 */

public class LTarea {

    private static List<Tarea> lstTarea = new ArrayList<>();

    public void addTarea(Tarea tarea){
        lstTarea.add(tarea);
    }

    public List<Tarea> getTareas(){
        return lstTarea;
    }
}
