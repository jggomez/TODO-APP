package co.edu.ucc.todolist.vistas.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import co.edu.ucc.todolist.R;
import co.edu.ucc.todolist.vistas.fragmentos.LoginFragment;
import co.edu.ucc.todolist.vistas.fragmentos.RegistroFragment;

public class AuthActivity extends AppCompatActivity
        implements LoginFragment.OnLoginFragmentInteraction,
        RegistroFragment.OnRegistroInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        initFragment();
    }

    private void initFragment() {
        FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.frameAuthActivity, LoginFragment.newInstance());
        transaction.commit();
    }

    @Override
    public void finalizarLogin() {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void irARegistro() {
        FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.frameAuthActivity, RegistroFragment.newInstance());
        transaction.commit();
    }

    @Override
    public void irALogin() {
        FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.frameAuthActivity, LoginFragment.newInstance());
        transaction.commit();
    }

    @Override
    public void finalizarRegistro() {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
        finish();
    }
}
