package com.example.uasmobileprogramming;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.squareup.picasso.Picasso;

public class MovieDetailActivity extends AppCompatActivity {
    ImageView imageView_poster;
    TextView textView_title;
    TextView textView_overview;
    TextView textView_releaseDate;
    ExtendedFloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        Result movie = (Result) getIntent().getSerializableExtra("selectedMovie");

        imageView_poster = findViewById(R.id.imageView_detail_poster);
        textView_title = findViewById(R.id.textView_detail_title);
        textView_overview = findViewById(R.id.textView_detail_overview);
        textView_releaseDate = findViewById(R.id.textView_detail_releaseDate);
        floatingActionButton = findViewById(R.id.extended_fab_reserve);

        Picasso.get().load("https://image.tmdb.org/t/p/w342" + movie.getPosterPath()).into(imageView_poster);
        textView_title.setText(movie.getOriginalTitle());
        textView_overview.setText(movie.getOverview());
        textView_releaseDate.setText(movie.getReleaseDate());

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MovieDetailActivity.this, ReserveActivity.class));
            }
        });
    }
}