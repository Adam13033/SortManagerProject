package com.sparta.Utils;

import java.util.Arrays;

public class DuplicateRemover {
    public static int[] removeDuplicates(int[] input) {
        int j = 0;
        int numOfDuplicates = 0;
        //return if the array length is less than 2
        if (input.length < 2) {
            return input;
        }
        int[] temp = new int[input.length];

        for (int i = 0; i < input.length - 1; i++) {
            if (input[i] != input[i + 1]) {
                temp[j++] = input[i];
            }
        }
        temp[j++] = input[input.length - 1];
        for (int i = 0; i < j; i++) {
            input[i] = temp[i];
        }

        return Arrays.copyOfRange(temp, 0, j);
    }
}
