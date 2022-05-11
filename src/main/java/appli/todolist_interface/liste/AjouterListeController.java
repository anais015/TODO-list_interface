package appli.todolist_interface.liste;

import appli.todolist_interface.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AjouterListeController {

    @FXML
    private Button ajouter;

    @FXML
    private TextField nom;

    @FXML
    private Button retour;

    @FXML
    void ajouter(ActionEvent event) {

    }

    @FXML
    void retour(ActionEvent event) {
        ajouter.getScene().getWindow().hide();
        HelloApplication.changeScene("/appli/todolist_interface/hello-view");
    }

}
