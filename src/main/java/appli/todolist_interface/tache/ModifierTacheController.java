package appli.todolist_interface.tache;

import appli.todolist_interface.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;
import javafx.util.converter.FormatStringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ModifierTacheController {

    @FXML
    private TextArea Description;

    @FXML
    private ComboBox<?> choix_liste;

    @FXML
    private ComboBox<?> choix_type;

    @FXML
    private DatePicker deadline;

    @FXML
    private ComboBox<?> estTerminee;

    @FXML
    private ComboBox<?> id;

    @FXML
    private Button modifier;

    @FXML
    private TextField nom;

    @FXML
    private Button retour;

    @FXML
    void modifier(ActionEvent event) {
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
    void retour(ActionEvent event) {
        modifier.getScene().getWindow().hide();
        HelloApplication.changeScene("/appli/todolist_interface/hello-view");
    }
}
