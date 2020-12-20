package com.example.mvp.presenter;


import com.example.mvp.Bean.JavaBean;
import com.example.mvp.contract.MainContract;
import com.example.mvp.model.ModelImp;
import com.example.mylibrary.base.BasePresenter;
import com.example.mylibrary.utils.CallBack;


public class PresenterImp extends BasePresenter<MainContract.IView,MainContract.IModel> implements MainContract.IPresenter {

    @Override
    public void presenter() {
      Models.iModel("%E7%A6%8F%E5%88%A9/20/3", new CallBack<JavaBean>() {
          @Override
          public void OnSuccess(JavaBean javaBean) {
              Views.Ok(javaBean);
          }

          @Override
          public void OnFail(String error) {
              Views.No(error);
          }
      });
    }

    @Override
    protected MainContract.IModel getModels() {
        return new ModelImp(this);
    }
}
