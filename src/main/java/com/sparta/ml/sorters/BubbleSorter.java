package com.sparta.ml.sorters;

import com.sparta.ml.logger.CustomFormatter;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BubbleSorter implements Sorter{

    private static final Logger logger = Logger.getLogger("my logger");
    private static ConsoleHandler consoleHandler = new ConsoleHandler();

    @Override
    public int[] sortArray(int[] arrays) {
        return ascIterationSort(arrays);
    }

    public static int[] ascIterationSort(int[] array){
        consoleHandler.setFormatter((new CustomFormatter()));
        consoleHandler.setLevel(Level.INFO);
        logger.log(Level.INFO, "Ascending sort started");

        for (int i = 0; i < array.length - 1; i++) {
            logger.log(Level.FINE, "For Loop for no. of iteration (i) is " + i);
            for (int j = i+1; j < array.length; j++){
                logger.log(Level.FINE, "For Loop for comparing array elements" + i + "and " + j);
                if (array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            logger.log(Level.FINE, "For Loop for no. of iteration ends");
        }
        return array;
    }

    @Override
    public String toString() {
        return "Bubble Sort";
    }
}
