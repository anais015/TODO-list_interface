package appli.todolist_interface.tache;

import appli.todolist_interface.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ModifierTacheController {

    @FXML
    private TextArea Description;

    @FXML
    private ComboBox<?> choix_liste;

    @FXML
    private ComboBox<?> choix_type;

    @FXML
    private TextField deadline;

    @FXML
    private ComboBox<?> estTerminee;

    @FXML
    private ComboBox<?> id;

    @FXML
    private Button modifier;

    @FXML
    private TextField nom;

    @FXML
    private Button retour;

    @FXML
    void modifier(ActionEvent event) {

    }

    @FXML
    void retour(ActionEvent event) {
        modifier.getScene().getWindow().hide();
        HelloApplication.changeScene("/appli/todolist_interface/hello-view");
    }
}
