package com.notrx.v5;

import com.notrx.v4.GenericCallback;

abstract class AsyncJob<T> {
    public abstract void start(GenericCallback<T> callback);
}