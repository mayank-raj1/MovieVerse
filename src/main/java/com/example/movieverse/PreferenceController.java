package com.example.movieverse;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * The controller class for the user preferences view of the MovieVerse application.
 */
public class PreferenceController {

    @FXML
    public Button movies; // Button to navigate to the movies view

    @FXML
    private CheckBox scifiCkBx; // CheckBox for the "Sci-Fi" genre

    @FXML
    private CheckBox actionCkBx;

    @FXML
    private CheckBox dramaCkBx;

    @FXML
    private CheckBox crimeCkBx;

    @FXML
    private CheckBox thrillerCkBx;

    @FXML
    private CheckBox romananceCkBx;

    @FXML
    private CheckBox adventureChBx;

    @FXML
    private CheckBox fantasyChBx;

    @FXML
    private CheckBox animationChBx;

    @FXML
    private CheckBox biographyCkBx;

    @FXML
    private CheckBox comedyCkBx;

    @FXML
    private CheckBox mysteryCkBx;

    @FXML
    private CheckBox warCkBx;

    @FXML
    private Button savePrefer; // Button to save user preferences

    /**
     * Handles the "Back to Movies" button click event.
     * Redirects the user to the movies view.
     */
    @FXML
    public void out() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("movies.fxml"));
            Parent root = fxmlLoader.load();
            Stage currentStage = (Stage) movies.getScene().getWindow();
            Scene scene = new Scene(root);
            currentStage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Handles the "Save Preferences" button click event.
     * Modifies the user's preference file and updates movie recommendations.
     */
    public void savePrefer() {
        modifyFile();
        updateRecommendations();
    }

    /**
     * Updates the movie recommendations after saving preferences.
     */
    private void updateRecommendations() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("movies.fxml"));

        try {
            Parent root = loader.load();
            MoviesController sampleController = loader.getController();
            sampleController.loadMovies();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Modifies the user's preference file based on the selected genres.
     */
    private void modifyFile() {
        try {
            Scanner scanner = new Scanner(new File("src/main/java/com/example/movieverse/files/user.txt"));
            String[] userDetails = scanner.nextLine().split(",");
            userDetails[2] = getFormattedData();
            scanner.close();

            FileWriter fileWriter = new FileWriter("src/main/java/com/example/movieverse/files/user.txt", false);
            fileWriter.write(userDetails[0] + "," + userDetails[1] + "," + userDetails[2]);
            if (userDetails[2].length() == 0) {
                fileWriter.write(userDetails[0] + "," + userDetails[1] + "," + "Action");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("File error occurred");
        }
    }

    /**
     * Formats the selected genres for saving in the preference file.
     *
     * @return The formatted selected genres
     */
    private String getFormattedData() {
        StringBuilder selectedGenres = new StringBuilder();

        CheckBox[] checkBoxes = {
                scifiCkBx, actionCkBx, dramaCkBx, crimeCkBx, thrillerCkBx,
                romananceCkBx, adventureChBx, fantasyChBx, animationChBx,
                biographyCkBx, comedyCkBx, mysteryCkBx, warCkBx
        };

        for (CheckBox checkBox : checkBoxes) {
            if (checkBox.isSelected()) {
                selectedGenres.append(checkBox.getText()).append(" ");
            }
        }

        return selectedGenres.toString().strip();
    }

    /**
     * Handles the "Go to Recommended" button click event.
     * Redirects the user to the movies view showing recommended movies.
     *
     * @param actionEvent The ActionEvent triggered by clicking the button
     */
    public void goToRecommended(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("movies.fxml"));

        try {
            Parent root = loader.load();
            MoviesController sampleController = loader.getController();
            sampleController.loadMovies();

            Stage currentStage = (Stage) movies.getScene().getWindow();

            Scene scene = new Scene(root);
            currentStage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}