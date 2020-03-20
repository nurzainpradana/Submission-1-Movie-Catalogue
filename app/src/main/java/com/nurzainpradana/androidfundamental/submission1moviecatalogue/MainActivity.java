package com.nurzainpradana.androidfundamental.submission1moviecatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.nurzainpradana.androidfundamental.submission1moviecatalogue.Adapter.MovieAdapter;
import com.nurzainpradana.androidfundamental.submission1moviecatalogue.Model.Movie;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MovieAdapter adapter;
    //inisialisasi array
    private String[] dataMovieTitle, dataMovieDescription, dataMovieYear;
    private TypedArray dataPoster;

    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lv_list_movie);
        adapter = new MovieAdapter(this);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, movies.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void prepare() {
        dataMovieTitle = getResources().getStringArray(R.array.data_movie_title);
        dataMovieDescription = getResources().getStringArray(R.array.data_movie_description);
        dataPoster = getResources().obtainTypedArray(R.array.data_movie_poster);
        dataMovieYear = getResources().getStringArray(R.array.data_movie_year);
    }

    private void addItem(){
        movies = new ArrayList<>();

        for (int i = 0; i < dataMovieDescription.length; i++) {
            Movie movie = new Movie();
            movie.setTitle(dataMovieTitle[i]);
            movie.setDescription(dataMovieDescription[i]);
            movie.setYear(dataMovieYear[i]);
            movie.setPoster(dataPoster.getResourceId(i,-1));
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }
}