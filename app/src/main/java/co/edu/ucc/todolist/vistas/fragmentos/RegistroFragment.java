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
import co.edu.ucc.todolist.vistas.presenters.IRegistroPresenter;
import co.edu.ucc.todolist.vistas.presenters.RegistroPresenter;

/**
 * Juan Guillermo Gómez
 */
public class RegistroFragment extends Fragment implements IRegistroFragmentView {

    @BindView(R.id.txtEmailLogin)
    EditText txtEmailLogin;

    @BindView(R.id.txtNombres)
    EditText txtNombres;

    @BindView(R.id.txtPasswordLogin)
    EditText txtPasswordLogin;

    @BindView(R.id.btnCrearCuenta)
    Button btnCrearCuenta;

    @BindView(R.id.progress)
    ProgressBar progress;

    private IRegistroPresenter registroPresenter;

    private OnRegistroInteractionListener mListener;

    public RegistroFragment() {
        // Required empty public constructor
    }

    public static RegistroFragment newInstance() {
        RegistroFragment fragment = new RegistroFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registro, container, false);

        ButterKnife.bind(this, view);

        registroPresenter = new RegistroPresenter(this);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnRegistroInteractionListener) {
            mListener = (OnRegistroInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnRegistroInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void habilitarControles() {
        txtNombres.setEnabled(true);
        txtEmailLogin.setEnabled(true);
        txtPasswordLogin.setEnabled(true);
        btnCrearCuenta.setEnabled(true);
    }

    @Override
    public void deshabilitarControles() {
        txtNombres.setEnabled(false);
        txtEmailLogin.setEnabled(false);
        txtPasswordLogin.setEnabled(false);
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

    @OnClick(R.id.btnCrearCuenta)
    @Override
    public void registrar() {
        String nombres = txtNombres.getText().toString();
        String email = txtEmailLogin.getText().toString();
        String password = txtPasswordLogin.getText().toString();

        registroPresenter.registrar(nombres, email, password);
    }

    @Override
    public void mostrarError(String error) {
        Snackbar.make(getView(), error, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void irALogin() {
        if (mListener != null) {
            mListener.irALogin();
        }
    }

    @Override
    public void finalizarRegistro() {
        if (mListener != null) {
            mListener.finalizarRegistro();
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    public interface OnRegistroInteractionListener {

        void irALogin();

        void finalizarRegistro();

    }
}
