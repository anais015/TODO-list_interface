package appli.todolist_interface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

import java.net.URL;
import java.util.ResourceBundle;

public class CrudController {

    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[][] colonnes = {
                {"id_liste", "id_liste"},
                {"Nom_liste", "nom"},
                {"id_tache", "id_tache"},
                {"Nom_tache", "nom"},
                {"Description", "Description"},
                {"id_type", "id_type"},
                {"Nom_type", "nom"}
        };
    }
    @FXML
    private Button ajouter;

    @FXML
    private Button deconnexion;

    @FXML
    private TableColumn<?, ?> description;

    @FXML
    private ComboBox<?> filter;

    @FXML
    private TableColumn<?, ?> id_liste;

    @FXML
    private TableColumn<?, ?> id_tache;

    @FXML
    private TableColumn<?, ?> id_type;

    @FXML
    private Button modifier;

    @FXML
    private Label nbliste;

    @FXML
    private Label nbtache;

    @FXML
    private TableColumn<?, ?> nom_liste;

    @FXML
    private TableColumn<?, ?> nom_tache;

    @FXML
    private TableColumn<?, ?> nom_type;

    @FXML
    private Button supprimer;

    @FXML
    void ajouter(ActionEvent event) {

    }

    @FXML
    void deconnexion(ActionEvent event) {
        HelloApplication.changeScene("/appli/todolist_interface/deco");
    }

    @FXML
    void filter_par(ActionEvent event) {

    }

    @FXML
    void modifier(ActionEvent event) {

    }

    @FXML
    void supprimer(ActionEvent event) {

    }

}
