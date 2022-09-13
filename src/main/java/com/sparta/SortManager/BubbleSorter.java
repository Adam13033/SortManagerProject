package com.sparta.SortManager;

import com.sparta.utils.ArrayBuilder;

import java.util.Date;

public class BubbleSorter implements Sorter {


    @Override
    public int[] sort(int[] arr) {
        if (arr != null) {
            int placeHolder = 0;
            long start = new Date().getTime();
            for (int i = 0; i < arr.length; i++) {
                int index = i;
                for (int j = 1; j < (arr.length - i); j++) {
                    System.out.println("index: " + arr[index] + "arr j" + arr[j]);
                    System.out.println("j: " + j + "index");
                    if (arr[j - 1] > arr[j] && arr[index] != arr[j]) {
                        placeHolder = arr[j - 1];
                        arr[j - 1] = arr[j];
                        arr[j] = placeHolder;

                    }
                }
            }
            long end = new Date().getTime();
            System.out.println("Bubble sorting Array took: " + (end - start) + "ms");

        }
        return arr;
    }
}