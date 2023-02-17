package org.example;

import java.util.*;

public class CustomArrayList<T> implements List<T> {
    private Object[] objects;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public CustomArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public CustomArrayList(int size) {
        objects = new Object[size];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new CustomIterator<>(CustomArrayList.this);
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(objects, size);
    }

    @Override
    public <E> E[] toArray(E[] a) {
        if(a==null){
            throw new NullPointerException();
        }
        if (a.length < size) {
            return (E[]) Arrays.copyOf(objects, size, a.getClass());
        }
        System.arraycopy(objects, 0, a, 0, size);
        return a;
    }


    @Override
    public boolean add(T t) {
        increaseCapacity(1);
        objects[size++] = t;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int indexOfObject = indexOf(o);
        if (indexOfObject != -1) {
            remove(indexOfObject);
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        increaseCapacity(c.size());
        for (Object o : c) {
            objects[size++] = o;
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        checkIndex(index);
        int cSize = c.size();
        increaseCapacity(cSize);
        for (int i = size-1; i >= index; i--) {
            objects[i+cSize] = objects[i];
        }
        int i=0;
        for (Object o : c) {
            objects[index+i++] = o;
        }
        this.size += cSize;
        return cSize != 0;
    }

    @Override
    public void clear() {
        objects = new Object[]{};
        size = 0;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        return (T) objects[index];
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        T removedElement = (T) objects[index];
        for (int i = index; i < size - 1; i++) {
            objects[i] = objects[i + 1];
        }
        size--;
        return removedElement;
    }

    @Override
    public T set(int index, T element) {
        checkIndex(index);
        T setElement = (T) objects[index];
        objects[index] = element;
        return setElement;
    }

    @Override
    public void add(int index, T element) {
        checkIndex(index);
        increaseCapacity(1);
        for (int i = size; i > index; i--) {
            objects[i] = objects[i-1];
        }
        objects[index]=element;
        size++;
    }


    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(objects[i], o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(objects[i], o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        return new CustomListIterator<>(CustomArrayList.this,0);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return new CustomListIterator<>(CustomArrayList.this,index);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        List<T> subList = new CustomArrayList<>(toIndex-fromIndex);
        for (int index = fromIndex; index < toIndex; index++) {
            subList.add((T) objects[index]);
        }
        return subList;
    }

    @Override
    public boolean retainAll(Collection c) {
        Object[] tempArray = new Object[objects.length];
        Iterator<T> iterator = c.iterator();
        while (iterator.hasNext()) {
            for (int index = 0, use = 0; index < objects.length; index++) {
                if (objects[index].equals(iterator.next())) {
                    tempArray[use] = objects[index];
                    use++;
                }
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection c) {
        boolean removeElement = false;
        for (Object obj : c) {
            removeElement = remove(obj);
        }
        return removeElement;
    }

    @Override
    public boolean containsAll(Collection c) {
        boolean containsAllElements = false;
        for (Object obj : c) {
            containsAllElements = contains(obj);
        }
        return containsAllElements;
    }

    @Override
    public String toString() {
        return Arrays.toString(objects);
    }


    private void increaseCapacity(int newElementsToBeAdded) {
        if (objects.length < size + newElementsToBeAdded) {
            int newCapacity = Math.max(objects.length * 2, size + newElementsToBeAdded);
            objects = Arrays.copyOf(objects, newCapacity);
        }
    }

    public void checkIndex(int index){
        if(index < 0 || index > size()){
            throw new IndexOutOfBoundsException();
        }
    }
}