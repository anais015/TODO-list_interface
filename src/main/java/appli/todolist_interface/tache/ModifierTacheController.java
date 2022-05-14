package appli.todolist_interface.tache;

import appli.todolist_interface.HelloApplication;
import appli.todolist_interface.todo.CrudController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.StringConverter;
import javafx.util.converter.FormatStringConverter;
import modele.Liste;
import modele.Tache;
import modele.Type;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ModifierTacheController implements Initializable {

    @FXML
    private TextArea Description;

    @FXML
    private TextField deadline2;

    @FXML
    private TextField estTerminee;

    @FXML
    private TextField id;

    @FXML
    private ComboBox<Tache> EstTerminee;

    @FXML
    private ComboBox<Tache> id_tache;

    @FXML
    private Button modifier;

    @FXML
    private TextField nom;

    @FXML
    private ComboBox<Liste> ref_liste_cb;

    @FXML
    private ComboBox<Type> ref_type_cb;

    @FXML
    private DatePicker deadline;

    @FXML
    private TextField ref_liste;

    @FXML
    private TextField ref_type;

    @FXML
    private Button retour;

    @FXML
    void selectEstTerminee(ActionEvent event) {

    }

    @FXML
    void selectListe(ActionEvent event) {
        Liste ll = new Liste();
        String s = ref_liste_cb.getSelectionModel().getSelectedItem().toString();
        ref_liste.setText(String.valueOf(ref_liste_cb.getValue()));
    }

    @FXML
    void selectTache(ActionEvent event) {
        Tache tache = new Tache();
        String s = id_tache.getSelectionModel().getSelectedItem().toString();
        id.setText(String.valueOf(id_tache.getValue()));
        nom.setText(String.valueOf(id_tache.getValue()));
    }

    @FXML
    void selectType(ActionEvent event) {

    }

    @FXML
    void selectdate(ActionEvent event) {
        String pattern = "yyyy-MM-dd"; // pour modifier le format de la date
        deadline.setPromptText(pattern.toLowerCase());
        deadline.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
            @Override
            public String toString(LocalDate localDate) {
                if (localDate != null) {
                    return dateFormatter.format(localDate);
                } else {
                    return "";
                }
            }
            @Override
            public LocalDate fromString(String s) {
                if (s != null && !s.isEmpty()) {
                    return LocalDate.parse(s, dateFormatter);
                } else {
                    return null;
                }
            }
        });

    }
    @FXML
    void modifier(ActionEvent event) throws SQLException {
        if (nom.getText().isEmpty() || id.getText().isEmpty() || deadline2.getText().isEmpty()
                || ) {
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
            Tache tache = new Tache(nom.getText(), Description.getText(),
                    deadline2.getText(), estTerminee.getText(), ref_liste.getText(),
                    ref_type.getText(), Integer.parseInt(id.getText())); //converti un texte en chiffre
            tache.modifierTache();
            id.setStyle("");
            nom.setStyle("");
            System.out.println("Changement effectué");
            nom.getScene().getWindow().hide();
            HelloApplication.changeScene("/appli/todolist_interface/crud", new CrudController());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Liste l = new Liste();
        ref_liste_cb.getItems().addAll(FXCollections.observableArrayList(l.afficherListe()));
        Tache t = new Tache();
        id_tache.getItems().addAll(FXCollections.observableArrayList(t.afficherTache()));
        Type ty = new Type();
        ref_type_cb.getItems().addAll(FXCollections.observableArrayList(ty.afficherType()));
    }

    @FXML
    void retour(ActionEvent event) {
        modifier.getScene().getWindow().hide();
        HelloApplication.changeScene("/appli/todolist_interface/hello-view");
    }
}
