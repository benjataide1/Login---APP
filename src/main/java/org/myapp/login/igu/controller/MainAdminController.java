package org.myapp.login.igu.controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.myapp.login.igu.Main;
import org.myapp.login.logic.Controller;
import org.myapp.login.logic.entities.User;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainAdminController implements Initializable {
    public Label txtLabel;
    public Button btnExit;
    public TableColumn id;
    public TableColumn user;
    public TableColumn rol;
    public TableView tableView;

    public Controller controller = new Controller();
    public Button btnCreateUser;

    public void setTxtLabel(String newUser) {
        txtLabel.setText(newUser);
    }

    public void btnExit(ActionEvent actionEvent) {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        // Cerrar el Stage
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        table();
    }

    public void table() {
        tableView.getItems().clear();

        // Asigo las propiedas que van a recibir las columnas de mi Object User
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        user.setCellValueFactory(new PropertyValueFactory<>("user"));
        rol.setCellValueFactory(new PropertyValueFactory<>("nameRol"));


        if (controller.findUserEntities() != null) {
            controller.findUserEntities().forEach((p) -> {
                tableView.getItems().addAll(p);
            });
        }

    }


    public void btnCreate(ActionEvent actionEvent) throws IOException {

        Stage stage = null;
        Parent root = null;

        try {
            // Obtén la referencia al botón
            stage = (Stage) btnCreateUser.getScene().getWindow();

            // Carga el nuevo FXML
            root = FXMLLoader.load(getClass().getResource("/org/myapp/login/altaUser-view.fxml"));
        } catch (IOException e) {
            e.getMessage();
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void btnDelete(ActionEvent actionEvent) {

       if( tableView.getItems().stream().count() != 0 ){

           User user = (User) tableView.getSelectionModel().getSelectedItem();

           controller.deleteUser(user.getId());
           showMessage("User Delete successfully", "Info", "Delete successfully");
           table();
       }else {
           showMessage("Error With Delete User", "Error", "Error with Delete");
       }


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


