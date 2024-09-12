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
import org.myapp.login.logic.Controller;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class AltaUserController implements Initializable {
    public Button btnExit;
    public PasswordField txtPassword;
    public ComboBox cmbRol;
    public TextField txtUserName;
    public Button btnSave;

    Controller controller = new Controller();


    public void Clean(ActionEvent actionEvent) {

        txtPassword.setText("");
        txtUserName.setText("");
    }


    public void Save(ActionEvent actionEvent) {

        String password = txtPassword.getText();
        String userName = txtUserName.getText();
        String rol = (String) cmbRol.getValue();

        controller.save(userName,password,rol);

        showMessage("Create Succesfully","Info","User Create");

        Stage stage = null;
        Parent root = null;
        FXMLLoader loader = null;


        try {
            // Obtén la referencia al botón
            stage = (Stage) btnSave.getScene().getWindow();

            // Carga el nuevo FXML
            loader = new FXMLLoader(getClass().getResource("/org/myapp/login/mainAdmin-view.fxml"));
            root = loader.load(); //

            // Obtén el controlador del archivo FXML cargado
            MainAdminController mainAdminController = loader.getController();
            mainAdminController.setTxtLabel("admin"); //

        } catch (IOException e) {
            e.getMessage();
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

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
