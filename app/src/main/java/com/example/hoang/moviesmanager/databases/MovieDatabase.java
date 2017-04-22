package com.example.hoang.moviesmanager.databases;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.hoang.moviesmanager.databases.models.Movie;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hoang on 4/22/2017.
 */

public class MovieDatabase extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "movies.db";
    private static final int DATABASE_VERSION = 1;

    private static final String MOVIE_IMAGE = "image";
    private static final String MOVIE_NAME = "name";
    private static final String MOVIE_RATING = "rating";
    private static final String MOVIE_SCORE = "imdb_score";
    private static final String MOVIE_FAVORITED = "favorited";
    private static final String MOVIE_TYPE = "type";

    private static final String[] query = {
            MOVIE_IMAGE, MOVIE_NAME, MOVIE_TYPE, MOVIE_RATING, MOVIE_SCORE, MOVIE_FAVORITED
    };


    public MovieDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public List<Movie> loadMoviesDatabase() {
        List<Movie> movies = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("tbl_movies", query, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String image = cursor.getString(cursor.getColumnIndex(MOVIE_IMAGE));
            String name = cursor.getString(cursor.getColumnIndex(MOVIE_NAME));
            String rating = cursor.getString(cursor.getColumnIndex(MOVIE_RATING));
            String type = cursor.getString(cursor.getColumnIndex(MOVIE_TYPE));
            Double score = cursor.getDouble(cursor.getColumnIndex(MOVIE_SCORE));
            boolean favorited = cursor.getInt(cursor.getColumnIndex(MOVIE_NAME)) != 0;
            Movie movie = new Movie(image, name, type, rating, score, favorited);
            movies.add(movie);
        }
        return movies;
    }
}
