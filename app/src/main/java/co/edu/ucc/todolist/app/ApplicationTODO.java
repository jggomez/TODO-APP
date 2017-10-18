package co.edu.ucc.todolist.app;

import android.app.Application;

import co.edu.ucc.todolist.repository.AppDB;

/**
 * Created by jggomez on 03-Oct-17.
 */

public class ApplicationTODO extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppDB.init(getApplicationContext());
    }
}
