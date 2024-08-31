package org.myapp.login.igu.controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.myapp.login.logic.Controller;

public class MainController {

    @FXML
    public TextField txtUser;
    @FXML
    public TextField txtPassword;
    public TextArea txtArea;


    private Controller controller = new Controller();



    public void btnClean(ActionEvent actionEvent) {
        txtUser.setText("");
        txtPassword.setText("");
        txtArea.setText("");
    }

    public void btnLogin(ActionEvent actionEvent) {

        String user = txtUser.getText();
        String password = txtPassword.getText();

        String message = controller.valideUser(user, password);

        txtArea.setText(message);
    }


}