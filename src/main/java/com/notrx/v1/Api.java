package com.notrx.v1;

import com.sun.jndi.toolkit.url.Uri;

import java.util.List;

interface Api {
    List<Cat> queryCats(String query);
    Uri store(Cat cat);
}
