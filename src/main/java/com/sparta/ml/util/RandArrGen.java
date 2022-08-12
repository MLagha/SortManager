package com.sparta.ml.util;

import java.util.Random;

public class RandArrGen {
    public static int[] getRandomArray(int requiredLength){
        Random randArray = new Random();

        int[] theArray = new int[requiredLength];
        for (int i = 0; i < requiredLength; i++){
            theArray[i] = randArray.nextInt(100);
        }
        return theArray;
    }
}
