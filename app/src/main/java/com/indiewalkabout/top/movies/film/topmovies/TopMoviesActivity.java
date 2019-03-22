package com.indiewalkabout.top.movies.film.topmovies;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import com.indiewalkabout.top.movies.film.root.App;
import com.tetraandroid.retrofitexample.R;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopMoviesActivity extends AppCompatActivity implements TopMoviesActivityMVP.View {

    private final String TAG = TopMoviesActivity.class.getName();

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    // TODO : used for snackbar, but I can't see when running, check here : showSnackbar(String msg)
    @BindView(R.id.listActivity_rootView)
    ViewGroup rootView;

    @Inject
    TopMoviesActivityMVP.Presenter presenter;

    private ListAdapter listAdapter;
    private List<ViewModel> resultList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topmovies_activity);

        // Dagger bind all the dependencies
        ((App) getApplication()).getComponent().inject(this);

        // Butterknife binding
        ButterKnife.bind(this);

        // set up recycle view
        listAdapter = new ListAdapter(resultList);
        recyclerView.setAdapter(listAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this));

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onStart() {  // in the lesson uses onResume !
        super.onStart();
        presenter.setView(this);
        presenter.loadData();
    }

    @Override
    protected void onStop() { // in lesson put all these in onDestroy !
        super.onStop();
        presenter.rxUnsubscribe();
        resultList.clear();
        listAdapter.notifyDataSetChanged();
    }


    @Override
    public void updateData(ViewModel viewModel) {
        resultList.add(viewModel);
        if (resultList.isEmpty()){
            listAdapter.notifyItemInserted(0);
        }else {
            listAdapter.notifyItemInserted(resultList.size() - 1);
        }
        Log.d(TAG, "updateData: " + resultList.size());
    }

    @Override
    public void showSnackbar(String msg) {
        Snackbar.make(rootView, msg, Snackbar.LENGTH_SHORT).show();

    }
}
