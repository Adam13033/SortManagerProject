package com.sparta.Models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.sparta.Utils.ArrayBuilder.arrayBuilder;

class TreeSortTest {

        TreeSort tSort = new TreeSort();
        int[] testArr = arrayBuilder(20);
        int[] sorted = tSort.sort(testArr);

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
        @DisplayName("Ensuring correct sort order")
        void testingArrayBounds() {
            for (int i = 0; i < sorted.length - 1; i++) {
                Assertions.assertTrue(sorted[i+1] > sorted[i]);
            }
        }

        @Test
        @DisplayName("Not Null")
        void testingInput() {
            Assertions.assertNotNull(sorted, "Not null");
        }
}