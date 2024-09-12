package org.myapp.login.igu.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.myapp.login.igu.MainUser;
import org.myapp.login.logic.Controller;
import org.myapp.login.logic.entities.Rol;
import org.myapp.login.logic.entities.User;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UpdateUserController {
    public TextField txtUserName;
    public ComboBox cmbRol;
    public PasswordField txtPassword;
    public Button btnExit;
    public int id;
    public Button btnUpdate;

    Controller controller = new Controller();


    public void Clean(ActionEvent actionEvent) {
        txtPassword.setText("");
        txtUserName.setText("");
    }

    public void Update(ActionEvent actionEvent) {

        String password = txtPassword.getText();
        String user = txtUserName.getText();
        String rol = (String) cmbRol.getValue();

        Stage stage = null;
        Parent root = null;
        FXMLLoader loader = null;

        try {

            controller.editUser(id, password, user, rol);

            showMessage("Update Succesful", "Info", "User Update");

            if (rol.equals("admin")) {
                // Obtén la referencia al botón
                stage = (Stage) btnUpdate.getScene().getWindow();

                loader = new FXMLLoader(getClass().getResource("/org/myapp/login/mainAdmin-view.fxml"));
                root = loader.load(); //


                // Obtén el controlador del archivo FXML cargado
                MainAdminController mainAdminController = loader.getController();
                mainAdminController.setTxtLabel("admin"); //

            } else if (rol.equals("user")) {


                // Obtén la referencia al botón
                stage = (Stage) btnUpdate.getScene().getWindow();

                loader = new FXMLLoader(getClass().getResource("/org/myapp/login/mainUser-view.fxml"));
                root = loader.load(); //


                // Obtén el controlador del archivo FXML cargado
                MainUserController user1 = loader.getController();
                user1.setTxtLabel("user"); //
            }


        } catch (Exception e) {
            e.getMessage();
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void showMessage(String message, String type, String title) {
        JOptionPane optionPane = new JOptionPane(message);
        if (type.equals("Info")) {
            optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        } else if (type.equals("Error")) {
            optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
        }
        JDialog dialog = optionPane.createDialog(title);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }

    public void findUser(int id) {
        this.id = id;

        User user = controller.findUser(id);

        txtPassword.setText(user.getPassword());
        txtUserName.setText(user.getUser());

        controller.findRolEntities().forEach((r) -> {
            cmbRol.getItems().addAll(r.getNameRol());
        });


    }


}
