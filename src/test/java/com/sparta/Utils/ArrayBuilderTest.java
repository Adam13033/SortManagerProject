package com.sparta.Utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayBuilderTest {

    @Test
    void arrayBuilderTest() {
        int index = 20;
        int[] testArr = ArrayBuilder.arrayBuilder(index);
        for (int i = 0; i < testArr.length - 1; i++) {
            Assertions.assertTrue(testArr[i] != testArr[i + 1]);
        }
    }
}