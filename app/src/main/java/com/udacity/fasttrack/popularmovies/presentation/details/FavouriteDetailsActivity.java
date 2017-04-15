package com.udacity.fasttrack.popularmovies.presentation.details;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.udacity.fasttrack.popularmovies.R;
import com.udacity.fasttrack.popularmovies.data.remote.model.Movie;
import com.udacity.fasttrack.popularmovies.utils.ActivityUtils;

import static com.udacity.fasttrack.popularmovies.presentation.details.FavouriteDetailsFragment.ARGUMENT_MOVIE;

public class FavouriteDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        // Get the requested movie
        Movie movie = getIntent().getParcelableExtra(ARGUMENT_MOVIE);

        FavouriteDetailsFragment detailsFragment =
                (FavouriteDetailsFragment) getSupportFragmentManager().findFragmentById(R.id.container);
        if (detailsFragment == null) {
            // Create the fragment
            detailsFragment = FavouriteDetailsFragment.newInstance(movie);
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), detailsFragment, R.id.container);
        }

        // Create the presenter
        new FavouriteDetailsPresenter(movie,detailsFragment);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}