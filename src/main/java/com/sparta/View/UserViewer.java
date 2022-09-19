package com.sparta.View;

import java.util.Arrays;

public class UserViewer {

    public void userInputPrompt() {
        System.out.println("Please select either 1, 2, 3 OR 4.");
        System.out.println("1: bubble sort\n2: Merge sort \n3: Tree sort \n4: Compare all 3 methods on the same array!");
        System.out.println("No input will result in displaying bubble sort on arrays, and then merging them");
    }

    public void userIndexPrompt() {
        System.out.println("And finally, please enter in numeric form the number of index positions you'd like");
    }

    public void userPrint(String method, int[] result) {
        System.out.println("\nYour "+ method + " array is: " + Arrays.toString(result) + ".");
    }

    public void userCompareAll(String methods, int[]... arrays) {
        System.out.println("Your unsorted array is: " + Arrays.toString(arrays[3]));
        System.out.printf("%s :", methods.substring(0, 9) + " " + Arrays.toString(arrays[0]));
        System.out.printf("\n%s :", methods.substring(10, 21) + " " + Arrays.toString(arrays[1]));
        System.out.printf("\n%s :", methods.substring(22, 32) + " " + Arrays.toString(arrays[2]));
    }

    public void incorrectEntry(String userInput) {
        System.out.printf("Incorrect entry. %s, is not a valid selection. Please select one of the following: ", userInput);
    }

    public void userInputNull() {
        System.out.println("Well, I suppose we'll need something to sort, if we're sorting something!?!");
    }

    public void timeElapsed(String method, double time) {
        System.out.printf("\nIt took %f nano seconds to %s your array!", time, method);
    }

    public void userTestArray(int[] testArr) {
        System.out.println("Your test array is: " + Arrays.toString(testArr));
    }
}
