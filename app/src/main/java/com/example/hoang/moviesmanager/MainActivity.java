package com.example.hoang.moviesmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.hoang.moviesmanager.databases.MovieDatabase;
import com.example.hoang.moviesmanager.databases.models.Movie;
import com.example.hoang.moviesmanager.databases.models.MoviesAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    MoviesAdapter moviesAdapter;

    MovieDatabase movieDatabase;
    List<Movie> movies = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movieDatabase = new MovieDatabase(this);
        listView = (ListView) findViewById(R.id.list_view);
        movies = movieDatabase.loadMoviesDatabase();
        moviesAdapter = new MoviesAdapter(this,R.layout.list_element,movies);
        listView.setAdapter(moviesAdapter);
        listView.setSmoothScrollbarEnabled(true);
//        for (Movie el : movies){
//            el.toString();
//        }
    }
}
