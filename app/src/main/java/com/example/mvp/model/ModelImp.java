package com.example.mvp.model;

import com.example.mvp.contract.MainContract;
import com.example.mylibrary.utils.CallBack;
import com.example.mylibrary.utils.NextRetrofit;


public class ModelImp implements MainContract.IModel {
    //数据
    private MainContract.IPresenter presenter;

    public ModelImp(MainContract.IPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public <T> void iModel(String url, CallBack<T> callback) {
        NextRetrofit.getInstance().iModel(url,callback);
    }
}
