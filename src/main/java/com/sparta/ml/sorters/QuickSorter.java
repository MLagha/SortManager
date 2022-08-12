package com.sparta.ml.sorters;

import com.sparta.ml.logger.CustomFormatter;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuickSorter implements Sorter{

    private static final Logger logger = Logger.getLogger("my logger");
    private static ConsoleHandler consoleHandler = new ConsoleHandler();

    public int[] sortArray(int[] array){
        quickSort(array, 0, array.length - 1);
        return array;
    }
    private static int[] quickSort(int[] array, int begin, int end) {
        logger.log(Level.INFO, "If statement to test if the first element is smaller than the second");

        if (begin < end) {
            int partitionIndex = partition(array, begin, end);
            quickSort(array, begin, partitionIndex-1);
            quickSort(array, partitionIndex+1, end);
        }
        logger.log(Level.INFO, "Returning the Array");
        return array;
    }

    private static int partition(int array[], int begin, int end) {
        consoleHandler.setFormatter((new CustomFormatter()));
        consoleHandler.setLevel(Level.INFO);
        logger.log(Level.INFO, "Array partition started");

        int pivot = array[end];
        int i = (begin-1);
        for (int j = begin; j < end; j++) {
            logger.log(Level.INFO, "Iteration For Loop started");
            if (array[j] <= pivot) {
                logger.log(Level.INFO, "If Statement to compare Array elements");
                i++;
                int swapTemp = array[i];
                array[i] = array[j];
                array[j] = swapTemp;
            }
        }
        int swapTemp = array[i+1];
        array[i+1] = array[end];
        array[end] = swapTemp;

        logger.log(Level.INFO, "Elements swapped and returning i+1");
        return i+1;
    }

    @Override
    public String toString() {
        return "Quicksort";
    }
}
