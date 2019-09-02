package com.notrx.v4;

import com.notrx.v1.Cat;
import com.notrx.v3.Api;
import com.sun.jndi.toolkit.url.Uri;

import java.util.List;

class ApiWrapper {
    Api api;

    public void queryCats(String query, GenericCallback<List<Cat>> catsCallback){
        api.queryCats(query, new Api.CatsQueryCallback() {
            @Override
            public void onCatListReceived(List<Cat> cats) {
                catsCallback.onResult(cats);
            }

            @Override
            public void onQueryFailed(Exception e) {
                catsCallback.onError(e);
            }
        });
    }

    public void store(Cat cat, GenericCallback<Uri> uriCallback){
        api.store(cat, new Api.StoreCallback() {
            @Override
            public void onCatStored(Uri uri) {
                uriCallback.onResult(uri);
            }

            @Override
            public void onStoreFailed(Exception e) {
                uriCallback.onError(e);
            }
        });
    }
}
