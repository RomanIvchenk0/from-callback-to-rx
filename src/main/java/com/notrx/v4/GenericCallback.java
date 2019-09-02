package com.notrx.v4;

public interface GenericCallback<T> {
    void onResult(T result);
    void onError(Exception e);
}
