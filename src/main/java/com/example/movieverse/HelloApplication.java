package com.example.movieverse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The main class for the MovieVerse application.
 * This class extends the JavaFX Application class and serves as the entry point for the application.
 */
public class HelloApplication extends Application {

    private static Stage stg; // The main application stage
    private static BackendSystem backendSystem; // The backend system instance for the application

    /**
     * The main entry point of the application.
     * It launches the JavaFX application.
     *
     * @param args The command-line arguments
     */
    public static void main(String[] args) {
        launch();
    }

    /**
     * Start method of the JavaFX application.
     * Initializes the application stage, sets up the user interface, and displays the main scene.
     *
     * @param stage The primary stage for the application
     * @throws IOException If an I/O error occurs while loading the FXML file
     */
    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;

        // Load the log-in.fxml layout using FXMLLoader
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("log-in.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root, 716, 463);

        // Initialize the backend system
        backendSystem = new BackendSystem();

        stage.setTitle("MovieVerse");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Changes the scene of the application.
     *
     * @param fxml The path to the FXML file of the new scene
     * @throws IOException If an I/O error occurs while loading the FXML file
     */
    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }
}
