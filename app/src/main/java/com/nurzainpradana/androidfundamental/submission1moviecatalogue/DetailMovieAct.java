package com.nurzainpradana.androidfundamental.submission1moviecatalogue;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.jgabrielfreitas.core.BlurImageView;

public class DetailMovieAct extends Activity {
    public static String EXTRA_MOVIE = "extra_movie";

    TextView tvDetailTitle, tvDetailYear, tvDetailGenre, tvDetailDescription;
    ImageView ivPosterMini;
    BlurImageView ivPosterBackround;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        tvDetailTitle = findViewById(R.id.txt_title_detail);
        tvDetailDescription = findViewById(R.id.txt_description_detail);
        tvDetailGenre = findViewById(R.id.txt_genre_detail);
        tvDetailYear = findViewById(R.id.txt_year_detail);
        ivPosterMini = findViewById(R.id.img_poster_detail_mini);
        ivPosterBackround = findViewById(R.id.img_poster_detail);

        Movie mMovie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        tvDetailTitle.setText(mMovie.getTitle());
        tvDetailYear.setText(mMovie.getYear());
        tvDetailGenre.setText(mMovie.getGenre());
        tvDetailDescription.setText(mMovie.getDescription());
        ivPosterMini.setImageResource(mMovie.getPoster());
        ivPosterBackround.setImageResource(mMovie.getPoster());

        ivPosterBackround.setBlur(3);
    }
}
