package com.example.movieverse;

import java.util.List;

/**
 * A class representing a user with their details and movie preferences.
 */
public class User {

    private final String name; // The name of the user
    private final int age; // The age of the user
    private String[] genres; // The user's favorite movie genres
    private List<Movie> recommendedMovies; // List of recommended movies for the user

    /**
     * Constructor to create a new User object.
     *
     * @param name The name of the user
     * @param age The age of the user
     * @param genres The user's favorite movie genres
     */
    public User(String name, int age, String[] genres) {
        this.name = name;
        this.age = age;
        this.genres = genres;
    }

    /**
     * Gets the name of the user.
     *
     * @return The name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the age of the user.
     *
     * @return The age of the user
     */
    public int getAge() {
        return age;
    }

    /**
     * Gets the user's favorite movie genres.
     *
     * @return The user's favorite movie genres
     */
    public String[] getGenres() {
        return genres;
    }

    /**
     * Gets the list of recommended movies for the user.
     *
     * @return The list of recommended movies for the user
     */
    public List<Movie> getRecommendedMovies() {
        return recommendedMovies;
    }

    /**
     * Adds a movie to the list of recommended movies for the user.
     *
     * @param movie The movie to add to the recommended list
     */
    public void addMovie(Movie movie) {
        this.recommendedMovies.add(movie);
    }

    /**
     * Sets the user's favorite movie genres.
     *
     * @param genres The new user's favorite movie genres
     */
    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    /**
     * Sets the list of recommended movies for the user.
     *
     * @param recommendedMovies The new list of recommended movies for the user
     */
    public void setRecommendedMovies(List<Movie> recommendedMovies) {
        this.recommendedMovies = recommendedMovies;
    }

    /**
     * Generates the user's data in a format suitable for saving in a file.
     *
     * @return The user's data formatted for file entry
     */
    public String getFileEntryFormat() {
        StringBuilder temp = new StringBuilder(this.name + "," + this.age + ", ");
        for (String genre : this.genres) {
            temp.append(genre).append(" ");
        }
        return temp.toString().trim();
    }
}
