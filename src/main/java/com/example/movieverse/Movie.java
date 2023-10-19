package com.example.movieverse;

/**
 * A class representing a movie with its details.
 */
public class Movie {

    private String name; // The name of the movie
    private int yearOfRelease; // The year of release of the movie
    private double stars; // The star rating of the movie
    private String[] genres; // The genres of the movie
    private String url; // The URL of the movie's image

    /**
     * Constructor to create a new Movie object.
     *
     * @param name The name of the movie
     * @param yearOfRelease The year of release of the movie
     * @param stars The star rating of the movie
     * @param genres The genres of the movie
     * @param url The URL of the movie's image
     */
    public Movie(String name, int yearOfRelease, double stars, String[] genres, String url) {
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.stars = stars;
        this.genres = genres;
        this.url = url;
    }

    /**
     * Gets the name of the movie.
     *
     * @return The name of the movie
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the movie.
     *
     * @param name The new name for the movie
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the year of release of the movie.
     *
     * @return The year of release of the movie
     */
    public int getYearOfRelease() {
        return this.yearOfRelease;
    }

    /**
     * Sets the year of release of the movie.
     *
     * @param yearOfRelease The new year of release for the movie
     */
    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    /**
     * Gets the star rating of the movie.
     *
     * @return The star rating of the movie as a string
     */
    public String getStars() {
        return Double.toString(this.stars);
    }

    /**
     * Sets the star rating of the movie.
     *
     * @param stars The new star rating for the movie
     */
    public void setStars(double stars) {
        this.stars = stars;
    }

    /**
     * Gets the genres of the movie.
     *
     * @return The genres of the movie as a formatted string
     */
    public String getGenres() {
        return this.genres[0] + ", " + this.genres[1];
    }

    /**
     * Gets the URL of the movie's image.
     *
     * @return The URL of the movie's image
     */
    public String getUrl() {
        return this.url;
    }
}
