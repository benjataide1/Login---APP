package org.myapp.login.logic.entities;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    public User(String user, String password, Rol oneRol) {
        this.user = user;
        this.password = password;
        this.oneRol = oneRol;
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

    public Rol getOneRol() {
        return oneRol;
    }

    public String getNameRol(){
        return this.oneRol.getNameRol();
    }

    public void setOneRol(Rol oneRol) {
        this.oneRol = oneRol;
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
