package co.edu.ucc.todolist.modelo;

/**
 * Created by jggomez on 24-Oct-17.
 */

public class Usuario {

    private String uid;
    private String nombres;
    private String email;

    public Usuario() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
