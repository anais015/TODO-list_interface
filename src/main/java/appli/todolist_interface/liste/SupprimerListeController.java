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

public class SupprimerListeController implements Initializable {

    @FXML
    private ComboBox<Liste> id;

    @FXML
    private TextField id_liste;

    @FXML
    private Button retour;

    @FXML
    private Button supprimer;

    @FXML
    void select(ActionEvent event) {
        Liste ll = new Liste();
        String s = id.getSelectionModel().getSelectedItem().toString();
        id_liste.setText(String.valueOf(id.getValue()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Liste l = new Liste();
        id.getItems().addAll(FXCollections.observableArrayList(l.afficherListe()));

    }

    @FXML
    void retour(ActionEvent event) {
        retour.getScene().getWindow().hide();
        HelloApplication.changeScene("/appli/todolist_interface/crud", new CrudController());
    }

    @FXML
    void supprimer(ActionEvent event) throws SQLException {
        if (id_liste.getText().isEmpty()) {
            if (id_liste.getText().isEmpty()) {
                System.out.println("Il manque l'id de la liste...");

                id.setStyle("-fx-text-box-border: red;");
            } else {
                id.setStyle("");

            }
        }else{
            Liste liste = new Liste(Integer.parseInt(id_liste.getText())); //converti un texte en chiffre
            liste.supprimerListe();
            id.setStyle("");
            System.out.println("Changement effectué");
            id.getScene().getWindow().hide();
            HelloApplication.changeScene("/appli/todolist_interface/crud", new CrudController());
        }
    }
}
