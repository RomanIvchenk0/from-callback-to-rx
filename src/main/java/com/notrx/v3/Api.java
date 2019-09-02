package com.notrx.v3;

import com.notrx.v1.Cat;
import com.sun.jndi.toolkit.url.Uri;

import java.util.List;

public interface Api {
    interface CatsQueryCallback {
        void onCatListReceived(List<Cat> cats);
        void onQueryFailed(Exception e);
    }

    interface StoreCallback{
        void onCatStored(Uri uri);
        void onStoreFailed(Exception e);
    }


    void queryCats(String query, CatsQueryCallback catsQueryCallback);

    void store(Cat cat, StoreCallback storeCallback);
}
