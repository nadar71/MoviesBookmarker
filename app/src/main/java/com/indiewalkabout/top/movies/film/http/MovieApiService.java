package com.indiewalkabout.top.movies.film.http;

import com.indiewalkabout.top.movies.film.http.apimodel.TopRated;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface MovieApiService {

    @GET("top_rated")
    Observable<TopRated> getTopRatedMovies(@Query("page") Integer page);


}
