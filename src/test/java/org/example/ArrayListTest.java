package org.example;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;

public class ArrayListTest extends TestCase {

    private final ArrayList test = new ArrayList();
    private final String elem1 = "Hello";
    private final String elem2 = "World";
    private final String elemExtra= "Fckn1";
    private final String[] arr = {"Elem", "Elem1", "Elem2", "Elem3"};

    public void testGetSize() {
        Assert.assertEquals(test.getSize(), 0);
        test.add(elem1);
        Assert.assertEquals(test.getSize(), 1);
        test.add(elem2);
        Assert.assertEquals(test.getSize(), 2);
    }

    public void testAdd() {
        //Given: Array with more than 10 elements
        int[] numArr = {1, 9, 2, 5, 2, 7, 5, 17, 3, 15, 4, 6, 8, 1, 9, 2, 5, 2, 7, 5, 17, 3, 15, 4, 6, 8};
        //When: Testing add method
        for (int i =0; i < numArr.length; i++){
            test.add(numArr[i]);
        }
        //Then: Length of default array and our ArrayList should be equal
        Assert.assertEquals(numArr.length, test.getSize());
    }


    public void testTestAdd() {
        //Given: Filling array
        test.add(elem1);
        test.add(elem2);
        //When: Adding new element into body
        test.add(1, elemExtra);
        //Then: Elements after new one should move
        Assert.assertEquals(test.getSize(), 3);
        Assert.assertEquals(test.get(1), elemExtra);
        Assert.assertEquals(test.get(2), elem2);
    }

    public void testGet() {
        //Given: Filling array
        test.add(elem1);
        //When: Getting element by id
        String elem = (String) test.get(0);
        //Then: Inputted and received elements should be equal
        Assert.assertEquals(elem1, elem);
    }

    public void testRemove() {
        //Given: Filling array, saving element next from one that used to be removed and size
        test.add(elem1);
        test.add(elem2);
        for (int i =0; i < arr.length; i++){
            test.add(arr[i]);
        }
        int sizeBefore = test.getSize();
        String element5 =(String) (test.get(4));
        //When: Trying to remove element by id
        test.remove(3);
        //Then: Saved and received elements should be equal, sizes should not be equal
        Assert.assertNotEquals(sizeBefore, test.getSize());
        Assert.assertEquals(element5, test.get(3));
    }

    public void testClear() {
        //Given: Filling array and saving size
        for (int i =0; i < arr.length; i++){
            test.add(arr[i]);
        }
        int sizeBefore = test.getSize();
        //When: Trying to clear an array
        test.clear();
        //Then: Size should be equal zero
        Assert.assertNotEquals(sizeBefore, test.getSize());
        Assert.assertEquals(0, test.getSize());
    }

    public void testIndexOf() {
        //Given: Filling array and setting the value which we are looking for
        for (int i =0; i < arr.length; i++){
            test.add(arr[i]);
        }
        String value = "value";
        test.add(3, value);
        //When: Searching by value
        int index = test.indexOf(value);
        //Then: Indexes of transferred element and received one should be equal
        Assert.assertEquals(3, index);
    }

    public void testSet() {
        //Given: Filling array and saving new value of element
        for (int i =0; i < arr.length; i++){
            test.add(arr[i]);
        }
        String anotherValue = "Another value";
        //When: Changing value by id
        test.set(2, anotherValue);
        //Then: Saved and new values should be equal
        Assert.assertEquals(test.get(2), anotherValue);
    }

    private void printArr(ArrayList arr){
        for (int i = 0; i < arr.getSize(); i++){
            System.out.print(arr.get(i)+" | ");
        }
        System.out.println();
    }


    public void testSort() {
        //Given: Filling array
        int[] numArr = {1, 9, 2, 5, 2, 7, 5, 17, 3, 15, 4, 6, 8,};
        for (int i =0; i < numArr.length; i++){
            test.add(numArr[i]);
        }
        //When: Sorting ArrayList with our quickSort() method
        test.sort();
        printArr(test);
        //Then: Each element should be smaller than next
        for (int i = 0; i < test.getSize()-1; i++){
            Assert.assertTrue((int) test.get(i) <= (int) test.get(i+1));
        }
    }
}