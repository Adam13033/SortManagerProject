package com.sparta.Utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class DuplicateRemoverTest {
    DuplicateRemover testing = new DuplicateRemover();
    @Test
    void removeDuplicates() {
        int[] test = {1,2,2,3,3,4,4,5,5,5,6};
        int[] expected = {1,2,3,4,5,6};
        Assertions.assertEquals(Arrays.toString(expected), Arrays
                .toString(testing.removeDuplicates(test)));
    }
}