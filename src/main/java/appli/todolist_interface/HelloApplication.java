package appli.todolist_interface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {

    private static Stage stage;
    private static FXMLLoader fxmlLoader;

    @Override
    public void start(Stage FirstStage) throws IOException {
        stage = FirstStage;

       // String musicFile = "village_cocorico.mp3";
       // Media sound = new Media(new File(musicFile).toURI().toString());
       // MediaPlayer mediaPlayer = new MediaPlayer(sound);
       // mediaPlayer.play();

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/appli/todolist_interface/intro.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("TODO-list");

        //stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/resource/img/bloc-notes.webp"))));

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static void changeScene(String fxml, Object controleur) {
        //étape 1
        stage.close();
        try {
            //étape 2
            fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml+".fxml"));
            //étape 3 ? car copier-coller de l'extrême

            //étape 4
            fxmlLoader.setController(controleur);
            stage.setTitle("TODO-list");
            //étape 5
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.err.println(String.format("Error: %s", e.getMessage()));
        }
    }
    public static void changeScene(String fxml) {
        //étape 1
        stage.close();
        try {
            //étape 2
            fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml+".fxml"));
            //étape 3 ? car copier-coller de l'extrême

            //étape 4
            //fxmlLoader.setController(controleur);
            stage.setTitle("TODO-list");
            //étape 5
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.err.println(String.format("Error: %s", e.getMessage()));
        }
    }

    public static void newStage(String fxml, Object controller){
        Stage window = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml+".fxml"));
        fxmlLoader.setController(controller);
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        window.setTitle("TODO-list");
        window.setScene(scene);
        window.show();
    }

}