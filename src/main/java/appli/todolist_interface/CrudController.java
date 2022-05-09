package appli.todolist_interface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
                {"estTerminee", "estTerminee"},
                {"deadline", "deadline"},

                {"id_type", "id_type"},
                {"Nom_type", "nom"}
        };
    }

    @FXML
    private Button ajouterliste;

    @FXML
    private Button ajoutertache;

    @FXML
    private Button ajoutertype;

    @FXML
    private Button deconnexion;

    @FXML
    private TableColumn<?, ?> description;

    @FXML
    private TableColumn<?, ?> deadline;

    @FXML
    private TableColumn<?, ?> estTerminee;

    @FXML
    private TableColumn<?, ?> id_liste;

    @FXML
    private TableColumn<?, ?> id_tache;

    @FXML
    private TableColumn<?, ?> id_type;

    @FXML
    private Button modifierliste;

    @FXML
    private Button modifiertache;

    @FXML
    private Button modifiertype;

    @FXML
    private Label nbliste;

    @FXML
    private Label nbtache;

    @FXML
    private Label nbtype;

    @FXML
    private TableColumn<?, ?> nom_liste;

    @FXML
    private TableColumn<?, ?> nom_tache;

    @FXML
    private TableColumn<?, ?> nom_type;

    @FXML
    private Button supprimerliste;

    @FXML
    private Button supprimertache;

    @FXML
    private Button supprimertype;

    @FXML
    private TableView<?> tabliste;

    @FXML
    private TableView<?> tabtache;

    @FXML
    private TableView<?> tabtype;

    @FXML
    void ajouterliste(ActionEvent event) {

    }

    @FXML
    void ajoutertache(ActionEvent event) {
        HelloApplication.changeScene("/appli/todolist_interface/ajouter", new AjouterTacheController());
    }

    @FXML
    void ajoutertype(ActionEvent event) {

    }

    @FXML
    void modifierliste(ActionEvent event) {

    }

    @FXML
    void modifiertache(ActionEvent event) {
        HelloApplication.changeScene("/appli/todolist_interface/modifier", new ModifierTacheController());
    }

    @FXML
    void modifiertype(ActionEvent event) {

    }

    @FXML
    void supprimerliste(ActionEvent event) {

    }

    @FXML
    void supprimertache(ActionEvent event) {
        HelloApplication.changeScene("/appli/todolist_interface/supprimer", new SupprimerTacheController());
    }

    @FXML
    void supprimertype(ActionEvent event) {

    }
    @FXML
    void deconnexion(ActionEvent event) {
        HelloApplication.changeScene("/appli/todolist_interface/deco", new deco());
    }

}
