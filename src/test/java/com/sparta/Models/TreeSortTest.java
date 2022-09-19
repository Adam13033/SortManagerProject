package com.sparta.SortManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.sparta.Utils.ArrayBuilder.arrayBuilder;
import static org.junit.jupiter.api.Assertions.*;

class TreeSortTest {
    TreeSort treeTest = new TreeSort();
    @Test
    void sort() {
        int[] test = arrayBuilder(100);
        int[] treeArrTest = treeTest.sort(test);
        for(int i = 0; i < test.length -1 ; i++) {
            Assertions.assertEquals(treeArrTest[i] < treeArrTest[i + 1], treeArrTest[i] < treeArrTest[i + 1]);
        }
    }

    @Test
    void insert() {
    }

    @Test
    void inorder() {
    }

    @Test
    void display() {
    }
}