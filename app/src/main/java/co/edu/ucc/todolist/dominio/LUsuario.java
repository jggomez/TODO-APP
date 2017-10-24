package co.edu.ucc.todolist.dominio;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import co.edu.ucc.todolist.modelo.Usuario;

/**
 * Created by jggomez on 24-Oct-17.
 */

public class LUsuario implements ILUsuario {

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference refUsuarios;

    public LUsuario() {
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        refUsuarios = firebaseDatabase.getReference("usuarios-todo");
    }

    @Override
    public void crearUsuario(String password, final Usuario usuario, final CallBackInteractor<String> callBackInteractor) {

        firebaseAuth.createUserWithEmailAndPassword(usuario.getEmail(), password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            usuario.setUid(task.getResult().getUser().getUid());
                            refUsuarios.child(usuario.getUid())
                                    .setValue(usuario);
                        } else {
                            callBackInteractor.error(task.getException().getMessage());
                        }

                    }
                });

    }

    @Override
    public void authUsuario(String email, String password, final CallBackInteractor<String> callBackInteractor) {

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            refUsuarios.child(task.getResult().getUser().getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    Usuario usuario = dataSnapshot.getValue(Usuario.class);
                                    callBackInteractor.success(usuario.getNombres());
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {
                                    callBackInteractor.error(databaseError.getMessage());
                                }
                            });
                        } else {
                            callBackInteractor.error(task.getException().getMessage());
                        }
                    }
                });
    }
}
