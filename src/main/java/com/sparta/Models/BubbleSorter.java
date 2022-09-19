package com.sparta.Models;

import com.sparta.Controller.Starter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class BubbleSorter implements Sorter {
	private static Logger logger = LogManager.getLogger(BubbleSorter.class);

	@Override
	public int[] sort (int[] array) {
		try {
			if (array != null) {
				int placeHolder = 0;
				for (int i = 0; i < array.length; i++) {
					for (int j = 1; j < (array.length - i); j++) {
						if (array[j - 1] > array[j]) {
							placeHolder = array[j - 1];
							array[j - 1] = array[j];
							array[j] = placeHolder;
						}
					}
				}
            }
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
			logger.error(e.getMessage(), e);
			logger.trace(e.getMessage());
		}

        return array;
	}
}