package com.example.movieverse;

import java.util.List;

/**
 * A class representing the backend system that connects various components.
 */
public class BackendSystem {

    private RecommendationSystem recommendationSystem; // The recommendation system instance
    private UserManager userManager; // The user manager instance

    /**
     * Constructor to initialize the backend system.
     * Initializes the recommendation system and user manager, and sets user recommended movies.
     */
    public BackendSystem() {
        this.recommendationSystem = new RecommendationSystem();
        this.userManager = new UserManager();
        // Set user recommended movies based on user's genres
        this.userManager.setUserRecommendedMovies(this.recommendationSystem.recommendMovies(this.userManager.getUserGenres()));
    }

    /**
     * Gets the recommended movies for the current user.
     *
     * @return The list of recommended movies for the user
     */
    public List<Movie> getUserRecommendedMovies() {
        return userManager.getUserRecommendedMovies();
    }
}
