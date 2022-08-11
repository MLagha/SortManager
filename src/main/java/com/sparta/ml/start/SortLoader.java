package com.sparta.ml.start;

import com.sparta.ml.display.DisplayManager;
import com.sparta.ml.exceptions.SorterLoaderException;
import com.sparta.ml.sorters.Sorter;
import com.sparta.ml.util.RandArrGen;

import java.util.Scanner;

public class SortLoader {

    private final static Scanner scanner = new Scanner(System.in);

    public static void start (){
        try {
            DisplayManager.displaySortChoices();
            int choice = scanner.nextInt();
            Sorter sorter = SortFactory.getSorter(choice);
            System.out.println("Please enter the size of the array you wish to generate: ");
            int[] arrayToSort = RandArrGen.getRandomArray(scanner.nextInt());
            DisplayManager.printBeforeSort(sorter, arrayToSort);
            DisplayManager.printResults(sorter, arrayToSort);
        } catch (SorterLoaderException e) {
            System.out.println(e.getMessage());
            start();
        }
    }
}
