package com.example.hoang.moviesmanager.databases.models;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.StrictMode;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hoang.moviesmanager.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hoang on 4/22/2017.
 */

public class MoviesAdapter extends ArrayAdapter {
    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
    private Context context;
    private List<Movie> movies;
    private ArrayList<Bitmap> images;

    public MoviesAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Movie> movies) {
        super(context, resource, movies);
        StrictMode.setThreadPolicy(policy);
        this.context = context;
        this.movies = movies;
        images = new ArrayList<>();
        for (Movie movie : movies) {
            try {
                Bitmap bitmap = BitmapFactory.decodeStream((InputStream) new URL(movie.getImage()).getContent());
                images.add(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = layoutInflater.inflate(R.layout.list_element, parent, false);
        ImageView image = (ImageView) rowView.findViewById(R.id.image);
        TextView name = (TextView) rowView.findViewById(R.id.name);
        TextView rating = (TextView) rowView.findViewById(R.id.rating);
        TextView score = (TextView) rowView.findViewById(R.id.score);
        TextView favorited = (TextView) rowView.findViewById(R.id.favorited);
        TextView type = (TextView) rowView.findViewById(R.id.type);

        name.setText("Name: " + movies.get(position).getName());
        rating.setText("Rating: " + movies.get(position).getRating());
        score.setText("Score: " + movies.get(position).getImdbScore() + "");
        type.setText("Type: " + movies.get(position).getType());

        if(movies.get(position).isFavorited()){
            favorited.setText("Favorited: Yes");
        }else favorited.setText("Favorited: No");

        image.setImageBitmap(images.get(position));

        return rowView;
    }
}
