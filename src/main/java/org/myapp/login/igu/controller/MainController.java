package org.myapp.login.igu.controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.myapp.login.logic.Controller;
import org.myapp.login.logic.entities.User;

import java.io.IOException;

public class MainController {

    @FXML
    public TextField txtUser;
    @FXML
    public TextField txtPassword;
    public TextArea txtArea;
    public Button btnLogin;


    private Controller controller = new Controller();


    public void btnClean(ActionEvent actionEvent) {
        txtUser.setText("");
        txtPassword.setText("");
        txtArea.setText("");
    }

    public void btnLogin(ActionEvent actionEvent) throws IOException {

        String user = txtUser.getText();
        String password = txtPassword.getText();

        User us = controller.valideUser(user, password);

        if (us != null) {

            String rol = us.getOneRol().getNameRol();
            FXMLLoader loader = null;
            Parent root = null;

            if (rol.equalsIgnoreCase("admin")) {

                loader = new FXMLLoader(getClass().getResource("/org/myapp/login/mainAdmin-view.fxml"));
                root = loader.load(); // Carga el nuevo FXML

                // Obtén el controlador del archivo FXML cargado
                MainAdminController mainAdminController = loader.getController();
                mainAdminController.setTxtLabel("admin"); // Pasar el nombre del usuario


            } else if (rol.equals("user")) {

                loader = new FXMLLoader(getClass().getResource("/org/myapp/login/mainUser-view.fxml"));
                root = loader.load(); // Carga el nuevo FXML

                // Obtén el controlador del archivo FXML cargado
                MainUserController mainUserController = loader.getController();
                mainUserController.setTxtLabel(user); // Pasar el nombre del usuario

            }

            if (root != null) {
                Stage stage = (Stage) btnLogin.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                txtArea.setText("User or Password Incorrect");


            }


        }

    }
}