package com.sparta.Utils;

import java.util.Arrays;
import java.util.Random;

import static com.sparta.Utils.DuplicateRemover.removeDuplicates;

public class ArrayBuilder {
    public static int[] arrayBuilder(int index) {
        Random randNum = new Random();
        int[] userTestArray = new int[index];

        for (int i = 0; i < userTestArray.length; i++) {
            userTestArray[i] = randNum.nextInt(1000000);
        }
        return userTestArray;
    }
}
