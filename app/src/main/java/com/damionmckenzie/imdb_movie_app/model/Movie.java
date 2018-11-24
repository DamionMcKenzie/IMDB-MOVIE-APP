package com.damionmckenzie.imdb_movie_app.model;

import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movie {
     int id;
    String posterPath, title, overView;
     double rating;
    String POSTER_PATH = "POSTER_PATH";
    private static String TITLE = "TITLE";
    private static final String OVERVIEW = "OVERVIEW";

    //empty constructor needed by the parcel library
    public Movie() {
    }

    public Movie(JSONObject jsonObject) throws JSONException {
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overView = jsonObject.getString("overview");
        rating = jsonObject.getDouble("vote_average");
        id = jsonObject.getInt("id");
    }

    public Movie(Bundle bundle) {
        this.posterPath = bundle.getString(POSTER_PATH);
        this.title = bundle.getString(TITLE);
        this.overView = bundle.getString(OVERVIEW);
    }


    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < movieJsonArray.length(); i++) {
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342%s", posterPath);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverView() {
        return overView;
    }


    public double getRating() {
        return rating;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
