package appli.todolist_interface.type;

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
import modele.Type;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SupprimerTypeController implements Initializable {

    @FXML
    private TextField id;

    @FXML
    private ComboBox<Type> id_type;

    @FXML
    private Button retour;

    @FXML
    private Button supprimer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Type t = new Type();
        id_type.getItems().addAll(FXCollections.observableArrayList(t.afficherType()));
    }

    @FXML
    void retour(ActionEvent event) {

    }

    @FXML
    void select(ActionEvent event) {
        Type tt = new Type();
        String s = id_type.getSelectionModel().getSelectedItem().toString();
        id.setText(String.valueOf(id_type.getValue()));
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
            Type type = new Type(Integer.parseInt(id.getText())); //converti un texte en chiffre
            type.supprimerType();
            id.setStyle("");
            System.out.println("Changement effectué");
            id.getScene().getWindow().hide();
            HelloApplication.changeScene("/appli/todolist_interface/crud", new CrudController());
        }
    }


}
