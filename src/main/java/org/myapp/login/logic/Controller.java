package org.myapp.login.logic;

import org.myapp.login.logic.entities.Rol;
import org.myapp.login.logic.entities.User;
import org.myapp.login.persistence.RolController;

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

    public List<User> findUserEntities() {
        return controllerPersistence.findUserEntities();
    }

    public List<Rol> findRolEntities() {

        return controllerPersistence.findRolEntities();
    }


    public Rol findRol(String rolRecibido) {

        List<Rol> roles = controllerPersistence.findRolEntities();

        for (Rol rol : roles) {
            if (rol.getNameRol().equals(rolRecibido)) {
                return rol;
            }
        }
        return null;

    }

    public void save(String userName, String password, String rol) {


        Rol rol1 = new Rol();
        rol1 = findRol(rol);

        if (rol1 != null) {
            User user = new User(userName, password, rol1);
            controllerPersistence.saveUser(user);
        }


    }

    public void deleteUser(int id) {
        controllerPersistence.deleteUser(id);
    }

    public User findUser(int id) {
        return controllerPersistence.findUser(id);
    }

    public void editUser(int id, String password, String user, String rol) throws Exception {

        User user1 = findUser(id);
        Rol rol1 = findRol(rol);

        if (user1 != null) {
            user1.setUser(user);
            user1.setPassword(password);
            user1.setOneRol(rol1);

            controllerPersistence.updateUser(user1);
        }
    }
}
