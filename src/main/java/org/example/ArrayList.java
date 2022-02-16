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
        Integer[] integers = {1, 9, 4, 6, 2, 7, 8, 3, 5};
        quickSort(integers, 0, integers.length - 1);
        for (int i = 0; i < integers.length; i++){
            System.out.print(integers[i]+" | ");
        }
    }

    public  <T extends Comparable<T>> void quickSort(T[] array, int wall, int high) {
        if (array.length == 0)
            return;//end if length == 0

        if (wall >= high)
            return;//end if it nothing to divide

        // select Pivot
        int middle = wall + (high - wall) / 2;
        T pivot =  array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = wall, j = high;
        while (i <= j) {
            while (array[i].compareTo(pivot) < 0) {
                i++;
            }

            while (array[j].compareTo(pivot) > 0) {
                j--;
            }

            if (i <= j) {//меняем местами
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (wall < j)
            quickSort(array, wall, j);

        if (high > i)
            quickSort(array, i, high);
    }


}
