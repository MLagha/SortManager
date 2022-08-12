package com.sparta.ml.start;

import com.sparta.ml.display.DisplayManager;
import com.sparta.ml.exceptions.SorterLoaderException;
import com.sparta.ml.sorters.Sorter;
import com.sparta.ml.util.RandArrGen;

import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SortLoader {

    private static final Logger logger = Logger.getLogger("my logger");
    private static ConsoleHandler consoleHandler = new ConsoleHandler();

    private static final Scanner scanner = new Scanner(System.in);

    public static int RandArrLength;
    public static void start (){
        try {
            DisplayManager.displaySortChoices();
            int choice = scanner.nextInt();
            Sorter sorter = SortFactory.getSorter(choice);
            logger.log(Level.INFO, "Asking user to insert the number of ints they want to generate");
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
