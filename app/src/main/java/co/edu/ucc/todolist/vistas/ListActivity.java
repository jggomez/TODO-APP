package co.edu.ucc.todolist.vistas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import co.edu.ucc.todolist.R;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
    }
}
