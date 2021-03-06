package com.laioffer.tinnews.tin;

import com.laioffer.tinnews.retrofit.NewsRequestApi;
import com.laioffer.tinnews.retrofit.RetrofitClient;
import com.laioffer.tinnews.tin.TinContract.Presenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class TinModel implements TinContract.Model {

    private TinContract.Presenter presenter;
    private final NewsRequestApi newsRequestApi;

    TinModel(){
        newsRequestApi = RetrofitClient.getInstance().create(NewsRequestApi.class);


    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void fetchData() {
        newsRequestApi.getNewsByCountry("us")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(baseResponse -> baseResponse != null && baseResponse.articles != null)
                .subscribe(baseResponse -> {
                    presenter.showNewsCard(baseResponse.articles);
                }, error ->{

                });
    }
}
