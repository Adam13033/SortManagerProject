package com.sparta.Models;

import com.sparta.Controller.Starter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Date;

public class TreeSort implements Sorter {
    Node root;
    private static Logger logger = LogManager.getLogger(TreeSort.class);

    public int[] sort(int[] arr) {
        if (arr != null) {
            try {
                TreeSort tree = new TreeSort();
                logger.info("New TreeSort object created");
                for (int i = 0; i < arr.length; i++) {
                    tree.insert(arr[i]);
                    logger.info(arr[i]);
                }
                System.out.println("Testing tree root" + tree.root.toString());
                return tree.sortArray(tree.root);
            } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
                logger.warn(e.getMessage());
            }
        }
        return null;
    }

    public TreeSort() {
        this.root = null;
    }

    void insert(int data) {
        int count = 0;
        Node node = new Node(data);
        System.out.println(count);
        if (root == null) root = node;
        else {
            Node traverse = root;
            Node pretrav = root;
            while (traverse != null) {
                pretrav = traverse;

                if (node.data < traverse.data ) traverse = traverse.left;
                else traverse = traverse.right;
            }
            if (node.data < pretrav.data) pretrav.left = node;
            else pretrav.right = node;
        }
    }

    public int[] sortArray(Node node) {
        // if array is null, return an arr length of 0 to assist in recursive stages
        if (node == null) return new int[0];

        //compute arrays from either side
        int[] left = sortArray(node.left);
        int[] right = sortArray(node.right);

        // Creating a new array large enough to house left and right, as well as nodes.
        int[] sortedArray = new int[right.length + left.length + 1];
        // index in for loop
        int i = 0;

        //copy left, add current node, copy right
        for (int j = 0; j < left.length; j++) {
                sortedArray[i++] = left[j];
        }
            sortedArray[i++] = node.data;
            for (int j = 0; j < right.length; j++) {

                sortedArray[i++] = right[j];
            }
        return sortedArray;
    }
}


