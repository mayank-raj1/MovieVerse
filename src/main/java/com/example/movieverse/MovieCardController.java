package com.example.movieverse;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * The controller class for individual movie cards in the MovieVerse application.
 */
public class MovieCardController {

    @FXML
    private ImageView movieImage; // Image view for the movie's poster

    @FXML
    private Label movieNameLabel; // Label for displaying the movie's name

    @FXML
    private Label yearLabel; // Label for displaying the movie's year of release

    @FXML
    private Label ratingLabel; // Label for displaying the movie's rating

    @FXML
    private Label genresLabel; // Label for displaying the movie's genres

    @FXML
    private VBox imageContainer; // Container for the movie's image

    @FXML
    private HBox infoContainer; // Container for the movie's information

    /**
     * Sets the information for the movie card.
     *
     * @param name      The name of the movie
     * @param year      The year of release of the movie
     * @param rating    The rating of the movie
     * @param genres    The genres of the movie
     * @param imageUrl  The URL of the movie's image
     */
    public void setMovieInfo(String name, String year, String rating, String genres, String imageUrl) {
        movieNameLabel.setText(name);
        yearLabel.setText(year);
        ratingLabel.setText("Rating: " + rating);
        genresLabel.setText(genres);

        try {
            Image image = new Image(getClass().getResource(imageUrl).toExternalForm());
            movieImage.setImage(image);
            // Optionally, you can adjust the container heights to match the content
            imageContainer.setPrefHeight(movieImage.getFitHeight());
        } catch (Exception e) {
            Image image = new Image(getClass().getResource("/com/example/movieverse/images/avengers.jpg").toExternalForm());
            movieImage.setImage(image);
            // Optionally, you can adjust the container heights to match the content
            imageContainer.setPrefHeight(movieImage.getFitHeight());
        }
        infoContainer.setPrefHeight(Math.max(movieNameLabel.getHeight(), yearLabel.getHeight()));
    }
}
