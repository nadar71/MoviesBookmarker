package com.indiewalkabout.top.movies.film.topmovies;

import rx.Observable;

public interface TopMoviesActivityMVP {

    interface View {

        void updateData(ViewModel viewModel);

        void showSnackbar(String s); // TODO : it doesn't work !!

    }

    interface Presenter {

        void loadData();

        void rxUnsubscribe();

        void setView(TopMoviesActivityMVP.View view);

    }

    interface Model {

        Observable<ViewModel> result();

    }
}
