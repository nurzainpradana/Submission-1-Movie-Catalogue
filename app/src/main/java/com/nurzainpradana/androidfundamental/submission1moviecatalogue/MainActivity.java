package com.nurzainpradana.androidfundamental.submission1moviecatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    private String[] dataMovieTitle, dataMovieDescription, dataMovieYear, dataMovieGenre;
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
                Movie movie = new Movie();
                movie.setTitle(movies.get(position).getTitle());
                movie.setYear(movies.get(position).getYear());
                movie.setDescription(movies.get(position).getDescription());
                movie.setPoster(movies.get(position).getPoster());

                Intent gotodetailmovie = new Intent(MainActivity.this, DetailMovieAct.class);
                gotodetailmovie.putExtra(DetailMovieAct.EXTRA_MOVIE, movie);
                startActivity(gotodetailmovie);
            }
        });
    }

    private void prepare() {
        dataMovieTitle = getResources().getStringArray(R.array.data_movie_title);
        dataMovieGenre = getResources().getStringArray(R.array.data_movie_genre);
        dataMovieDescription = getResources().getStringArray(R.array.data_movie_description);
        dataPoster = getResources().obtainTypedArray(R.array.data_movie_poster);
        dataMovieYear = getResources().getStringArray(R.array.data_movie_year);
    }

    private void addItem(){
        movies = new ArrayList<>();

        for (int i = 0; i < dataMovieTitle.length; i++) {
            Movie movie = new Movie();
            movie.setTitle(dataMovieTitle[i]);
            movie.setDescription(dataMovieDescription[i]);
            movie.setYear(dataMovieYear[i]);
            movie.setPoster(dataPoster.getResourceId(i,-1));
            movie.setGenre(dataMovieGenre[i]);
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }
}