package com.sparta.utils;

import com.sparta.SortManager.BubbleSorter;
import com.sparta.SortManager.MergeSort;
import com.sparta.SortManager.Sorter;

import java.util.Arrays;
import java.util.Scanner;

public class Starter {

    public static void start() {
        Scanner input = new Scanner(System.in);

        System.out.println("Please select either 1, 2, 3 OR 4.");
        System.out.println("1: bubble sort array\n2: bubblesort ArrayList\n3: Bubble sort Arrays and then merge \n4: Compare array and ArrayList sorting");
        System.out.println("No input will result in displaying bubble sort on arrays, and then merging them");
        String userChoice = input.nextLine();
        System.out.println("And finally, please enter in numeric form the number of index positions you'd like");
        int userindex = input.nextInt();
        ArrayBuilder arr = new ArrayBuilder();
        int[] testArr = arr.arrayBuilder(userindex);
        if (userChoice.equals("1")) {
            Sorter bsort = new BubbleSorter();
            System.out.println("Bubble sorted Array : " + Arrays.toString(bsort.sort(new int[] {1,1,4,5,5})));
        } else if (userChoice.equals("2")) {
            Sorter mSort = new MergeSort();
            System.out.println("Merge sorted Array: " + Arrays.toString(mSort.sort(testArr)));
        }
    }
}
