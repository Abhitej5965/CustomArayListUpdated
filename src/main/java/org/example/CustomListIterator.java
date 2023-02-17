package org.example;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class CustomListIterator<E> implements ListIterator<E> {
    private final CustomArrayList<E> list;
    private int cursor;
    private int lastRet;

    public CustomListIterator(CustomArrayList<E> list, int index) {
        this.list = list;
        this.cursor = index;
        this.lastRet = -1;
    }

    @Override
    public boolean hasNext() {
        return cursor != list.size();
    }

    @Override
    public E next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        int i = cursor;
        if (i >= list.size()) {
            throw new NoSuchElementException();
        }
        cursor = i + 1;
        return list.get(lastRet = i);
    }

    @Override
    public boolean hasPrevious() {
        return cursor != 0;
    }

    @Override
    public E previous() {
        if(!hasPrevious()){
            throw new NoSuchElementException();
        }
        int i = cursor - 1;
        if (i < 0) {
            throw new NoSuchElementException();
        }
        cursor = i;
        return list.get(lastRet = i);
    }

    @Override
    public int nextIndex() {
        return cursor;
    }

    @Override
    public int previousIndex() {
        return cursor - 1;
    }

    @Override
    public void remove() {
        if (lastRet < 0) {
            throw new IllegalStateException();
        }
        list.remove(lastRet);
        if (lastRet < cursor) {
            cursor--;
        }
        lastRet--;
    }

    @Override
    public void set(E e) {
        if (lastRet < 0) {
            throw new IllegalStateException();
        }
        list.set(lastRet, e);
    }

    @Override
    public void add(E e) {
        int i = cursor;
        list.add(i, e);
        cursor = i + 1;
        lastRet++;
    }
}
