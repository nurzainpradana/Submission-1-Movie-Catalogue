package com.nurzainpradana.androidfundamental.submission1moviecatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.jgabrielfreitas.core.BlurImageView;
import com.nurzainpradana.androidfundamental.submission1moviecatalogue.Model.Movie;

public class DetailMovieAct extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";

    TextView tvTitle, tvGenre, tvDescription, tvYear;
    BlurImageView ivDetailPoster;
    ImageView ivPosterMini;

    String title, year, description, genre;
    Integer poster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        tvTitle = findViewById(R.id.txt_title_detail);
        tvYear = findViewById(R.id.txt_year_detail);
        tvDescription = findViewById(R.id.txt_description_detail2);
        tvGenre = findViewById(R.id.txt_genre_detail2);

        ivPosterMini = findViewById(R.id.img_poster_detail_mini);
        ivDetailPoster = findViewById(R.id.img_poster_detail);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        title = movie.getTitle();
        year = movie.getYear();
        description = movie.getDescription();
        genre = movie.getGenre();
        poster = movie.getPoster();

        tvTitle.setText(title);
        tvGenre.setText(genre);
        tvDescription.setText(description);
        tvYear.setText(year);

        ivDetailPoster.setImageResource(poster);
        ivPosterMini.setImageResource(poster);

    }
}
