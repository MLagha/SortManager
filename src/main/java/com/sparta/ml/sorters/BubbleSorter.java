package com.sparta.ml.sorters;

public class BubbleSorter implements Sorter{

    @Override
    public int[] sortArray(int[] arrays) {
        return ascIterationSort(arrays);
    }

    public static int[] ascIterationSort(int[] array){

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i+1; j < array.length; j++){
                if (array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    @Override
    public String toString() {
        return "Bubble Sort";
    }
}
