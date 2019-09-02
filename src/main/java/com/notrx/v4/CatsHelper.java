package com.notrx.v4;

import com.notrx.v1.Cat;
import com.sun.jndi.toolkit.url.Uri;

import java.util.Collections;
import java.util.List;

class CatsHelper {

    ApiWrapper apiWrapper;

    public void saveTheCutestCat(String query, GenericCallback<Uri> cutestCatCallback) {
        apiWrapper.queryCats(query, new GenericCallback<List<Cat>>() {
            @Override
            public void onResult(List<Cat> cats) {
                Cat cutest = findCutest(cats);
                apiWrapper.store(cutest, cutestCatCallback);
            }

            @Override
            public void onError(Exception e) {
                cutestCatCallback.onError(e);
            }
        });
    }

    private Cat findCutest(List<Cat> cats) {
        return Collections.max(cats);
    }
}
