module org.myapp.login {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires java.sql;
    requires org.hibernate.orm.core;


    exports org.myapp.login.igu;
    opens org.myapp.login.igu to javafx.fxml;
    exports org.myapp.login.igu.controller;
    opens org.myapp.login.logic.entities to org.hibernate.orm.core;
    opens org.myapp.login.igu.controller to javafx.fxml;
}