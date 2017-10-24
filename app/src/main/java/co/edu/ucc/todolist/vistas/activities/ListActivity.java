package co.edu.ucc.todolist.vistas.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.edu.ucc.todolist.R;
import co.edu.ucc.todolist.modelo.Tarea;
import co.edu.ucc.todolist.vistas.adaptadores.TodoListAdapter;
import co.edu.ucc.todolist.vistas.presenters.IListPresenter;
import co.edu.ucc.todolist.vistas.presenters.ListPresenter;

public class ListActivity extends AppCompatActivity implements
        IListView, TodoListAdapter.OnListenerItemCheck {

    private IListPresenter listPresenter;
    private TodoListAdapter adapter;

    @BindView(R.id.rvListTODO)
    RecyclerView rvListTODO;

    @BindView(R.id.txtTarea)
    EditText txtTarea;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        listPresenter = new ListPresenter(this);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvListTODO.setLayoutManager(llm);

        List<Tarea> lsTarea = listPresenter.obtenerTareas();

        adapter = new TodoListAdapter(lsTarea, this);

        rvListTODO.setAdapter(adapter);

    }

    @OnClick(R.id.btnEnviarTarea)
    @Override
    public void clickAddTarea() {
        String descTarea = txtTarea.getText().toString();
        listPresenter.addTarea(descTarea);
    }

    @Override
    public void refrescarListaTareas(List<Tarea> lstTareas) {

        adapter.setDataset(lstTareas);

        rvListTODO.getAdapter().notifyDataSetChanged();

        rvListTODO.scrollToPosition(
                rvListTODO.getAdapter().getItemCount() - 1);

        txtTarea.setText("");
    }

    @Override
    public void refrescarTarea(Tarea tarea, int posicion) {
        adapter.setItemDataset(tarea, posicion);
        rvListTODO.getAdapter().notifyItemChanged(posicion);
    }

    @Override
    public void itemCambioEstado(int posicion, boolean realizada) {
        listPresenter.itemCambioEstado(posicion, realizada);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.salir){
            Intent intent = new Intent(this, AuthActivity.class);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
