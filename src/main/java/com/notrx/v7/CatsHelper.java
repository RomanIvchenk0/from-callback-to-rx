package com.notrx.v7;

import com.notrx.v1.Cat;
import com.sun.jndi.toolkit.url.Uri;
import rx.Observable;
import rx.functions.Func1;

import java.util.Collections;
import java.util.List;

class CatsHelper {

    ApiWrapper apiWrapper;

    public Observable<Uri> saveTheCutestCat(String query) {
        Observable<List<Cat>> catsListObservable = apiWrapper.queryCats(query);
        Observable<Cat> cutestCatObservable = catsListObservable.map(CatsHelper.this::findCutest);
        Observable<Uri> storedUriObservable = cutestCatObservable.flatMap(cat -> apiWrapper.store(cat));
        return storedUriObservable;
    }

    private Cat findCutest(List<Cat> cats) {
        return Collections.max(cats);
    }
}
