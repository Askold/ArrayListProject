package org.example;

import junit.framework.TestCase;
import org.junit.Assert;

public class ArrayListTest extends TestCase {

    private final ArrayList test = new ArrayList();

    public void testGetSize() {
        System.out.println(test.getSize());
    }

    public void testAdd() {
        test.clear();
        test.add("Hello");
        System.out.println(test.getSize());
    }

    public void testTestAdd() {
        test.add("Hello");
        test.add("World");
        System.out.println(test.getSize());
        System.out.println(test.get(0));
        System.out.println(test.get(1));
        test.add(1, "Fckn");
        System.out.println(test.getSize());
        System.out.println(test.get(0));
        System.out.println(test.get(1));
        System.out.println(test.get(2));
    }

    public void testGet() {
        test.add("Hello");
        System.out.println(test.get(0));
    }

    public void testRemove() {
        test.add("Hello");
        test.add("World");
        test.add("Elem");
        test.add("Elem1");
        test.add("Elem2");
        test.add("Elem3");
        System.out.println(test.getSize());
        System.out.println(test.get(3));
        System.out.println(test.get(4));
        test.remove(3);
        System.out.println(test.getSize());
        System.out.println(test.get(3));
        System.out.println(test.get(4));
    }

    public void testClear() {
        test.add("Hello");
        System.out.println(test.getSize());
        test.clear();
        System.out.println(test.getSize());
    }

    public void testIndexOf() {
        test.add("Hello");
        test.add("World");
        test.add("Elem");
        test.add("Elem1");
        test.add("Elem2");
        test.add("Elem3");
        System.out.println(test.get(2));
        test.set(2, "Another value");
        System.out.println(test.get(2));
    }

    public void testSet() {
    }

    private void printArr(ArrayList arr){
        for (int i = 0; i < arr.getSize(); i++){
            System.out.print(arr.get(i)+" | ");
        }
    }

    public void testQuickSort() {
        test.add(1);
        test.add(9);
        test.add(2);
        test.add(5);
        test.add(2);
        test.add(7);
        test.add(5);
        test.add(10);
        test.add(3);
        test.add(15);
        test.add(4);
        test.add(6);
        test.add(8);
        printArr(test);
        Integer[] integers = {1, 19, 4, 6, 2, 7, 8, 3, 5};
        test.quickSort(integers, 0, 10);
        System.out.println(integers);
       // test.quickSort(test, 0, test.getSize()-1);
        printArr(test);
    }

    public void testSort() {
        test.sort();
    }
}