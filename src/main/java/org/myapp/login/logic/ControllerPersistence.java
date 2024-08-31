package org.myapp.login.logic;

import org.myapp.login.logic.entities.User;
import org.myapp.login.persistence.UserController;

import java.util.List;

public class ControllerPersistence {

    UserController controller = new UserController();

    public List<User> findUserEntities() {
        return controller.findUserEntities();
    }
}
