package com.app.rabia.myapplication.di;

import com.app.rabia.myapplication.view.details.DetailFragment;
import com.app.rabia.myapplication.view.titles.MainScreenAdapter;
import com.app.rabia.myapplication.view.titles.MainScreenFragment;
import com.app.rabia.myapplication.view.titles.StartupPresenter;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by mansoor on 19/01/2017.
 */
@Singleton
@Component(dependencies = ApplicationModule.class)
public interface ApplicationComponent {
    // We need to expose the objects
    Picasso getPicasso();

    void inject(DetailFragment detailFragment);
    void inject(MainScreenAdapter mainScreenAdapter);

    StartupPresenter getStartupPresenter();


    void inject(MainScreenFragment mainScreenFragment);

}
