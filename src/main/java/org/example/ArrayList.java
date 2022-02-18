package org.example;

import org.example.exceptions.ElementArrayException;
import org.example.exceptions.SizeArrayException;
import org.example.interfaces.MyList;
import org.example.sorts.QuickSort;

import java.util.Optional;

/**
 * This is my own realisation of ArrayList Collection
 *
 * @author Silonov Kirill
 */
public class ArrayList<T extends Comparable<T>> implements MyList<T> {

    /**
     * Some local constants
     */
    private static final int MAX_SIZE = 2147483639;
    private static final int MIN_SIZE = 0;
    private static final int DEFAULT_SIZE = 10;

    /**
     * Default variables
     */
    private Object[] elementData = new Object[DEFAULT_SIZE];
    private int size = 0;

    /**
     * Default constructor
     */
    public ArrayList() {
    }

    /**
     * Constructor for custom inner array size
     */
    public ArrayList(int size) {
        if (size < MIN_SIZE || size > MAX_SIZE)
            throw new SizeArrayException(Constants.INCORRECT_SIZE);
        elementData = new Object[size];
        this.size = size;
    }

    /**
     * Get size of an inner array
     *
     * @return size of a visible array
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Add new element into ArrayList
     *
     * @param value an element used to be added to ArrayList
     */
    @Override
    public void add(T value) {
        Optional.ofNullable(value).orElseThrow(()->
                new ElementArrayException(Constants.NULL_VALUE));
        if (size == elementData.length-1)
            resize();
        elementData[size++] = value;
    }

    /**
     * Add new element into current place
     *
     * @param id on which place new element should be added
     * @param value  an element used to be added to ArrayList
     */
    @Override
    public void add(int id, T value){
        Optional.ofNullable(value).orElseThrow(()->
                new ElementArrayException(Constants.NULL_VALUE));
        if (id < MIN_SIZE || id > MAX_SIZE)
            throw new SizeArrayException(Constants.INCORRECT_SIZE);
        if (size == elementData.length-1)
            resize();
        System.arraycopy(elementData, id, elementData, id + 1, size - id);
        elementData[id] = value;
        size++;
    }

    /**
     * Get element from ArrayList by id
     *
     * @param id index of searchable element
     * @return an element from ArrayList of T type
     */
    @Override
    public T get(int id){
        if (id < MIN_SIZE || id > size)
            throw new SizeArrayException(Constants.INCORRECT_SIZE);
        return (T) elementData[id];
    }

    /**
     * Remove element from ArrayList by id
     *
     * @param id index of removable element
     */
    @Override
    public void remove(int id){
        if (id < MIN_SIZE || id > MAX_SIZE)
            throw new SizeArrayException(Constants.INCORRECT_SIZE);
        int numMoved = size - id - 1;
        System.arraycopy(elementData, id + 1, elementData, id, numMoved);
        elementData[--size] = null;
    }

    /**
     * Remove all elements from ArrayList
     */
    @Override
    public void clear(){
        elementData = new Object[10];
        size = 0;
    }

    /**
     * Searches for an index of current element
     *
     * @param value element which index should be find
     * @return index of an element
     */
    @Override
    public int indexOf(T value){
        Optional.ofNullable(value).orElseThrow(()->
                new ElementArrayException(Constants.NULL_VALUE));
        for (int i = 0; i < size; i++){
            if (elementData[i] == value)
                return i;
        }
        return -1;
    }

    /**
     * Change value of element with given
     *
     * @param id index of an element which value should be changed
     * @param value new value
     */
    @Override
    public void set(int id, T value){
        Optional.ofNullable(value).orElseThrow(()->
                new ElementArrayException(Constants.NULL_VALUE));
        if (id < MIN_SIZE || id > MAX_SIZE)
            throw new SizeArrayException(Constants.INCORRECT_SIZE);
        elementData[id] = value;
    }

    /**
     * Adjust size of inner array
     */
    @Override
    public void trimToSize(){
        if (elementData.length > size*2){
            Object[] oldData = elementData;
            elementData = new Object[oldData.length / 2];
            System.arraycopy(oldData, 0, elementData, 0, size);
        }
    }

    /**
     * Adjust size of inner array
     */
    private void resize(){
        Object[] oldData = elementData;
        elementData = new Object[oldData.length * 2];
        System.arraycopy(oldData, 0, elementData, 0, size);
    }

    /**
     * Sorting itself
     */
    public void sort(){
        QuickSort.quickSort(this, 0, this.getSize() - 1);
    }
}
