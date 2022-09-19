package com.sparta.SortManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.sparta.Utils.ArrayBuilder.arrayBuilder;

class BubbleSorterTest {
    BubbleSorter bsort = new BubbleSorter();
    int[] testArr = arrayBuilder(20);
    int[] sorted = bsort.sort(testArr);

    @Test
    @DisplayName("Testing to ensure correct sorting, smallest to largest")
    void sort() {
       for(int i = 0; i < testArr.length -1; i++) {
           Assertions.assertTrue(sorted[i] < sorted[i + 1]);
       }
    }

    @Test
    @DisplayName("Testing return type, expecting int[] (true)")
    void typeTest() {
        Assertions.assertTrue(sorted instanceof int[]);
    }

    @Test
    @DisplayName("Passing null as param")
    void nullInputTest() {
        Assertions.assertNull(bsort.sort(null));
    }
 }