package org.myapp.login.logic;

import org.myapp.login.logic.entities.User;

import java.util.List;

public class Controller {

    ControllerPersistence controllerPersistence = new ControllerPersistence();

    public String valideUser(String user, String password) {

        List<User> users = controllerPersistence.findUserEntities();
        String mes = "";

        for (User s : users) {

            if (s.getUser().equals(user)) {

                if (s.getPassword().equals(password)) {
                    mes = "User and Password Correct";
                    return mes;
                } else {
                    mes = "Password incorrect";
                    return mes;
                }
            } else {
                mes = "User and Password Incorrect";
            }

        }

        return mes;

    }
}
