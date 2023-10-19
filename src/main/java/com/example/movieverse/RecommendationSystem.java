package com.example.movieverse;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A recommendation system for suggesting movies based on user's favorite genres.
 */
public class RecommendationSystem {

    private File moviesFile; // File containing movie data
    private Scanner moviesFileReader; // Scanner for reading movie data from the file

    /**
     * Constructor to initialize the recommendation system.
     * Sets up the file and the reader for movie data.
     */
    public RecommendationSystem() {
        moviesFile = new File("src/main/java/com/example/movieverse/files/movies.txt");
        try {
            this.moviesFileReader = new Scanner(moviesFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Recommends movies based on the user's favorite genres.
     *
     * @param favGenres An array of favorite genres chosen by the user
     * @return A list of recommended movies
     */
    public List<Movie> recommendMovies(String[] favGenres) {
        List<Movie> movies = new ArrayList<>();
        while (moviesFileReader.hasNext()) {
            String[] movieDetails = moviesFileReader.nextLine().split(",");
            String[] genres = movieDetails[3].split(" ");
            if (contains(genres[0], favGenres)) {
                movies.add(makeMovie(movieDetails));
            } else if (contains(genres[1], favGenres)) {
                movies.add(makeMovie(movieDetails));
            }
        }
        moviesFileReader.close();
        try {
            this.moviesFileReader = new Scanner(moviesFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return movies;
    }

    /**
     * Checks if a genre is present in the user's favorite genres.
     *
     * @param genre The genre to check
     * @param userGenres The array of user's favorite genres
     * @return True if the genre is present, false otherwise
     */
    private boolean contains(String genre, String[] userGenres) {
        for (String userGenre : userGenres) {
            if (genre.equals(userGenre)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Creates a Movie object based on movie details.
     *
     * @param movieDetails Details of the movie
     * @return A Movie object
     */
    private Movie makeMovie(String[] movieDetails) {
        return new Movie(movieDetails[0], Integer.parseInt(movieDetails[1]),
                Double.parseDouble(movieDetails[2]), movieDetails[3].split(" "), movieDetails[4]);
    }
    //Sci-Fi, Action, Drama, Crime, Thriller, Romance, Adventure, Fantasy, Animation, Biography, Comedy, Mystery, War
}
