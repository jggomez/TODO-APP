package co.edu.ucc.todolist.vistas.fragmentos;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.edu.ucc.todolist.R;
import co.edu.ucc.todolist.vistas.presenters.ILoginPresenter;
import co.edu.ucc.todolist.vistas.presenters.LoginPresenter;

/**
 * Juan Guillermo Gómez
 */
public class LoginFragment extends Fragment implements ILoginFragmentView {

    @BindView(R.id.txtEmailLogin)
    EditText txtEmail;

    @BindView(R.id.txtPasswordLogin)
    EditText txtContrasena;

    @BindView(R.id.progress)
    ProgressBar progress;

    @BindView(R.id.btnIngresarLogin)
    Button btnIngresarLogin;

    @BindView(R.id.btnCrearCuenta)
    Button btnCrearCuenta;

    private ILoginPresenter loginPresenter;

    private OnLoginFragmentInteraction mListener;

    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment LoginFragment.
     */
    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);

        loginPresenter = new LoginPresenter(this);

        return view;
    }

    @OnClick(R.id.btnIngresarLogin)
    public void login() {

        final String email = txtEmail.getText().toString();
        String contrasena = txtContrasena.getText().toString();

        loginPresenter.login(email, contrasena);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnLoginFragmentInteraction) {
            mListener = (OnLoginFragmentInteraction) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void habilitarVistas() {
        txtContrasena.setEnabled(true);
        txtEmail.setEnabled(true);
        btnIngresarLogin.setEnabled(true);
        btnCrearCuenta.setEnabled(true);
    }

    @Override
    public void deshabilitarVistas() {
        txtContrasena.setEnabled(false);
        txtEmail.setEnabled(false);
        btnIngresarLogin.setEnabled(false);
        btnCrearCuenta.setEnabled(false);
    }

    @Override
    public void mostrarProgress() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void ocultarProgress() {
        progress.setVisibility(View.GONE);
    }

    @OnClick(R.id.txtRecordarContrasena)
    @Override
    public void irARegistro() {
        if (mListener != null) {
            mListener.irARegistro();
        }
    }

    @Override
    public void finalizarLogin() {
        if (mListener != null) {
            mListener.finalizarLogin();
        }
    }

    @Override
    public void mostrarError(String mensaje) {
        Snackbar.make(getView(), mensaje, Snackbar.LENGTH_LONG).show();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    public interface OnLoginFragmentInteraction {

        void finalizarLogin();

        void irARegistro();

    }
}
