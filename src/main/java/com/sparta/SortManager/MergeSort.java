package com.sparta.SortManager;

import com.sparta.utils.ArrayBuilder;

import java.util.Date;

public class MergeSort implements Sorter{
    public int[] sort(int[] arrayA) {
        int[] arrayB = ArrayBuilder.arrayBuilder(arrayA.length);
        int[] mergedArray = new int[arrayA.length + arrayB.length];

        int i = 0, j = 0, k = 0;
        long start = new Date().getTime();
        while (i < arrayA.length && j < arrayB.length) {
            if (arrayA[i] < arrayB[j] && arrayA[i] != arrayB[j - 1]) {
                mergedArray[k] = arrayA[i];
                i++;
                k++;
            } else {
                mergedArray[k] = arrayB[j];
                j++;
                k++;
            }
        }
        while (i < arrayA.length) {
            mergedArray[k] = arrayA[i];
            i++;
            k++;
        }

        while (j < arrayB.length) {
            mergedArray[k] = arrayB[j];
            j++;
            k++;
        }

        long end = new Date().getTime();
        System.out.println("Merging took: " + (end - start) + "ms");
        System.out.println(mergedArray.length);
        return mergedArray;
    }
}
