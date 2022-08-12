package com.sparta.ml.sorters;

public class MergeSorter implements Sorter{

    @Override
    public int[] sortArray(int[] array) {
        if(array.length <= 1) {
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

        for (int i = 0; i < midIndexLength; i++) {
            leftHalf[i] = array[i];
        }
        for (int j = 0; j < rightHalf.length; j++) {
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
