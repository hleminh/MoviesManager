package com.example.hoang.moviesmanager.databases.models;

/**
 * Created by Hoang on 4/22/2017.
 */

public class Movie {
    String image;
    String name;
    String type;
    String rating;
    double imdbScore;
    boolean favorited;

    public Movie(String image, String name, String type, String rating, double imdbScore, boolean favorited) {
        this.image = image;
        this.name = name;
        this.type = type;
        this.rating = rating;
        this.imdbScore = imdbScore;
        this.favorited = favorited;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public double getImdbScore() {
        return imdbScore;
    }

    public void setImdbScore(double imdbScore) {
        this.imdbScore = imdbScore;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", rating='" + rating + '\'' +
                ", imdbScore=" + imdbScore +
                ", favorited=" + favorited +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
