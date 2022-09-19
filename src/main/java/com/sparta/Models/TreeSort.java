package com.sparta.SortManager;

import java.util.Arrays;
import java.util.Date;

public class TreeSort implements Sorter{
    Node root;

    public int[] sort(int[] arr) {
        try {
            TreeSort tree = new TreeSort();
            long start = new Date().getTime();
            for (int i = 0; i < arr.length; i++) {
                tree.insert(arr[i]);
            }
            long end = new Date().getTime();

            int[] sortedArr = tree.inorder(tree.root);
            System.out.println("Sorted ARR is: " + Arrays.toString(sortedArr));
            System.out.println("Tree sorting Array took: " + (end - start) + "ms");
            return tree.inorder(tree.root);
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("");
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("Oops! Seems somethings wrong with out Array!");
        }
        return null;
    }

    public TreeSort() {
        this.root = null;
    }

    void insert(int data) {
        System.out.println("Inside insert method: " + data);

        Node node = new Node(data);

        if (root == null) root = node;
        else {
            Node traverse = root;
            Node pretrav = root;
            while (traverse != null) {
                pretrav = traverse;

                if (node.data < traverse.data) traverse = traverse.left;
                else traverse = traverse.right;
            }
            if (node.data < pretrav.data) pretrav.left = node;
            else pretrav.right = node;
        }
    }

    int[] inorder(Node node) {
        //if nothing, return array of size 0 to simplfy recursive step
        if (node == null) return new int[0];

        //compute arrays from either side
        int[] left = inorder(node.left);
        int[] right = inorder(node.right);

        //make space for both arrays and the current node
        int[] out = new int[right.length + left.length + 1];
        int i = 0; //current index in out

        //copy left, add current node, copy right
        for (int j = 0; j < left.length; j++)
            out[i++] = left[j];
        out[i++] = node.data;
        for (int j = 0; j < right.length; j++)
            out[i++] = right[j];
        return out;
    }
}


