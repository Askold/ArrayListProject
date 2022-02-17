package org.example;

import org.example.exceptions.ElementArrayException;
import org.example.exceptions.SizeArrayException;
import org.example.interfaces.MyList;
import org.example.sorts.QuickSort;

import java.util.Optional;

public class ArrayList<T extends Comparable<T>> implements MyList<T> {

    //Some local constants
    private static final int MAX_SIZE = 2147483639;
    private static final int MIN_SIZE = 0;

    //Default variables
    private Object[] elementData = new Object[10];
    private int size = 0;

    public ArrayList() {
    }

    //Constructor for custom inner array size
    public ArrayList(int size) {
        if (size < MIN_SIZE || size > MAX_SIZE)
            throw new SizeArrayException(" size = " + size + " ,expected size >= 0 ");
        elementData = new Object[size];
        this.size = size;
    }

    //Get size of an inner array
    @Override
    public int getSize() {
        return size;
    }

    //Add new element into ArrayList
    @Override
    public void add(T value) {
        Optional.ofNullable(value).orElseThrow(()->
                new ElementArrayException("parameter value = NULL, element can not be null"));
        if (size == elementData.length-1)
            resize();
        elementData[size++] = value;
    }

    //Add new element into current place
    @Override
    public void add(int id, T value){
        Optional.ofNullable(value).orElseThrow(()->
                new ElementArrayException("parameter value = NULL, element can not be null"));
        if (id < MIN_SIZE || id > MAX_SIZE)
            throw new SizeArrayException(" size = " + size + " ,expected size >= 0 ");
        if (size == elementData.length-1)
            resize();
        System.arraycopy(elementData, id, elementData, id + 1, size - id);
        elementData[id] = value;
        size++;
    }

    //Get element from ArrayList by id
    @Override
    public T get(int id){
        if (id < MIN_SIZE || id > MAX_SIZE)
            throw new SizeArrayException(" size = " + size + " ,expected size >= 0 ");
        return (T) elementData[id];
    }

    //Remove element from ArrayList by id
    @Override
    public void remove(int id){
        if (id < MIN_SIZE || id > MAX_SIZE)
            throw new SizeArrayException(" size = " + size + " ,expected size >= 0 ");
        int numMoved = size - id - 1;
        System.arraycopy(elementData, id + 1, elementData, id, numMoved);
        elementData[--size] = null;
    }

    //Remove all elements from ArrayList
    @Override
    public void clear(){
        elementData = new Object[10];
        size = 0;
    }

    //Index of current value in ArrayList
    @Override
    public int indexOf(T value){
        Optional.ofNullable(value).orElseThrow(()->
                new ElementArrayException("parameter value = NULL, element can not be null"));
        for (int i = 0; i < size; i++){
            if (elementData[i] == value)
                return i;
        }
        return -1;
    }

    //Change value of element with given
    @Override
    public void set(int id, T value){
        Optional.ofNullable(value).orElseThrow(()->
                new ElementArrayException("parameter value = NULL, element can not be null"));
        if (id < MIN_SIZE || id > MAX_SIZE)
            throw new SizeArrayException(" size = " + size + " ,expected size >= 0 ");
        elementData[id] = value;
    }

    //Adjust size of inner array
    @Override
    public void trimToSize(){
        if (elementData.length > size*2){
            Object[] oldData = elementData;
            elementData = new Object[oldData.length / 2];
            System.arraycopy(oldData, 0, elementData, 0, size);
        }
    }

    private void resize(){
        Object[] oldData = elementData;
        elementData = new Object[oldData.length * 2];
        System.arraycopy(oldData, 0, elementData, 0, size);
    }


    public void sort(){
        QuickSort.quickSort(this, 0, this.getSize() - 1);
    }



}
