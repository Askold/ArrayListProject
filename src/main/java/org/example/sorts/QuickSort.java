package org.example.sorts;

import org.example.ArrayList;
import org.example.Constants;
import org.example.exceptions.ElementArrayException;
import org.example.exceptions.SizeArrayException;

import java.util.Optional;

/**
 * Class which offer quicksort algorithm realisation
 *
 * @author Silonov Kirill
 */
public class QuickSort {

    /**
     * Main and the only method
     *
     * @param array incoming array of T type elements
     * @param wall left element
     * @param high right element
     */
    public static <T extends Comparable<T>> void quickSort(ArrayList<T> array, int wall, int high) {
        Optional.ofNullable(array).orElseThrow(()-> new ElementArrayException(Constants.NULL_ARRAY));

        if (wall < 0 || wall > array.getSize() || high < 0 || high > array.getSize())
            throw new SizeArrayException(Constants.WRONG_WALL_AND_HIGH);

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
