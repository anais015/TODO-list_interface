package appli.todolist_interface;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modele.Utilisateur;

public class InscriptionController {

    Utilisateur user = new Utilisateur();

    @FXML
    private TextField confirmer;

    @FXML
    private TextField email;

    @FXML
    private Button inscrire;

    @FXML
    private TextField mdp;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private Button retour;

    @FXML
    void inscription(ActionEvent event) throws Exception {
        if (email.getText().isEmpty() || mdp.getText().isEmpty() || nom.getText().isEmpty()
                || prenom.getText().isEmpty() || confirmer.getText().isEmpty()){
            System.out.println("Il manque quelque chose ...");
            if(email.getText().isEmpty()){
                System.out.println("Il manque l'email...");

                email.setStyle("-fx-text-box-border: red;");
            }else{
                email.setStyle("");

            }
            if(nom.getText().isEmpty()){
                System.out.println("Il manque le nom ...");

                nom.setStyle("-fx-text-box-border: red;");
            }else{
                nom.setStyle("");

            }
            if(confirmer.getText().isEmpty()){
                System.out.println("Vous n'avez pas confirmé le mot de passe ...");

                confirmer.setStyle("-fx-text-box-border: red;");
            }else{
                confirmer.setStyle("");

            }
            if(prenom.getText().isEmpty()){
                System.out.println("Il manque le prénom ...");

                prenom.setStyle("-fx-text-box-border: red;");
            }else{
                prenom.setStyle("");

            }
            if(mdp.getText().isEmpty()){
                System.out.println("Il manque le mot de passe...");

                mdp.setStyle("-fx-text-box-border: red;");
            }else{
                mdp.setStyle("");

            }
            if (!mdp.getText().equals(confirmer.getText())){
                System.out.println("Ce n'est pas le même mot de passe");
            }
        }else{
            user.inscription(nom.getText(), prenom.getText(), email.getText(), mdp.getText());
            mdp.setStyle("");
            email.setStyle("");
            nom.setStyle("");
            prenom.setStyle("");
            confirmer.setStyle("");
            System.out.println("OK !");
            HelloApplication.changeScene("/appli/todolist_interface/crud",new CrudController());//mais pas ça !
        }
    }

    @FXML
    void retour(ActionEvent event) {
        prenom.getScene().getWindow().hide();
        HelloApplication.changeScene("/appli/todolist_interface/hello-view");
    }
}
