package org.myapp.login.igu.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.myapp.login.logic.Controller;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AltaUserController implements Initializable {
    public Button btnExit;
    public Button btnClean;
    public PasswordField txtPassword;
    public ComboBox cmbRol;
    public TextField txtUserName;

    Controller controller = new Controller();


    public void Clean(ActionEvent actionEvent) {

        txtPassword.setText("");
        txtUserName.setText("");
        cmbRol.setValue(null);
    }


    public void Save(ActionEvent actionEvent) {

        String password = txtPassword.getText();
        String userName = txtUserName.getText();
        String rol = (String) cmbRol.getValue();

        controller.save(userName,password,rol);

        showMessage("Create Succesfully","Info","User Create");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        controller.findRolEntities().forEach((r) -> {
            cmbRol.getItems().addAll(r.getNameRol());
        });

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
}
