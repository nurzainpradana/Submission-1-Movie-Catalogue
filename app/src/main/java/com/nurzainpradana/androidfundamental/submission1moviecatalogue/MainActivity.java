package com.nurzainpradana.androidfundamental.submission1moviecatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MovieAdapter adapter;

    ArrayList<Movie> movies;

    //inisialisasi array
    private String[] dataMovieTitle;
    private String[] dataMovieDescription;
    private  String[] dataMovieYear;
    private  String[] dataMovieGenre;
    private TypedArray dataPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.lv_list_movie);
        listView.setAdapter(adapter);
        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent gotodetail = new Intent(MainActivity.this, DetailMovieAct.class);

                Movie mMovie = new Movie();
                mMovie.setTitle(movies.get(i).getTitle());
                mMovie.setGenre(movies.get(i).getGenre());
                mMovie.setDescription(movies.get(i).getDescription());
                mMovie.setYear(movies.get(i).getYear());
                mMovie.setPoster(movies.get(i).getPoster());

                gotodetail.putExtra(DetailMovieAct.EXTRA_MOVIE, mMovie);
                startActivity(gotodetail);
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
        for (int i = 0; i < dataMovieTitle.length ; i++) {
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