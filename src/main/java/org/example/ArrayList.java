package org.example;

public class ArrayList<T> {
    private Object[] elementData = new Object[10];
    private int size = 0;


    //Get size of an inner array
    public int getSize() {
        return size;
    }

    //Add new element into ArrayList
    public void add(T value) {
        if (size == elementData.length-1)
            resize();
        elementData[size++] = value;
    }

    //Add new element into current place
    public void add(int id, T value){
        if (size == elementData.length-1)
            resize();
        System.arraycopy(elementData, id, elementData, id + 1, size - id);
        elementData[id] = value;
        size++;
    }

    //Get element from ArrayList by id
    public T get(int id){
        return (T) elementData[id];
    }

    //Remove element from ArrayList by id
    public void remove(int id){
        int numMoved = size - id - 1;
        System.arraycopy(elementData, id + 1, elementData, id, numMoved);
        elementData[--size] = null;
    }

    //Remove all elements from ArrayList
    public void clear(){
        elementData = new Object[10];
        size = 0;
    }

    //Index of current value in ArrayList
    public int indexOf(T value){
        for (int i = 0; i < size; i++){
            if (elementData[i] == value)
                return i;
        }
        return -1;
    }

    //Change value of element with given
    public void set(int id, T value){
        elementData[id] = value;
    }

    //Adjust size of inner array 
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



}
