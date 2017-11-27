package co.edu.ucc.todolist.data.datasource.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import co.edu.ucc.todolist.data.modelo.TareaEntity;
import co.edu.ucc.todolist.modelo.Tarea;

/**
 * Created by jggomez on 03-Oct-17.
 */
@Dao
public interface TareaDAO {

    @Insert
    void insertar(TareaEntity... tareas);

    @Update
    void actualizar(TareaEntity... tareas);

    @Delete
    void eliminar(TareaEntity... tarea);

    @Query("select * from tareasentity")
    List<TareaEntity> obtenerTodos();

    @Query("select * from tareasentity where id = :id")
    TareaEntity obtenerXID(int id);

}
