package com.sparta.utils;

import java.util.Arrays;

public class DuplicateRemover {
    public static int[] removeDuplicates(int[] input) {
        int j = 0;
        int i = 1;
        //return if the array length is less than 2
        if(input.length < 2){
            return input;
        }
        while(i < input.length){
            if(input[i] == input[j]){
                i++;
            }else{
                System.out.println(" pre increment: " + j);
                input[++j] = input[i++];
            }
            System.out.println(j);
        }
        int[] output = new int[j + 1];
        for(int k = 0; k < output.length; k++){
            output[k] = input[k];
        }

        return output;

    }
}
