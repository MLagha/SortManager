package com.sparta.ml.sorters;

public class BubbleSorter implements Sorter{

    //    private static Logger logger = Logger.getLogger("my Logger");
//    private static CustomHandler customHandler = new CustomHandler();
    @Override
    public int[] sortArray(int[] arrays) {
//        logger.info("Calls the method below to execute the Bubble Sort");
        return oneIterationSort(arrays);
    }
    public static int[] oneIterationSort(int[] search){
//        logger.info("Sorting has begun");
        int temp;
        for (int i = 0; i < search.length; i++) {
//            logger.info("first loop has begun");
            for ( int elememt = 0; elememt < search.length - 1; elememt++){
//                logger.info("second loop has begun");
                if (search[elememt] > search[elememt + 1]){
//                    logger.info("elements are being swapped if condition is met");
                    temp = search[elememt];
                    search[elememt] = search[elememt + 1];
                    search[elememt + 1] = temp;
                }
            }
        }
//        logger.info("returns the array search");
        return search;
    }

    @Override
    public String toString() {
        return "BubbleSort";
    }
}

/*
public class BubbleSorter implements Sorter {
    public static int[] sortArray(int[] array){

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
}
*/




/*
public class BubbleSorter implements Sorter{
    public static int[] ascendingOrder(int[] array) {
        return sortArray(array);
    }

    public int [] sortArray (int [] randomArray) {
        for (int i = 0; i < randomArray.length - 1; i++) {
            for (int j = i+1; j < randomArray.length; j++){
                if (randomArray[i] > randomArray[j]){
                    int temp = randomArray[i];
                    randomArray[i] = randomArray[j];
                    randomArray[j] = temp;
                }
            }
        }
        return randomArray;
    }
}
 */



