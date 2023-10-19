package com.example.movieverse;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 * A class responsible for managing user data and recommendations.
 */
public class UserManager {

    private User user; // The current user
    private Scanner userFileReader; // Scanner for reading user data from a file
    private File userFile; // File containing user data

    /**
     * Constructor to initialize the user manager.
     * Reads user data from a file and creates a User object.
     */
    public UserManager() {
        this.userFile = new File("src/main/java/com/example/movieverse/files/user.txt");
        try {
            this.userFileReader = new Scanner(userFile);
            String[] userDetails = userFileReader.nextLine().split(",");
            this.user = new User(userDetails[0], Integer.parseInt(userDetails[1]), userDetails[2].split(" "));
            userFileReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets the genres of the current user.
     *
     * @return The user's favorite movie genres
     */
    public String[] getUserGenres() {
        return user.getGenres();
    }

    /**
     * Sets the recommended movies for the current user.
     *
     * @param recommendedMovies The list of recommended movies for the user
     */
    public void setUserRecommendedMovies(List<Movie> recommendedMovies) {
        user.setRecommendedMovies(recommendedMovies);
    }

    /**
     * Gets the recommended movies for the current user.
     *
     * @return The list of recommended movies for the user
     */
    public List<Movie> getUserRecommendedMovies() {
        return user.getRecommendedMovies();
    }
}
