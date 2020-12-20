package com.example.mylibrary.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView{

  public T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getDataId());

        if(presenter==null){
            createPresenter();
        }

        initDtata();
        initView();
    }

    public void createPresenter() {
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();

        Class<T> actualTypeArgument = (Class<T>) actualTypeArguments[0];

        try {
            presenter= actualTypeArgument.newInstance();
            presenter.attach(this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }

    protected abstract void initView();

    protected abstract void initDtata();

    protected abstract int getDataId();

}
