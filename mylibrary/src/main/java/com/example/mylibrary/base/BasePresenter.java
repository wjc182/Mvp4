package com.example.mylibrary.base;

public abstract class BasePresenter<P extends BaseView,M extends BaseModel> {
    public P Views;
    public M Models;
   public void attach(P p){
       Views=p;
       Models=getModels();
   }

   //得到m对象
    protected abstract M getModels();

}
