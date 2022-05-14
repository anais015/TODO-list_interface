package appli.todolist_interface.todo;

import appli.todolist_interface.HelloApplication;
import appli.todolist_interface.liste.AjouterListeController;
import appli.todolist_interface.liste.ModifierListeController;
import appli.todolist_interface.liste.SupprimerListeController;
import appli.todolist_interface.tache.AjouterTacheController;
import appli.todolist_interface.tache.ModifierTacheController;
import appli.todolist_interface.tache.SupprimerTacheController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.Liste;
import modele.Tache;
import modele.Type;

import java.net.URL;
import java.util.ResourceBundle;

public class CrudController implements Initializable {

    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[][] liliste = {
                {"id_liste", "id"},
                {"Nom_liste", "nom"}
        };

        String[][] tatache = {
                {"id_tâche", "id"},
                {"Nom_tâche", "nom"},
                {"description", "description"},
                {"estTerminée", "estTerminee"},
                {"deadline", "deadline"},
                {"ref_liste","ref_liste"},
                {"ref_type","ref_type"}
        };

        String[][] tytype = {
                {"id_type", "id"},
                {"Nom_type", "nom"}
        };

        for (int i = 0; i < liliste.length; i++) {
            TableColumn<Liste, String> myTable = new TableColumn<>(liliste[i][0]);
            myTable.setCellValueFactory(new PropertyValueFactory<Liste, String>(liliste[i][1]));
            tabliste.getColumns().add(myTable);
        }

        for (int i = 0; i < tatache.length; i++) {
        TableColumn<Tache, String> MyTable = new TableColumn<>(tatache[i][0]);
        MyTable.setCellValueFactory(new PropertyValueFactory<Tache, String>(tatache[i][1]));
        tabtache.getColumns().add(MyTable);
        }

        for (int i = 0; i < tytype.length; i++) {
            TableColumn<Type,String> METable= new TableColumn<>(tytype[i][0]);
            METable.setCellValueFactory(new PropertyValueFactory<Type,String>(tytype[i][1]));
            tabtype.getColumns().add(METable);
        }

        Liste liste = new Liste();
        Tache tache = new Tache();
        Type type = new Type();

        tabliste.getItems().addAll(liste.afficherListe());
        tabtache.getItems().addAll(tache.afficherTache());
        tabtype.getItems().addAll(type.afficherType());

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
    private Button supprimerliste;

    @FXML
    private Button supprimertache;

    @FXML
    private Button supprimertype;

    @FXML
    private TableView<Liste> tabliste;

    @FXML
    private TableView<Tache> tabtache;

    @FXML
    private TableView<Type> tabtype;

    @FXML
    void ajouterliste(ActionEvent event) {
        HelloApplication.changeScene("/appli/todolist_interface/ajouterliste", new AjouterListeController());
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
        HelloApplication.changeScene("/appli/todolist_interface/modifierliste", new ModifierListeController());
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
        HelloApplication.changeScene("/appli/todolist_interface/supprimerliste", new SupprimerListeController());
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
