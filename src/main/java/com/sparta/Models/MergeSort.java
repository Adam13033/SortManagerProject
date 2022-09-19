package com.sparta.SortManager;

import com.sparta.Utils.ArrayBuilder;

import java.util.Date;

public class MergeSort implements Sorter {
    @Override
    public int[] sort(int[] array) {
        if (array == null) {
            return null;
        }

        if (array.length > 1) {
            int mid = array.length / 2;

            // Split left part
            int[] left = new int[mid];
            for (int i = 0; i < mid; i++) {
                left[i] = array[i];
            }

            // Split right part
            int[] right = new int[array.length - mid];
            for (int i = mid; i < array.length; i++) {
                right[i - mid] = array[i];
            }
            sort(left);
            sort(right);
            int i = 0;
            int j = 0;
            int k = 0;
            while (i < left.length && j < right.length) {
                if (left[i] < right[j]) {
                    array[k] = left[i];
                    i++;
                } else {
                    array[k] = right[j];
                    j++;
                }
                k++;
            }
            // Collect remaining elements
            while (i < left.length) {
                array[k] = left[i];
                i++;
                k++;
            }
            while (j < right.length) {
                array[k] = right[j];
                j++;
                k++;
            }
        }
        return array;
    }
}
