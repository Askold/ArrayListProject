package org.example;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;

public class ArrayListTest extends TestCase {

    private final ArrayList test = new ArrayList();
    private final String elem1 = "Hello";
    private final String elem2 = "World";
    private final String elemExtra= "Fckn";
    private final String[] arr = {"Elem", "Elem1", "Elem2", "Elem3"};

    public void testGetSize() {
       Assert.assertEquals(test.getSize(), 0);
        test.add(elem1);
        Assert.assertEquals(test.getSize(), 1);
        test.add(elem2);
        Assert.assertEquals(test.getSize(), 2);
    }

    public void testAdd() {
        //Given
        int[] numArr = {1, 9, 2, 5, 2, 7, 5, 17, 3, 15, 4, 6, 8, 1, 9, 2, 5, 2, 7, 5, 17, 3, 15, 4, 6, 8};
        //When
        for (int i =0; i < numArr.length; i++){
            test.add(numArr[i]);
        }
        //Then
        Assert.assertEquals(numArr.length, test.getSize());
    }


    public void testTestAdd() {
        //Given
        test.add(elem1);
        test.add(elem2);
        Assert.assertEquals(2, test.getSize());
        //When
        test.add(1, "Fckn");
        //Then
        Assert.assertEquals(test.getSize(), 3);
        Assert.assertEquals(test.get(1), "Fckn");
        Assert.assertEquals(test.get(2), "World");
    }

    public void testGet() {
        //Given
        test.add(elem1);
        //When
        String elem = (String) test.get(0);
        //Then
        Assert.assertEquals(elem1, elem);
    }

    public void testRemove() {
        //Given
        test.add(elem1);
        test.add(elem2);
        for (int i =0; i < arr.length; i++){
            test.add(arr[i]);
        }
        int sizeBefore = test.getSize();
        String element5 =(String) (test.get(4));
        //When
        test.remove(3);
        //Then
        Assert.assertNotEquals(sizeBefore, test.getSize());
        Assert.assertEquals(element5, test.get(3));
    }

    public void testClear() {
        //Given
        for (int i =0; i < arr.length; i++){
            test.add(arr[i]);
        }
        int sizeBefore = test.getSize();
        //When
        test.clear();
        //Then
        Assert.assertNotEquals(sizeBefore, test.getSize());
        Assert.assertEquals(0, test.getSize());
    }

    public void testIndexOf() {
        //Given
        for (int i =0; i < arr.length; i++){
            test.add(arr[i]);
        }
        String value = "value";
        test.add(3, value);
        //When
        int index = test.indexOf(value);
        //Then
        Assert.assertEquals(3, index);
    }

    public void testSet() {
        //Given
        for (int i =0; i < arr.length; i++){
            test.add(arr[i]);
        }
        String anotherValue = "Another value";
        //When
        test.set(2, anotherValue);
        //Then
        Assert.assertEquals(test.get(2), anotherValue);
    }

    private void printArr(ArrayList arr){
        for (int i = 0; i < arr.getSize(); i++){
            System.out.print(arr.get(i)+" | ");
        }
        System.out.println();
    }


    public void testSort() {
        //Given
        int[] numArr = {1, 9, 2, 5, 2, 7, 5, 17, 3, 15, 4, 6, 8,};
        for (int i =0; i < numArr.length; i++){
            test.add(numArr[i]);
        }
        //When
        test.sort();
        //Then
        for (int i = 0; i < test.getSize()-1; i++){
            Assert.assertTrue((int) test.get(i) < (int) test.get(i+1));
        }
    }
}