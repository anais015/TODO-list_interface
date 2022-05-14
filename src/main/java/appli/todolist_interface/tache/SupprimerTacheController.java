package appli.todolist_interface.tache;

import appli.todolist_interface.HelloApplication;
import appli.todolist_interface.todo.CrudController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import modele.Liste;
import modele.Tache;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SupprimerTacheController implements Initializable {

    @FXML
    private TextField id;

    @FXML
    private ComboBox<Tache> id_tache;

    @FXML
    private Button retour;

    @FXML
    private Button supprimer;

    @FXML
    void select(ActionEvent event) {
        Tache tt = new Tache();
        String s = id_tache.getSelectionModel().getSelectedItem().toString();
        id.setText(String.valueOf(id_tache.getValue()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Tache t = new Tache();
        id_tache.getItems().addAll(FXCollections.observableArrayList(t.afficherTache()));
    }

    @FXML
    void retour(ActionEvent event) {
        retour.getScene().getWindow().hide();
        HelloApplication.changeScene("/appli/todolist_interface/crud", new CrudController());
    }

    @FXML
    void supprimer(ActionEvent event) throws SQLException {
        if (id.getText().isEmpty()) {
            if (id.getText().isEmpty()) {
                System.out.println("Il manque l'id de la liste...");

                id.setStyle("-fx-text-box-border: red;");
            } else {
                id.setStyle("");

            }
        }else{
            Tache tache = new Tache(Integer.parseInt(id.getText())); //converti un texte en chiffre
            tache.supprimerTache();
            id.setStyle("");
            System.out.println("Changement effectué");
            id.getScene().getWindow().hide();
            HelloApplication.changeScene("/appli/todolist_interface/crud", new CrudController());
        }
    }
}
