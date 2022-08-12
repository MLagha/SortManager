package com.sparta.ml.sorters;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MergeSorter implements Sorter{

    private static final Logger logger = Logger.getLogger("my logger");
    private static ConsoleHandler consoleHandler = new ConsoleHandler();

    @Override
    public int[] sortArray(int[] array) {
        if (array.length <= 1) {
            logger.log(Level.INFO, "If statement for number equals 1");
            return array;
        }

        int midIndexLength = array.length / 2;
        int[] leftHalf = new int[midIndexLength];
        int[] rightHalf;
        if (array.length % 2 == 0) {
            rightHalf = new int[midIndexLength];
        } else {
            rightHalf = new int[midIndexLength + 1];
        }

        logger.log(Level.INFO, "For Loop for assigning Left Array element");
        for (int i = 0; i < midIndexLength; i++) {
            logger.log(Level.INFO, "Adding all element to Left Array until we reach mid index");
            leftHalf[i] = array[i];
        }
        logger.log(Level.INFO, "For Loop for assigning Right Array element");
        for (int j = 0; j < rightHalf.length; j++) {
            logger.log(Level.INFO, "Adding all element to Right Array until reaching mid index");
            rightHalf[j] = array[midIndexLength + j];
        }

        leftHalf = sortArray(leftHalf);
        rightHalf = sortArray(rightHalf);
        int[] result;
        result = merge(leftHalf, rightHalf);
        return result;
    }

    private static int[] merge(int[] leftHalf, int[] rightHalf) {
        int[] result = new int[leftHalf.length + rightHalf.length];
        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;

        while(leftPointer < leftHalf.length || rightPointer < rightHalf.length) {
            if(leftPointer < leftHalf.length && rightPointer < rightHalf.length) {
                if (leftHalf[leftPointer] < rightHalf[rightPointer]) {
                    result[resultPointer++] = leftHalf[leftPointer++];
                } else {
                    result[resultPointer++] = rightHalf[rightPointer++];
                }

            } else if(leftPointer < leftHalf.length) {
                result[resultPointer++] = leftHalf[leftPointer++];
            } else if (rightPointer < rightHalf.length) {
                result[resultPointer++] = rightHalf[rightPointer++];
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Merge Sort";
    }
}
