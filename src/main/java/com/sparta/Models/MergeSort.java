package com.sparta.Models;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class MergeSort implements Sorter {
	private static Logger logger = LogManager.getLogger(MergeSort.class);

	@Override
	public int[] sort (int[] array) {
		if (array == null) {
			return null;
		}
        try {
			if (array.length > 1) {
				int mid = array.length / 2;

				// Split left part
				int[] left = new int[mid];
				for (int i = 0; i < mid; i++) {
					left[i] = array[i];
				}

				// Split right part
				int[] right = new int[array.length - mid];
                if (array.length - mid >= 0) System.arraycopy(array, mid, right, mid - mid, array.length - mid);
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
		} catch (NullPointerException e) {
			logger.trace(e.getMessage(), e);
			logger.error(e.getMessage());
		}
		logger.trace(array);
        return array;
    }
}
