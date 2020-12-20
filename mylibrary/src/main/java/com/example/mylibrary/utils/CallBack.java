package com.example.mylibrary.utils;

public interface CallBack <T>{
    void OnSuccess(T t);

    void OnFail(String  error);

}
