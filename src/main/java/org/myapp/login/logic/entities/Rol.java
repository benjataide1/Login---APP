package org.myapp.login.logic.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Basic
    private String nameRol;
    private String description;

    //! Con quien voy a mapear del lado de User, obj 'oneRol'
    @OneToMany(mappedBy = "oneRol")
    private List<User> users;

    public Rol() {
    }

    public Rol(String nameRol, String description, List<User> users) {
        this.nameRol = nameRol;
        this.description = description;
        this.users = users;
    }


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameRol() {
        return nameRol;
    }

    public void setNameRol(String nameRol) {
        this.nameRol = nameRol;
    }
}
