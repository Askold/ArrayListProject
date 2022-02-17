package org.example.interfaces;

/**
 * Interface for own ArrayList class
 *
 * @author Silonov Kirill
 */
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
