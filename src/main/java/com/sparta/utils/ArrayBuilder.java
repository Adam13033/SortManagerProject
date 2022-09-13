package com.sparta.utils;

import java.util.Random;

public class ArrayBuilder {
    public static int[] arrayBuilder(int index) {
        Random randNum = new Random();
        int[] extensiveTest = new int[index];

        for (int i = 0; i < extensiveTest.length; i++) {
            extensiveTest[i] = randNum.nextInt(10000);
        }
        return DuplicateRemover.removeDuplicates(extensiveTest);
    }
}
