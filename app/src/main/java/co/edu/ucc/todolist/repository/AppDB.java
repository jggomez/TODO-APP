package co.edu.ucc.todolist.repository;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import co.edu.ucc.todolist.modelo.Tarea;

/**
 * Created by jggomez on 03-Oct-17.
 */

@Database(entities = {Tarea.class}, version = 1)
public abstract class AppDB extends RoomDatabase {

    private static AppDB instancia = null;

    public static void init(Context context) {

        if (instancia == null) {
            instancia =
                    Room.databaseBuilder(context, AppDB.class, "tareas-db")
                            .allowMainThreadQueries()
                            .build();
        }
    }

    public static AppDB getInstancia() {
        return instancia;
    }

    public abstract TareaDAO getTareaDAO();
}
