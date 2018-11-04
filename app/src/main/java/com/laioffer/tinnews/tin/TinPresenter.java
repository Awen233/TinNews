package com.laioffer.tinnews.tin;

import com.laioffer.tinnews.retrofit.response.News;
import com.laioffer.tinnews.tin.TinContract.View;

import java.util.List;

public class TinPresenter implements TinContract.Presenter {

    private TinContract.View view;

    private TinContract.Model model;

    public TinPresenter() {
        this.model = new TinModel();
        this.model.setPresenter(this);
    }


    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onViewAttached(View view) {
        this.view = view;
        this.model.fetchData();

    }

    @Override
    public void onViewDetached() {
        this.view = null;
    }

    //5.7 implement the showNewsCard, return the data to the view
    @Override
    public void showNewsCard(List<News> newsList) {
        if (this.view != null) {
            view.showNewsCard(newsList);
        }
    }


}
