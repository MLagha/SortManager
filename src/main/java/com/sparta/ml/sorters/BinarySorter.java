package com.sparta.ml.sorters;

import com.sparta.ml.sorters.binaryTree.BinaryTree;
import com.sparta.ml.sorters.binaryTree.BinaryTreeImpl;

public class BinarySorter implements Sorter {
/*
    @Override
    public int[] sortArray(int[] arrays) {
        return BinaryTreeImpl(arrays);
    }
    */

    @Override
    public int [] sortArray(int[] arrays) {
        BinaryTree tree = new BinaryTreeImpl(arrays);
        return tree.getSortedTreeAsc();
    }


    @Override
    public String toString() {
        return "Binary Tree";
    }
}
