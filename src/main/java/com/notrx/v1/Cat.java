package com.notrx.v1;

public class Cat implements Comparable<Cat>{
    String image;
    int cuteness;

    @Override
    public int compareTo(Cat another) {
        return Integer.compare(cuteness, another.cuteness);
    }
}