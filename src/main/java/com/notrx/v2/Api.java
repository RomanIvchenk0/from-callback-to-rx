package com.notrx.v2;

import com.notrx.v1.Cat;
import com.sun.jndi.toolkit.url.Uri;

import java.util.List;


interface Api {
    interface CatsQueryCallback {
        void onCatListReceived(List<Cat> cats);
        void onError(Exception e);
    }

    void queryCats(String query, CatsQueryCallback catsQueryCallback);

    Uri store(Cat cat);
}
