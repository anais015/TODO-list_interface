package appli.todolist_interface.tache;

import appli.todolist_interface.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AjouterTacheController {

    @FXML
    private Button ajouter;

    @FXML
    private ComboBox<?> choix_liste;

    @FXML
    private ComboBox<?> choix_type;

    @FXML
    private TextField date;

    @FXML
    private TextArea description;

    @FXML
    private TextField nom;

    @FXML
    private Button retour;

    @FXML
    void ajouter(ActionEvent event) {

    }

    @FXML
    void choix_liste(ActionEvent event) {

    }

    @FXML
    void choix_type(ActionEvent event) {

    }

    @FXML
    void retour(ActionEvent event) {
        nom.getScene().getWindow().hide();
        HelloApplication.changeScene("/appli/todolist_interface/hello-view");
    }
}
