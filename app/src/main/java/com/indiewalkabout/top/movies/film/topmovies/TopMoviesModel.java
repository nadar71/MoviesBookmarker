package com.indiewalkabout.top.movies.film.topmovies;

import com.indiewalkabout.top.movies.film.http.apimodel.Result;

import rx.Observable;
import rx.functions.Func2;

public class TopMoviesModel implements TopMoviesActivityMVP.Model {

    private Repository repository;

    public TopMoviesModel(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<ViewModel> result() {
        // emits the result of 2 resultData and CountryData in a single emission, check .zip def
        return Observable.zip(
                repository.getResultData(),
                repository.getCountryData(),
                new Func2<Result, String, ViewModel>() {
                    @Override
                    public ViewModel call(Result result, String s) {
                        return new ViewModel(result.title, s);
                    }
                }
        );
    }

}
