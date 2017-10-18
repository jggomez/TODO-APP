package co.edu.ucc.todolist.repository;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import co.edu.ucc.todolist.modelo.Tarea;

/**
 * Created by jggomez on 03-Oct-17.
 */
@Dao
public interface TareaDAO {

    @Insert
    void insert(Tarea... tareas);

    @Update
    void update(Tarea... tareas);

    @Delete
    void delete(Tarea... tarea);

    @Query("select * from tareas")
    List<Tarea> obtenerTodos();

    @Query("select * from tareas where id = :id")
    Tarea obtenerXID(int id);

}
