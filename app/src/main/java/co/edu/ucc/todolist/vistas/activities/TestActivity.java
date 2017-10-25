package co.edu.ucc.todolist.vistas.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.edu.ucc.todolist.R;
import co.edu.ucc.todolist.vistas.presenters.ITestPresenter;
import co.edu.ucc.todolist.vistas.presenters.TestPresenter;

public class TestActivity extends AppCompatActivity implements ITestView {

    @BindView(R.id.txtnombre)
    EditText txtNombre;

    @BindView(R.id.btnMensaje)
    Button btnMensaje;

    private ITestPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        ButterKnife.bind(this);

        presenter = new TestPresenter(this);
    }

    @Override
    public void mostrarNombre(String nombre) {
        Toast.makeText(this, nombre, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void deshabilitarBoton() {
        btnMensaje.setEnabled(false);
    }

    @OnClick(R.id.btnMensaje)
    @Override
    public void clickMostrar() {
        presenter.cambiarMayusculaNombre(txtNombre.getText().toString());
    }
}
