package com.example.movieverse;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import java.util.List;

/**
 * The controller class for the Movies view of the MovieVerse application.
 */
public class MoviesController {

    @FXML
    public Button preference; // Button to access user preferences

    @FXML
    private Button logOut; // Button to log out the user

    @FXML
    private Button movies; // Button to navigate to the movies view

    @FXML
    private FlowPane movieFlowPane; // Container for displaying movie cards

    BackendSystem backendSystem; // The backend system instance

    /**
     * Handles the "Log Out" button click event.
     * Redirects the user to the log-in view.
     */
    @FXML
    public void out() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("log-in.fxml"));
            Parent root = fxmlLoader.load();
            Stage currentStage = (Stage) preference.getScene().getWindow();

            Scene scene = new Scene(root);
            currentStage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Handles the "Preference" button click event.
     * Redirects the user to the preferences view.
     */
    public void goToPreference() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("preferences.fxml"));
            Parent root = fxmlLoader.load();
            Stage currentStage = (Stage) preference.getScene().getWindow();

            Scene scene = new Scene(root);
            currentStage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Loads and displays movies recommended for the user.
     */
    @FXML
    public void loadMovies() {
        backendSystem = new BackendSystem();
        addMovies(backendSystem.getUserRecommendedMovies());
    }

    /**
     * Adds movie cards to the UI based on a list of movies.
     *
     * @param movies The list of movies to display
     */
    private void addMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            movieFlowPane.getChildren().add(addMovieCard(movie.getName(), movie.getYearOfRelease(), movie.getStars(), movie.getGenres(), "/com/example/movieverse/images/" + movie.getUrl()));
        }
    }

    /**
     * Adds a single movie card to the UI with specified information.
     *
     * @param name      The name of the movie
     * @param year      The year of release of the movie
     * @param rating    The rating of the movie
     * @param genres    The genres of the movie
     * @param imageUrl  The URL of the movie's image
     * @return The Node representing the added movie card
     */
    @FXML
    private Node addMovieCard(String name, int year, String rating, String genres, String imageUrl) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("movie-card.fxml"));
            Node movieCard = loader.load();
            MovieCardController movieCardController = loader.getController();
            movieCardController.setMovieInfo(name, Integer.toString(year), rating, genres, imageUrl);
            return movieCard;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
