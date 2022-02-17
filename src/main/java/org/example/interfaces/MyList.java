package org.example.interfaces;

public interface MyList<T> {

    int getSize();

    void add(T value);

    void add(int id, T value);

    T get(int id);

    void remove(int id);

    void clear();

    int indexOf(T value);

    void set(int id, T value);

    void trimToSize();



}
