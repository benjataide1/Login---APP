package org.myapp.login.logic;

import org.myapp.login.logic.entities.User;

import java.util.List;

public class Controller {

    ControllerPersistence controllerPersistence = new ControllerPersistence();

    public User valideUser(String user, String password) {
        List<User> users = controllerPersistence.findUserEntities();

        for (User s : users) {
            if (s.getUser().equals(user)) {
                if (s.getPassword().equals(password)) {
                    return s; // Usuario encontrado, devolverlo
                } else {
                    return null; // El nombre de usuario coincide, pero la contraseña es incorrecta
                }
            }
        }

        return null; // Si no se encontró ningún usuario con el nombre de usuario y la contraseña dados
    }

}
