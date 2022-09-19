//package com.sparta.View;
//
//import com.sparta.Models.BubbleSorter;
//import com.sparta.Models.MergeSort;
//import com.sparta.Models.Sorter;
//import com.sparta.Models.TreeSort;
//
//import java.util.Arrays;
//
//import static com.sparta.Utils.ArrayBuilder.arrayBuilder;
//
//public class View {
//    public static void userViewer(String userInput, int index) {
//        int[] userArr = arrayBuilder(index);
//
//        if (userInput.equals("1")) {
//            Sorter bSort = new BubbleSorter();
//            System.out.println("Bubble sorted Array : " + Arrays.toString(bSort.sort(userArr)));
//        } else if (userInput.equals("2")) {
//            Sorter mSort = new MergeSort();
//            System.out.println("Merge sorted Array: " + Arrays.toString(mSort.sort(userArr)));
//        } else if (userInput.equals("3")){
//            Sorter tSort = new TreeSort();
//            System.out.println("Tree sorted Array: " + Arrays.toString(tSort.sort(userArr)));
//        } else {
//
//        }
//    }
//
//}
