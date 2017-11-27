package co.edu.ucc.todolist.data.datasource;

import android.content.Context;

import co.edu.ucc.todolist.data.datasource.db.AppDB;
import co.edu.ucc.todolist.data.datasource.db.DBTareaDataStore;
import co.edu.ucc.todolist.data.datasource.db.TareaDataStore;

/**
 * Created by jggomez on 24-Nov-17.
 */

public class TareaDataStoreFactory {

    private Context context;

    public TareaDataStoreFactory(Context context) {
        this.context = context;
    }

    /*
    Se encarga de decidir donde obtiene el dato, si de cache, cloud, BD.
    Tambien es capaz de validar si esta en cache traerlo o si no ir a cloud
     */
    public TareaDataStore create() {
        return createDBTareaDataStore();
    }

    public TareaDataStore createDBTareaDataStore() {
        AppDB.init(context);
        return new DBTareaDataStore(AppDB.getInstancia().getTareaDAO());
    }

}
