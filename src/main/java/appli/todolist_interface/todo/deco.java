package appli.todolist_interface.todo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import static javafx.application.Platform.exit;

public class deco {
    @FXML
    private Button OK;

    @FXML
    void fermer(ActionEvent event) {
        exit();
    }

}