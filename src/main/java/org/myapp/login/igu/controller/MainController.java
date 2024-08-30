package org.myapp.login.igu.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    public TextField txtUser;
    @FXML
    public TextField txtPassword;
    public TextArea txtArea;


    public void btnClean(ActionEvent actionEvent) {
        txtUser.setText("");
        txtPassword.setText("");
        txtArea.setText("");
    }
}