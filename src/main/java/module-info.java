module org.myapp.login {
    requires javafx.controls;
    requires javafx.fxml;


    exports org.myapp.login.igu;
    opens org.myapp.login.igu to javafx.fxml;
    exports org.myapp.login.igu.controller;
    opens org.myapp.login.igu.controller to javafx.fxml;
}