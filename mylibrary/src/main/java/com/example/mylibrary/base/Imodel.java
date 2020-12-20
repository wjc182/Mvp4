package com.example.mylibrary.base;

import com.example.mylibrary.utils.CallBack;

public interface Imodel {
    <T> void iModel(String string, CallBack<T> callback);
}
