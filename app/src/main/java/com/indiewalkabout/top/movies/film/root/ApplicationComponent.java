package com.indiewalkabout.top.movies.film.root;

import com.indiewalkabout.top.movies.film.http.ApiModuleForInfo;
import com.indiewalkabout.top.movies.film.http.ApiModuleForName;
import com.indiewalkabout.top.movies.film.topmovies.TopMoviesActivity;
import com.indiewalkabout.top.movies.film.topmovies.TopMoviesModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, ApiModuleForName.class, ApiModuleForInfo.class,TopMoviesModule.class})
public interface ApplicationComponent {

    void inject(TopMoviesActivity target);

}
