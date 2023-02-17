package org.example;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomIterator<E> implements Iterator<E> {
    private CustomArrayList list;
    private int index = 0;

    private int lastRet=-1;

    public CustomIterator(CustomArrayList customArrayList) {
        this.list = customArrayList;
    }

    public boolean hasNext() {
        return index < list.size();
    }

    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        E element = (E) list.get(index);
        index++;
        lastRet++;
        return element;
    }

    public void remove() {
        if (index > list.size()) {
            throw new UnsupportedOperationException();
        }
        if(lastRet==-1){
            throw new IllegalStateException();
        }
        list.remove(index);
        lastRet--;
    }
}