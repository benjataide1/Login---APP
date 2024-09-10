module org.myapp.login {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires java.desktop;


    exports org.myapp.login.igu;
    opens org.myapp.login.igu to javafx.fxml;

    // Abres el paquete 'entities' tanto para javafx como para Hibernate
    opens org.myapp.login.logic.entities to javafx.base, org.hibernate.orm.core;

    exports org.myapp.login.igu.controller;
    opens org.myapp.login.igu.controller to javafx.fxml;
}