module todolist_interface.todolist_interface {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires javafx.media;

    opens appli.todolist_interface to javafx.fxml;
    exports appli.todolist_interface;
    exports appli.todolist_interface.type;
    opens appli.todolist_interface.type to javafx.fxml;
    exports appli.todolist_interface.tache;
    opens appli.todolist_interface.tache to javafx.fxml;
    exports appli.todolist_interface.liste;
    opens appli.todolist_interface.liste to javafx.fxml;
    exports appli.todolist_interface.todo;
    opens appli.todolist_interface.todo to javafx.fxml;
}