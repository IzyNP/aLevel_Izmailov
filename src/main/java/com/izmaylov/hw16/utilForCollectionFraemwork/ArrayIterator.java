package com.izmaylov.hw16.utilForCollectionFraemwork;

import java.util.Iterator;

public class ArrayIterator<E> implements Iterator<E> {
    private E[] array;
    private int currentIndex;

    public ArrayIterator(E[] array) {
        this.array = array;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < array.length;
    }

    @Override
    public E next() {
        E value = array[currentIndex];
        currentIndex++;
        return value;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }


}
