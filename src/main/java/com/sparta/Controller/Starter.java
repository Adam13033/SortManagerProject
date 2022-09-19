package com.sparta.Controller;

import com.sparta.Models.BubbleSorter;
import com.sparta.Models.MergeSort;
import com.sparta.Models.Sorter;
import com.sparta.Models.TreeSort;
import com.sparta.Utils.ArrayBuilder;
import com.sparta.View.UserViewer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import static com.sparta.Utils.ArrayBuilder.arrayBuilder;


public class Starter {
    private static Logger logger = LogManager.getLogger(Starter.class);
    public static void start() {
        UserViewer view = new UserViewer();
        Sorter mSort = new MergeSort();
        Sorter bSort = new BubbleSorter();
        Sorter tSort = new TreeSort();
        try {
            Scanner input = new Scanner(System.in);
            view.userInputPrompt();
            String userChoice = input.nextLine();
            view.userIndexPrompt();
            int userIndex = input.nextInt();
            int[] unmodifiedTestArr = arrayBuilder(userIndex);
            int[] testArr = unmodifiedTestArr;
            logger.trace("Tracking user input");
            logger.trace(userIndex);
            logger.info(userChoice);
            logger.info(testArr);

            if (userChoice != null && userIndex > 0 ){
                switch (userChoice) {
                    case "1" -> {
                        view.userTestArray(unmodifiedTestArr);
                        long start = System.nanoTime();
                        view.userPrint("Bubble Sort", bSort.sort(testArr));
                        long end = System.nanoTime();
                        view.timeElapsed("Bubble sort", end - start);
                        logger.info(bSort.sort(testArr));
                    }
                    case "2" -> {
                        view.userTestArray(unmodifiedTestArr);
                        long start = System.nanoTime();
                        view.userPrint("Merge sort", mSort.sort(testArr));
                        long end = System.nanoTime();
                        view.timeElapsed("Merge sort", end - start);
                        logger.info(mSort.sort(testArr));
                    }
                    case "3" -> {
                        view.userTestArray(unmodifiedTestArr);
                        long start = System.nanoTime();
                        view.userPrint("Tree sort", tSort.sort(new int[] {1,1,1,2,5,4,3,6,6,3}));
                        long end = System.nanoTime();
                        view.timeElapsed("Tree Sort", end - start);
                        logger.info(tSort.sort(testArr));
                    }
                    default -> {
                        view.userTestArray(unmodifiedTestArr);
                        long start = System.nanoTime();
                        view.userPrint("Bubble Sort", bSort.sort(testArr));
                        long end = System.nanoTime();
                        view.timeElapsed("Bubble sort", end - start);
                        start = System.nanoTime();
                        view.userPrint("Merge sort", mSort.sort(testArr));
                        end = System.nanoTime();
                        view.timeElapsed("Merge sort", end - start);
                        logger.info(mSort.sort(testArr));
                        start = System.nanoTime();
                        view.userPrint("Tree sort", tSort.sort((testArr)));
                        end = System.nanoTime();
                        view.timeElapsed("Tree Sort", end - start);
                        logger.info(tSort.sort(testArr));
                    }
                }
            } else {
                view.incorrectEntry(userChoice);
                start();
            }
        } catch (InputMismatchException e) {
            logger.error(e.getMessage(), e);
            logger.trace(e.getMessage());
        } catch (NullPointerException e) {
            logger.error(e.getMessage(), e);
            logger.trace(e.getMessage(), e);
            view.userInputNull();
        }
    }
}
