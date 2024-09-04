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

        if (us != null ) {

            String rol =  us.getOneRol().getNameRol();

            if (rol.equalsIgnoreCase("admin")) {

                Stage stage = null;
                Parent root = null;

                // Obtén la referencia al botón
                stage = (Stage) btnLogin.getScene().getWindow();

                // Carga el nuevo FXML
                root = FXMLLoader.load(getClass().getResource("/org/myapp/login/mainAdmin-view.fxml"));

                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();



            } if (rol.equals("user")) {

                Stage stage = null;
                Parent root = null;

                // Obtén la referencia al botón
                stage = (Stage) btnLogin.getScene().getWindow();

                // Carga el nuevo FXML
                root = FXMLLoader.load(getClass().getResource("/org/myapp/login/mainUser-view.fxml"));

                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();


            }
        } else {
            txtArea.setText("User or Password Incorrect");
        }

    }


}