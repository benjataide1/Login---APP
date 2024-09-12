package org.myapp.login.logic;

import org.myapp.login.logic.entities.Rol;
import org.myapp.login.logic.entities.User;
import org.myapp.login.persistence.RolController;
import org.myapp.login.persistence.UserController;

import java.util.List;

public class ControllerPersistence {

    UserController controller = new UserController();
    RolController rolController = new RolController();

    public List<User> findUserEntities() {
        return controller.findUserEntities();
    }

    public List<Rol> findRolEntities() {

        return rolController.findRolEntities();
    }

    public void saveUser(User user) {

        controller.create(user);
    }

    public void deleteUser(int id) {
        controller.destroy(id);
    }

    public User findUser(int id) {

        return controller.findUser(id);
    }


    public void updateUser(User user1) throws Exception {

        controller.edit(user1);
    }

}
