package co.edu.ucc.todolist.data.modelo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by jggomez on 23-Nov-17.
 */

@Entity(tableName = "tareasentity")
public class TareaEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String nombre;

    @ColumnInfo
    private boolean realizada;

    public TareaEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isRealizada() {
        return realizada;
    }

    public void setRealizada(boolean realizada) {
        this.realizada = realizada;
    }
}
