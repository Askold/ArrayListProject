package org.example;

public class ArrayList<T extends Comparable<T>> {
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


    public void sort(){
        quickSort(this, 0, this.getSize() - 1);
    }

    private <T extends Comparable<T>> void quickSort(ArrayList<T> array, int wall, int high) {
        if (array.getSize() == 0)
            return;//end if length == 0

        if (wall >= high)
            return;//end if it nothing to divide

        // select Pivot
        int middle = wall + (high - wall) / 2;
        T pivot =  array.get(middle);

        // divide into 2 parts: more than pivot or less
        int i = wall, j = high;
        while (i <= j) {
            while (array.get(i).compareTo(pivot) < 0) {
                i++;
            }

            while (array.get(j).compareTo(pivot) > 0) {
                j--;
            }

            if (i <= j) {//swap
                T temp = array.get(i);
                array.set(i, array.get(j));
                array.set(j, temp);
                i++; j--;
            }
        }

        // sort left and right parts with recursion
        if (wall < j)
            quickSort(array, wall, j);

        if (high > i)
            quickSort(array, i, high);
    }


}
