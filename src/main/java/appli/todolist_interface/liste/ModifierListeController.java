package appli.todolist_interface.liste;

import appli.todolist_interface.HelloApplication;
import appli.todolist_interface.todo.CrudController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import modele.Liste;
import modele.Utilisateur;

import java.net.URL;
import java.util.ResourceBundle;

public class ModifierListeController implements Initializable {

    @FXML
    private ComboBox<Liste> id_liste;

    @FXML
    private TextField nom;

    @FXML
    private Button modifier;

    @FXML
    private Button retour;

    @FXML
    void select(ActionEvent event) {
        String s = id_liste.getSelectionModel().getSelectedItem().toString();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Liste l = new Liste();
        id_liste.getItems().addAll(FXCollections.observableArrayList(l.afficherListe()));
//        id_liste.getItems().add(new Liste(1,"demo"));
//        id_liste.getItems().add(new Liste(2,"test"));
//        id_liste.getValue();
    }

    @FXML
    void modifier(ActionEvent event) {
        if (nom.getText().isEmpty() || id_liste.getId().isBlank()) {
            System.out.println("erreur...");
            if (id_liste.getId().isBlank()) {
                System.out.println("Il manque l'id de la liste...");

                id_liste.setStyle("-fx-text-box-border: red;");
            } else {
                id_liste.setStyle("");

            }
            if (nom.getText().isEmpty()) {
                System.out.println("Il manque le nom...");

                nom.setStyle("-fx-text-box-border: red;");
            } else {
                nom.setStyle("");

            }
        }else{
        //user.connexionUser(email.getText(), mdp.getText());
        id_liste.setStyle("");
        nom.setStyle("");
        System.out.println("Changement effectué");// ça fonctionne :-)
        HelloApplication.changeScene("/appli/todolist_interface/crud", new CrudController());//ça fonctionne !
        }
    }

    @FXML
    void retour(ActionEvent event) {
        id_liste.getScene().getWindow().hide();
        HelloApplication.changeScene("/appli/todolist_interface/CrudController");

    }
}
