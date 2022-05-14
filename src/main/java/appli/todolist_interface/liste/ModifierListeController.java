package appli.todolist_interface.liste;

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

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ModifierListeController implements Initializable {

    @FXML
    private ComboBox<Liste> id_liste;

    @FXML
    private TextField id;

    @FXML
    private TextField nom;

    @FXML
    private Button modifier;

    @FXML
    private Button retour;

    @FXML
    void select(ActionEvent event) {
        Liste ll = new Liste();
        String s = id_liste.getSelectionModel().getSelectedItem().toString();
        id.setText(String.valueOf(id_liste.getValue()));
        nom.setText(String.valueOf(id_liste.getValue()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Liste l = new Liste();
        id_liste.getItems().addAll(FXCollections.observableArrayList(l.afficherListe()));
    }

    @FXML
    void modifier(ActionEvent event) throws SQLException {
        if (nom.getText().isEmpty() || id.getText().isEmpty()) {
            System.out.println("erreur...");
            if (id.getText().isEmpty()) {
                System.out.println("Il manque l'id de la liste...");

                id.setStyle("-fx-text-box-border: red;");
            } else {
                id.setStyle("");

            }
            if (nom.getText().isEmpty()) {
                System.out.println("Il manque le nom...");

                nom.setStyle("-fx-text-box-border: red;");
            } else {
                nom.setStyle("");

            }
        }else{
        Liste liste = new Liste(nom.getText(), Integer.parseInt(id.getText())); //converti un texte en chiffre
        liste.modifierListe();
        id.setStyle("");
        nom.setStyle("");
        System.out.println("Changement effectué");
        nom.getScene().getWindow().hide();
        HelloApplication.changeScene("/appli/todolist_interface/crud", new CrudController());
        }
    }

    @FXML
    void retour(ActionEvent event) {
        nom.getScene().getWindow().hide();
        HelloApplication.changeScene("/appli/todolist_interface/crud", new CrudController());

    }
}
