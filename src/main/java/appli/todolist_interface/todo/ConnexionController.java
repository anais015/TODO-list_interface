package appli.todolist_interface.todo;

import appli.todolist_interface.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import modele.Utilisateur;

public class ConnexionController {


    @FXML
    private Button Connecter;

    @FXML
    private Button Inscrire;

    @FXML
    private Button Quitter;

    @FXML
    private Label lblerreur;

    @FXML
    private TextField email;

    @FXML
    private PasswordField mdp;

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
            Utilisateur user = new Utilisateur(email.getText(),mdp.getText());
            user.connexion();
            if(user.getId() > 0){
            mdp.setStyle("");
            email.setStyle("");
            System.out.println("OK !");
            HelloApplication.changeScene("/appli/todolist_interface/crud", new CrudController());//ça fonctionne !
                 System.out.println("Utilisateur Connecté");
            }else{
                System.out.println("erreur");
                lblerreur.setText("erreur");
            }
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