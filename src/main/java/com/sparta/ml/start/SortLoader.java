package com.sparta.ml.start;

import com.sparta.ml.display.DisplayManager;
import com.sparta.ml.exceptions.SorterLoaderException;
import com.sparta.ml.sorters.Sorter;
import com.sparta.ml.util.RandArrGen;

import java.util.Scanner;

public class SortLoader {

    private final static Scanner scanner = new Scanner(System.in);

    public static int RandArrLength;
    public static void start (){
        try {
            DisplayManager.displaySortChoices();
            int choice = scanner.nextInt();
            Sorter sorter = SortFactory.getSorter(choice);
            System.out.println("\nHow many numbers do you wish to generate?");
            int[] arrayToSort = RandArrGen.getRandomArray(scanner.nextInt());
            RandArrLength = arrayToSort.length;
            DisplayManager.printBeforeSort(sorter, arrayToSort);
            DisplayManager.printResults(sorter, arrayToSort);
        } catch (SorterLoaderException e) {
            System.out.println(e.getMessage());
            start();
        }
    }
}
