package com.laioffer.tinnews.tin;

import com.laioffer.tinnews.mvp.MvpContract;
import com.laioffer.tinnews.retrofit.response.News;

import java.util.List;

public interface TinContract {


    interface View extends MvpContract.View<Presenter> {
        void showNewsCard(List<News> showNewsCard);
    }

    interface Presenter extends MvpContract.Presenter<View, Model> {
        void showNewsCard(List<News> newsList);
    }

    interface Model extends MvpContract.Model<Presenter> {
        void fetchData();
    }
}
