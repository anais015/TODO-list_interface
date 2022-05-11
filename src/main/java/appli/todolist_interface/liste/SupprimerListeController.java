package appli.todolist_interface.liste;

import appli.todolist_interface.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class SupprimerListeController {

    @FXML
    private ComboBox<?> id;

    @FXML
    private Button retour;

    @FXML
    private Button supprimer;

    @FXML
    void retour(ActionEvent event) {
        retour.getScene().getWindow().hide();
        HelloApplication.changeScene("/appli/todolist_interface/hello-view");
    }

    @FXML
    void supprimer(ActionEvent event) {

    }
}
