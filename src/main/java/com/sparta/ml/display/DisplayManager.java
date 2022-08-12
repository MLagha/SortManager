package com.sparta.ml.display;

import com.sparta.ml.sorters.Sorter;
import com.sparta.ml.start.SortLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DisplayManager {
    private static final Logger logger = Logger.getLogger("my logger");
    private static ConsoleHandler consoleHandler = new ConsoleHandler();
    public static void displaySortChoices(){
        logger.log(Level.INFO, "Asking user to choose the sorting algorithm");
        System.out.println("Which of the following sorting algorithms do you wish to use? ");
        for (int i = 0; i < getMenuItems().size(); i++) {
            System.out.println(i + 1 + ". " + getMenuItems().get(i));
        }
    }
    public static ArrayList<String> getMenuItems(){
        return new ArrayList<>(Arrays.asList(
                "Bubble Sort",
                "Binary Tree Sort",
                "Merge Sort",
                "Quick Sort"
        ));
    }

    public static void printBeforeSort (Sorter sorter, int[] arrayToSort) {
        logger.log(Level.INFO, "Printing out the randomly generated numbers");
        System.out.println("\nYour " + SortLoader.RandArrLength + " randomised numbers are:\n" + Arrays.toString(arrayToSort));
    }

    public static void printResults(Sorter sorter, int [] arrayToSort) {
        long start = System.nanoTime();
        int [] sortedArray = sorter.sortArray(arrayToSort);
        logger.log(Level.INFO, "Printing out the chosen sorting algorithm type and the sorted numbers");
        System.out.print("\nYou chose to use " + sorter + " algorithm. ");
        System.out.println("Your sorted numbers are:\n" + Arrays.toString(sortedArray));
        long end = System.nanoTime();
        logger.log(Level.INFO, "Printing out the time spent in sorting the numbers using the chosen sorting algorithm");
        System.out.println("\nSpan time: " + (end - start) + " nanoseconds");
    }
}
