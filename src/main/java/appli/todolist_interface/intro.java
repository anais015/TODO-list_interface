package appli.todolist_interface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class intro {
    @FXML
    private Button commencer;

    @FXML
    void commencer(ActionEvent event) {
        HelloApplication.changeScene("/appli/todolist_interface/hello-view");
    }

}
