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
import co.edu.ucc.todolist.R;
import co.edu.ucc.todolist.vistas.presenters.IRecordarPasswordPresenter;
import co.edu.ucc.todolist.vistas.presenters.RecordarPasswordPresenter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RecordarPasswordFragment.OnRecordarPassInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RecordarPasswordFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecordarPasswordFragment extends Fragment implements IRecordarPasswordView {

    private OnRecordarPassInteractionListener mListener;
    private IRecordarPasswordPresenter presenter;

    @BindView(R.id.txtEmail)
    private EditText txtEmail;

    @BindView(R.id.btnRecodarContrasena)
    private Button btnRecodarContrasena;

    @BindView(R.id.progress)
    ProgressBar progress;

    public RecordarPasswordFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment RecordarPasswordFragment.
     */
    public static RecordarPasswordFragment newInstance() {
        RecordarPasswordFragment fragment = new RecordarPasswordFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recordar_password, container, false);
        ButterKnife.bind(this, view);

        presenter = new RecordarPasswordPresenter(this);

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnRecordarPassInteractionListener) {
            mListener = (OnRecordarPassInteractionListener) context;
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
    public void habilitarControles() {
        txtEmail.setEnabled(true);
        btnRecodarContrasena.setEnabled(true);
    }

    @Override
    public void deshabilitarControles() {
        txtEmail.setEnabled(false);
        btnRecodarContrasena.setEnabled(false);
    }

    @Override
    public void mostrarProgress() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void ocultarProgress() {
        progress.setVisibility(View.GONE);
    }

    @Override
    public void recordarPassword() {
        presenter.recordarPassword(txtEmail.getText().toString());
    }

    @Override
    public void mostrarError(String error) {
        Snackbar.make(getView(), error, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void irLogin() {
        if (mListener != null) {
            mListener.clickTienesCuenta();
        }
    }

    public void finalizarRecordarPassword() {
        if (mListener != null) {
            mListener.finalizarRecordarPassword();
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    public interface OnRecordarPassInteractionListener {

        void finalizarRecordarPassword();

        void clickTienesCuenta();
    }
}
