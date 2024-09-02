package org.myapp.login.logic.entities;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic
    private String user;
    private String password;

    //! Hago referencia ami Entity Rol para saber en mi BD a que hago referencia
    @ManyToOne
    @JoinColumn(name = "FK_Rol") //! 'FK_Rol' es la columna en mi BD ,donde hace referencia a cada Rol
    private Rol oneRol; // oneRol por que N users tiene 1 Rol


    public User() {
    }

    public User(String password, String user) {
        this.password = password;
        this.user = user;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("id_user=").append(id);
        sb.append(", user='").append(user).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
