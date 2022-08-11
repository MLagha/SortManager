package com.sparta.ml.sorters;

import com.sparta.ml.sorters.binaryTree.BinaryTree;
import com.sparta.ml.sorters.binaryTree.BinaryTreeImpl;

public class BinarySorter implements Sorter {

    @Override
    public int [] sortArray(int[] arrayToSort) {
        BinaryTree tree = new BinaryTreeImpl(arrayToSort);
        return tree.getSortedTreeAsc();
    }

    @Override
    public String toString() {
        return "Binary Tree";
    }
}
