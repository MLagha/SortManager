package com.sparta.ml.display;

import com.sparta.ml.sorters.Sorter;

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

    public static ArrayList<String> getMenuItems(){
        return new ArrayList<>(Arrays.asList(
                "BubbleSorter",
                "BinarySorter",
                "MergeSorter",
                "QuickSorter"
        ));
    }

    public static void printBeforeSort (Sorter sorter, int[] arrayToSort) {
        System.out.println("Sorting using " + sorter);
        System.out.println("Before sorting:\n" + Arrays.toString(arrayToSort));
    }

    public static void printResults(Sorter sorter, int [] arrayToSort) {
        long start = System.nanoTime();
        int [] sortedArray = sorter.sortArray(arrayToSort);
        System.out.println("After sorting:\n" + Arrays.toString(sortedArray));
        long end = System.nanoTime();
        System.out.println("This taken: " + (end - start) + " nanoseconds");
    }

    public static void displaySortChoices(){
        System.out.println("Enter the number of the sorter you wish to use: ");
        for (int i = 0; i < getMenuItems().size(); i++) {
            System.out.println(i + 1 + ". " + getMenuItems().get(i));
        }
    }
}
