package com.indiewalkabout.top.movies.film.topmovies;

import com.indiewalkabout.top.movies.film.http.apimodel.Result;

import rx.Observable;


public interface Repository {

    // methods used from retrieve movies from remote service
    Observable<Result> getResultsFromMemory();

    Observable<Result> getResultsFromNetwork();

    // methods used from retrieve movies from memory
    Observable<String> getCountriesFromMemory();

    Observable<String> getCountriesFromNetwork();

    // facade methods to retrieve data from the fields filled by the previous methods
    // these are the only ones used by TopMoviesModel.result() method in Observable.zip
    Observable<String> getCountryData();

    Observable<Result> getResultData();

}
