package com.sparta.ml;

import com.sparta.ml.exceptions.SorterLoaderException;
import com.sparta.ml.sorters.Sorter;
import com.sparta.ml.start.SortFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class SortTester {

    private static Sorter sorter;
    private int [] unsortedArray;

    @BeforeAll
    public static void chooseWhichSortingAlgorithmToTestClass() throws SorterLoaderException {
        sorter = SortFactory.getSorter(4);
        System.out.println("Testing using the " + sorter + " sorter");
    }

    @BeforeEach
    public void RandGenClassSetup() {
        Random random = new Random();
        unsortedArray = new int[10];
        for (int i = 0; i < 10; i++) {
            unsortedArray[i] = random.nextInt(100);
        }
    }

    @Test
    public void testIsSorted() {
        int[] sortedArray = sorter.sortArray(unsortedArray);
        for (int i = 0; i < sortedArray.length - 1; i++) {
            Assertions.assertTrue(sortedArray[i + 1] >= sortedArray[i]);
        }
    }

    @Test
    public void testAlreadySortedArray(){
        int[] unsortedArray = {1, 2, 3, 4, 5, 6, 7};
        int[] sortedArray = sorter.sortArray(unsortedArray);
        Assertions.assertEquals(sortedArray.length, unsortedArray.length);
        for (int i = 0; i < sortedArray.length - 1; i++){
            Assertions.assertEquals(sortedArray[i], sortedArray[i]);
        }
    }

    @Test
    public void testArrayOfSingleElement() {
        int[] unsortedArray = {7};
        int[] sortedArray = sorter.sortArray(unsortedArray);
        Assertions.assertEquals(sortedArray.length, unsortedArray.length);
        for (int i = 0; i < sortedArray.length - 1; i++){
            Assertions.assertTrue(sortedArray[i + 1] >= sortedArray[i]);
        }
    }

    @Test
    public void testArrayWithDuplicates() {
        int[] unsortedArray = {24, 27, 9, 50, 11, 14, 27, 77, 28};
        int[] sortedArray = sorter.sortArray(unsortedArray);
        System.out.println(sortedArray.length);
        System.out.println(unsortedArray.length);
        Assertions.assertEquals(sortedArray.length, unsortedArray.length);
        for (int i = 0; i < sortedArray.length - 1; i++){
            Assertions.assertTrue(sortedArray[i + 1] >= sortedArray[i]);
        }
    }

    @Test
    public void testOddLengthOfTheArray() {
        int[] unsortedArray = {24, 27, 9, 50, 11, 14, 27};
        int[] sortedArray = sorter.sortArray(unsortedArray);
        Assertions.assertEquals(sortedArray.length, unsortedArray.length);
        Assertions.assertEquals(1, sortedArray.length % 2);
        for (int i = 0; i < sortedArray.length - 1; i++){
            Assertions.assertTrue(sortedArray[i + 1] >= sortedArray[i]);

        }
    }

    @Test
    public void testLongArray() {
        int[] sortedArray = sorter.sortArray(unsortedArray);
        Assertions.assertEquals(sortedArray.length, unsortedArray.length);
        for (int i = 0; i < sortedArray.length - 1; i++){
            Assertions.assertTrue(sortedArray[i + 1] >= sortedArray[i]);
        }
    }
}
