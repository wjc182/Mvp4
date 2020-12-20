package com.example.mvp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mvp.Bean.JavaBean;
import com.example.mvp.adaptrel.Adafel;

import com.example.mvp.contract.MainContract;
import com.example.mvp.presenter.PresenterImp;
import com.example.mylibrary.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<PresenterImp> implements MainContract.IView {


  private RecyclerView rec;
    private ArrayList<JavaBean.ResultsDTO> list;
    private Adafel adafel;

    @Override
    protected void initView() {
        rec=findViewById(R.id.rew_main);
        rec.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        //适配器
        adafel = new Adafel(this, list);
        //设置适配器
        rec.setAdapter(adafel);
    }

    @Override
    protected void initDtata() {
        presenter.presenter();
    }

    @Override
    protected int getDataId() {
        return R.layout.activity_main;
    }

    @Override
    public void Ok(JavaBean javaBean) {
        List<JavaBean.ResultsDTO> results = javaBean.getResults();
        list.addAll(results);
        adafel.notifyDataSetChanged();
    }
    @Override
    public void No(String string) {

    }
}