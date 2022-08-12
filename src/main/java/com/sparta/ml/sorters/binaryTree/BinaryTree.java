package com.sparta.ml.sorters.binaryTree;

import com.sparta.ml.exceptions.ChildNotFoundException;

public interface BinaryTree {

    int getRootElement();

    int getNumberOfElements();

    void addElementToTree(int element);

    void addElements(int[] elements);

    boolean findElement(int value) throws ChildNotFoundException;

    int getLeftChild(int element) throws ChildNotFoundException;

    int getRightChild(int element) throws ChildNotFoundException;

    int[] getSortedTreeAsc();

    int[] getSortedTreeDesc();
}