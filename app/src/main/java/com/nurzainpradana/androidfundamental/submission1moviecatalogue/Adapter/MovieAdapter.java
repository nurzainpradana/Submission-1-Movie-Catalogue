package com.nurzainpradana.androidfundamental.submission1moviecatalogue.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nurzainpradana.androidfundamental.submission1moviecatalogue.Model.Movie;
import com.nurzainpradana.androidfundamental.submission1moviecatalogue.R;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Movie> movies = new ArrayList<>();

    //setter hasil generate

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    //constructor hasil generate

    public MovieAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);

            viewHolder = new ViewHolder(view);
            viewHolder.txtTitle = view.findViewById(R.id.txt_title);
            viewHolder.txtDesc = view.findViewById(R.id.txt_description);
            viewHolder.txtYear = view.findViewById(R.id.txt_year);
            viewHolder.imgPoster = view.findViewById(R.id.img_poster);
            view.setTag(viewHolder);
        }
        viewHolder  = (ViewHolder) view.getTag();
        viewHolder.bind(movies.get(i));
        return view;
    }

    private class ViewHolder {
        private TextView txtTitle, txtDesc, txtYear;
        private ImageView imgPoster;

        ViewHolder(View view) {
            txtTitle = view.findViewById(R.id.txt_title);
            txtDesc = view.findViewById(R.id.txt_description);
            txtYear = view.findViewById(R.id.txt_year);
            imgPoster = view.findViewById(R.id.img_poster);
        }

        void bind(Movie movie) {
            txtTitle.setText(movie.getTitle());
            txtDesc.setText(movie.getDescription());
            txtYear.setText(movie.getYear());
            imgPoster.setImageResource(movie.getPoster());
        }
    }
}