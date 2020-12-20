package com.example.mvp.contract;



import com.example.mvp.Bean.JavaBean;
import com.example.mylibrary.base.BaseModel;
import com.example.mylibrary.base.BaseView;
import com.example.mylibrary.utils.CallBack;


public  class MainContract{
    public interface IModel extends BaseModel {
      <T> void iModel(String string, CallBack<T> callback);
    }
    public interface  IPresenter{
        void presenter();
    }
    public interface IView extends BaseView {
        //成功拿到数据
        void Ok(JavaBean javaBean);
        //失败
        void No(String string);

    }
}
