package appli.todolist_interface.liste;

import appli.todolist_interface.HelloApplication;
import appli.todolist_interface.todo.CrudController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modele.Liste;

public class AjouterListeController {

    @FXML
    private Button ajouter;

    @FXML
    private TextField nom;

    @FXML
    private Button retour;

    @FXML
    void ajouter(ActionEvent event) {
        if (nom.getText().isEmpty()) {
            System.out.println("erreur...");
            if (nom.getText().isEmpty()) {
                System.out.println("Il manque le nom...");

                nom.setStyle("-fx-text-box-border: red;");
            } else {
                nom.setStyle("");

            }
        }else{
            Liste liste = new Liste(nom.getText());
            liste.ajouterListe();
            nom.setStyle("");
            System.out.println("Changement effectué");
            nom.getScene().getWindow().hide();
            HelloApplication.changeScene("/appli/todolist_interface/crud", new CrudController());
        }

    }

    @FXML
    void retour(ActionEvent event) {
        ajouter.getScene().getWindow().hide();
        HelloApplication.changeScene("/appli/todolist_interface/hello-view");
    }

}
