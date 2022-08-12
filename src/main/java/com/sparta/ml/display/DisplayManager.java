package com.sparta.ml.display;

import com.sparta.ml.sorters.Sorter;
import com.sparta.ml.start.SortLoader;

import java.util.ArrayList;
import java.util.Arrays;

/*
 - ```display``` - Classes that deal with printing to the console window.

### Phase 3
        - Add logging code into the Sort Manager project.
        - Set up ```log4j``` in the project and add a ```.properties``` file.
        - Create logs at different levels and fully test the resulting output.
        - Have output going to a log file created in the resources directory.
        - Ensure there are meaningful log messages added to the project and that they reflect the needs of the levels for which they are set.
*/
public class DisplayManager {

    public static void displaySortChoices(){
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
        System.out.print("\nYou chose to use " + sorter + " algorithm. ");
        System.out.println("Your " + SortLoader.RandArrLength + " randomised numbers are:\n" + Arrays.toString(arrayToSort));
    }

    public static void printResults(Sorter sorter, int [] arrayToSort) {
        long start = System.nanoTime();
        int [] sortedArray = sorter.sortArray(arrayToSort);
        System.out.println("\nSorted numbers:\n" + Arrays.toString(sortedArray));
        long end = System.nanoTime();
        System.out.println("\nSpan time: " + (end - start) + " nanoseconds");
    }

}
