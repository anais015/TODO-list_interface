package appli.todolist_interface.liste;

import appli.todolist_interface.HelloApplication;
import appli.todolist_interface.todo.CrudController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ModifierListeController {

    @FXML
    private ComboBox<?> id_liste;

    @FXML
    private TextField nom;

    @FXML
    private Button modifier;

    @FXML
    private Button retour;

    @FXML
    void modifier(ActionEvent event) {
        if (nom.getText().isEmpty() || id_liste.getId().isEmpty()) {
            System.out.println("erreur...");
            if (id_liste.getId().isEmpty()) {
                System.out.println("Il manque l'email...");

                id_liste.setStyle("-fx-text-box-border: red;");
            } else {
                id_liste.setStyle("");

            }
            if (nom.getText().isEmpty()) {
                System.out.println("Il manque l'email...");

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
        retour.getScene().getWindow().hide();
        HelloApplication.changeScene("/appli/todolist_interface/CrudController");

    }
}
