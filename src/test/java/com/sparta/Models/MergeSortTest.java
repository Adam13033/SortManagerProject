package com.sparta.Models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.sparta.Utils.ArrayBuilder.arrayBuilder;
import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {
    Sorter mSort = new MergeSort();
    int[] testArr = arrayBuilder(20);
    int[] sorted = mSort.sort(testArr);

    @Test
    @DisplayName("Testing to ensure correct sorting, smallest to largest")
    void sort() {
        for (int i = 0; i < testArr.length - 1; i++) {
            Assertions.assertTrue(sorted[i] < sorted[i + 1]);
        }
    }

    @Test
    @DisplayName("Testing return type, expecting int[] (true)")
    void typeTest() {
        Assertions.assertTrue(sorted instanceof int[]);
    }

    @Test
    @DisplayName("Sorted arrays should be shorter in length following removal of duplicates")
    void duplicatesRemoved() {
        int[] testWithDups = mSort.sort(new int[]{1, 2, 2, 2, 3, 4, 4, 5, 6}); //7
        int[] testWOutDups = {1, 2, 3, 4, 5, 6};

        Assertions.assertEquals(testWOutDups.length, testWithDups.length);
    }
    @Test
    @DisplayName("Ensuring correct sort order")
    void testingSortOrder() {
        for (int i = 0; i < sorted.length; i++) {
            Assertions.assertTrue(sorted[i+1] > sorted[i]);
        }
    }

    @Test
    @DisplayName("Not Null")
    void testingInput() {
        Assertions.assertNotNull(sorted, "Not null");
    }

    @Test
    @DisplayName("Throw NullPointerException when no array is provided")
    public void throwNullPointerExceptionWhenNoArrPassed() {
        Assertions.assertThrows(NullPointerException.class,
                ()->{
                    mSort.sort(null);
                    //ex : objectName.thisMethodShoulThrowNullPointerExceptionForNullParameter(null);
                });
    }
}