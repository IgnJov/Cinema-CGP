package com.example.uasmobileprogramming;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ImdbAPI {
    @GET("now_playing?api_key=cfd53fc80769120c8278df80b60c074e&language=en-US&page=1")
    Call<MovieQuery> getMovies();
}
