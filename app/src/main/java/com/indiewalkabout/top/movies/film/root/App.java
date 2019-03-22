package com.indiewalkabout.top.movies.film.root;

import android.app.Application;

import com.indiewalkabout.top.movies.film.http.ApiModuleForInfo;
import com.indiewalkabout.top.movies.film.http.ApiModuleForName;
import com.tetraandroid.finalappexample.root.DaggerApplicationComponent;
import com.indiewalkabout.top.movies.film.topmovies.TopMoviesModule;

public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .apiModuleForName(new ApiModuleForName())
                .topMoviesModule(new TopMoviesModule())
                .apiModuleForInfo(new ApiModuleForInfo())
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
