package appli.todolist_interface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modele.Utilisateur;

public class HelloController {

    Utilisateur user = new Utilisateur();

    @FXML
    private Button Connecter;

    @FXML
    private Button Inscrire;

    @FXML
    private Button Quitter;

    @FXML
    private TextField email;

    @FXML
    private TextField mdp;

    @FXML
    void Connexion(ActionEvent event) {
        if (email.getText().isEmpty() || mdp.getText().isEmpty()){
            System.out.println("erreur...");
            if(email.getText().isEmpty()){
                System.out.println("Il manque l'email...");

                email.setStyle("-fx-text-box-border: red;");
            }else{
                email.setStyle("");

            }
            if(mdp.getText().isEmpty()){
                System.out.println("Il manque le mot de passe...");

                mdp.setStyle("-fx-text-box-border: red;");
            }else{
                mdp.setStyle("");

            }
        }else{
            //user.connexionUser(email.getText(), mdp.getText());
            mdp.setStyle("");
            email.setStyle("");
            System.out.println("OK !");// ça fonctionne :-)
            HelloApplication.changeScene("/appli/todolist_interface/crud", new CrudController());//ça fonctionne !
        }
    }

    @FXML
    void Inscription(ActionEvent event) {
        HelloApplication.changeScene("/appli/todolist_interface/inscription", new InscriptionController());
    }

    @FXML
    void Quitter(ActionEvent event) {
        HelloApplication.changeScene("/appli/todolist_interface/deco", new deco());
    }
}