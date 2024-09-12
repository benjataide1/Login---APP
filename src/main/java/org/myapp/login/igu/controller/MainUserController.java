package org.myapp.login.igu.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.myapp.login.logic.Controller;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainUserController implements Initializable {
    public Label txtLabel;
    public Button btnExit;
    public TableColumn rol;
    public TableColumn id;
    public TableColumn user;
    public TableView tablaView;


    Controller controller = new Controller();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        table();

    }

    public void setTxtLabel(String newUser) {
        txtLabel.setText(newUser);
    }

    public void btnExit(ActionEvent actionEvent) {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        // Cerrar el Stage
        stage.close();
    }


    public void table() {

        tablaView.getItems().clear();

        // Asigo las propiedas que van a recibir las columnas de mi Object User
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        user.setCellValueFactory(new PropertyValueFactory<>("user"));
        rol.setCellValueFactory(new PropertyValueFactory<>("nameRol"));


        if (controller.findUserEntities() != null) {
            controller.findUserEntities().forEach((p) -> {
                tablaView.getItems().addAll(p);
            });
        }

    }


    public void btnReload(ActionEvent actionEvent) {
        table();
    }
}
