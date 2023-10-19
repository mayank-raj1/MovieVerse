package com.example.movieverse;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * The controller class for the log-in functionality of the MovieVerse application.
 */
public class HelloController {

    @FXML
    private PasswordField password; // Password input field

    @FXML
    private Button register; // Button to register new users

    @FXML
    private Button signIn; // Button to initiate user sign-in

    @FXML
    private TextField username; // Username input field

    @FXML
    private Label wrongLogIn; // Label to display login status messages

    @FXML
    private ImageView logo; // Application logo image view

    /**
     * Handles the user log-in event.
     *
     * @param event The ActionEvent triggered by clicking the "Sign In" button
     * @throws IOException If an I/O error occurs during log-in
     */
    public void userLogIn(ActionEvent event) throws IOException {
        checkLogIn();
    }

    /**
     * Checks the provided log-in credentials and handles the log-in process.
     * If credentials are valid, switches to the movies view. Otherwise, displays an error message.
     *
     * @throws IOException If an I/O error occurs during the view switching process
     */
    private void checkLogIn() throws IOException {
        HelloApplication m = new HelloApplication(); // Note: This might not be necessary

        // Check if the provided username and password are valid
        if(username.getText().toString().equals("username") && password.getText().toString().equals("password")) {
            wrongLogIn.setText("Successfully Logged in!");

            FXMLLoader loader = new FXMLLoader(getClass().getResource("movies.fxml"));

            try {
                Parent root = loader.load();
                MoviesController sampleController = loader.getController();
                sampleController.loadMovies();

                Stage currentStage = (Stage) username.getScene().getWindow();

                Scene scene = new Scene(root);
                currentStage.setScene(scene);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if(username.getText().isEmpty() && password.getText().isEmpty()) {
            wrongLogIn.setText("Please enter username and password");
        } else {
            wrongLogIn.setText("Wrong username or password");
        }
    }
}
