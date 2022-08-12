package com.sparta.ml;

import com.sparta.ml.sorters.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static com.sparta.ml.display.DisplayManager.printResults;

public class PerformanceTester {
    private int[] unsortedArray;
    private static int[] arrayToSort;

    @BeforeAll
    public static void RandGenClassSetup() {
        Random random = new Random();
        arrayToSort = new int[10];
        for (int i = 0; i < 10; i++) {
            arrayToSort[i] = random.nextInt(1000);
        }
    }

    @BeforeEach
    public void setup() {
        unsortedArray = arrayToSort.clone();
    }

    @Test
    public void testBinarySorter() {
        System.out.println("Your randomised numbers are: \n" + Arrays.toString(unsortedArray));
        Sorter sorter = new BinarySorter();
        long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(unsortedArray);
        long end = System.nanoTime();
        printResults(sorter, sortedArray);
    }

    @Test
    public void testBubbleSorter() {
        System.out.println("Your randomised numbers are: \n" + Arrays.toString(unsortedArray));
        Sorter sorter = new BubbleSorter();
        long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(unsortedArray);
        long end = System.nanoTime();
        printResults(sorter, sortedArray);
    }

    @Test
    public void testMergeSorter() {
        System.out.println("Your randomised numbers are: \n" + Arrays.toString(unsortedArray));
        Sorter sorter = new MergeSorter();
        long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(unsortedArray);
        long end = System.nanoTime();
        printResults(sorter, sortedArray);
    }

    @Test
    public void testQuickSorter() {
        System.out.println("Your randomised numbers are: \n" + Arrays.toString(unsortedArray));
        Sorter sorter = new QuickSorter();
        long start = System.nanoTime();
        int[] sortedArray = sorter.sortArray(unsortedArray);
        long end = System.nanoTime();
        printResults(sorter, sortedArray);
    }

}
