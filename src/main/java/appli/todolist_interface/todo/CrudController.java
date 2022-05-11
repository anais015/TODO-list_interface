package appli.todolist_interface.todo;

import appli.todolist_interface.HelloApplication;
import appli.todolist_interface.liste.ModifierListeController;
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
        for (int i = 0 ; i < colonnes.length ; i ++){
            TableColumn<Liste,String> myTable= new TableColumn<>(colonnes[i][0]);
            myTable.setCellValueFactory(new PropertyValueFactory<Liste,String>(colonnes[i][1]));
            tabliste.getColumns().add(myTable);

            TableColumn<Tache,String> MyTable= new TableColumn<>(colonnes[i][0]);
            MyTable.setCellValueFactory(new PropertyValueFactory<Tache,String>(colonnes[i][1]));
            tabtache.getColumns().add(MyTable);

            TableColumn<Type,String> MYTable= new TableColumn<>(colonnes[i][0]);
            MYTable.setCellValueFactory(new PropertyValueFactory<Type,String>(colonnes[i][1]));
            tabtype.getColumns().add(MYTable);
        }

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
    private TableView<Liste> tabliste;

    @FXML
    private TableView<Tache> tabtache;

    @FXML
    private TableView<Type> tabtype;

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
