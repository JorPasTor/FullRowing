module org.example.fullrowing {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires org.hibernate.orm.core;
    requires org.jboss.logging;
    requires java.naming;
    requires jakarta.persistence;


    opens org.example.fullrowing to javafx.fxml, org.hibernate.orm.core, org.jboss.logging;
    opens org.example.fullrowing.Model.Entities to  org.hibernate.orm.core;
    exports org.example.fullrowing;
    exports org.example.fullrowing.Model.Entities;

}