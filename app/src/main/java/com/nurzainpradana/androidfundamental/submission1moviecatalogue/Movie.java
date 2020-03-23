package com.nurzainpradana.androidfundamental.submission1moviecatalogue;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private int poster;
    private String title;
    private String genre;
    private String description;
    private String year;

    public Movie() {
    }

    protected Movie(Parcel in) {
        poster = in.readInt();
        title = in.readString();
        genre = in.readString();
        description = in.readString();
        year = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(poster);
        dest.writeString(title);
        dest.writeString(genre);
        dest.writeString(description);
        dest.writeString(year);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

}