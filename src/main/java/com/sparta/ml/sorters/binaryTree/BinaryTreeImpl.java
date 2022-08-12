package com.sparta.ml.sorters.binaryTree;

import com.sparta.ml.exceptions.ChildNotFoundException;

public class BinaryTreeImpl implements BinaryTree {

    private final Node rootNode;
    private int[] arrayToSort;
    private int index;

    public BinaryTreeImpl(final int[] array) {
        rootNode = new Node(array[0]);
        for (int i = 1; i < array.length; i++) {
            addElementToTree(array[i]);
        }
    }

    @Override
    public int getRootElement() {
        return rootNode.getValue();
    }

    @Override
    public void addElementToTree(final int element) {
        addNodeToTree(rootNode, element);
    }

    ////////////////
    @Override
    public void addElements(int[] arrayToSort) {
        int index = 1;
        addNodesToTree(arrayToSort);
    }
    ///////////////

    @Override
    public int getNumberOfElements() {
        return numberOfNodes(rootNode);
    }

    private int numberOfNodes(Node rootNode) {
        if (rootNode == null)
            return 0;
        return 1 + numberOfNodes(rootNode.getLeftChild()) + numberOfNodes(rootNode.getRightChild());
    }

    @Override public boolean findElement(final int value) {
        Node node = findNode(value);
        if(node != null) {
            try {
                getLeftChild(value);
                getRightChild(value);
            } catch (ChildNotFoundException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }

    @Override public int getLeftChild(int element) throws ChildNotFoundException {
        Node node = findNode(element);
        if(node.getLeftChild() == null) {
            throw new ChildNotFoundException("This node has no left child");
        }
            return node.getLeftChild().getValue();
    }

    @Override public int getRightChild(int element) throws ChildNotFoundException {
        Node node = findNode(element);
        if(node.getRightChild() == null) {
            throw new ChildNotFoundException("This node has no right child");
        }
        return node.getRightChild().getValue();
    }

    private Node findNode(int element) {
        Node node = rootNode;
        while(node != null) {
            if(element == node.getValue()) {
                return node;
            }
            if(element < node.getValue()) {
                node = node.getLeftChild();
            } else {
                node = node.getRightChild();
            }
        }
        return null;
    }

    private void addNodeToTree(Node node, int element) {
        if(element == node.getValue()) return;

        if(element < node.getValue()) {
            if(node.isLeftChildNull()) {
                node.setLeftChild(new Node(element));
            } else {
                addNodeToTree(node.getLeftChild(), element);
            }
        } else if(element > node.getValue()) {
            if(node.isRightChildNull()) {
                node.setRightChild(new Node(element));
            } else {
                addNodeToTree(node.getRightChild(), element);
            }
        }
    }

    private void addNodesToTree(int[] arrayToAdd) {
        int index = 1;
        Node node = rootNode;
        for(int i = 1; i < arrayToAdd.length; i++) {
            NewNodeSet:
            do {
                if (arrayToAdd[i] < node.getValue()) {
                    if (node.isLeftChildNull()) {
                        node.setLeftChild(new Node(arrayToAdd[i]));
                        i++; index++; node = rootNode;
                    } else {
                        node = node.getLeftChild();
                        continue NewNodeSet;
                    }
                } else if (arrayToAdd[i] > node.getValue()) {
                    if (node.isRightChildNull()) {
                        node.setRightChild(new Node(arrayToAdd[i]));
                        i++; index++; node = rootNode;
                    } else {
                        node = node.getRightChild();
                        continue NewNodeSet;
                    }
                } else if(arrayToAdd[i] == node.getValue()) {
                    if (node.isLeftChildNull()) {
                        node.setLeftChild(new Node(arrayToAdd[i]));
                        i++; index++; node = rootNode;
                    } else {
                        node = node.getLeftChild();
                        continue NewNodeSet;
                    }
                }
            } while(index < arrayToAdd.length);
        }
    }

/*
    @Override
    public int[] sort(int[] arrayToSort) {
        rootNode = new Node(arrayToSort[0]);
        this.arrayToSort = arrayToSort;
        addElements(arrayToSort);
        return getSortedTreeAsc();
    }
*/
    @Override
    public int[] getSortedTreeAsc() {
        int[] sortedArrayToFill = new int[arrayToSort.length];
        return sortTreeAsc(sortedArrayToFill, rootNode);
    }
    @Override
    public int[] getSortedTreeDesc() {
        int[] sortedArrayToFill = new int[arrayToSort.length];
        return sortTreeDesc(sortedArrayToFill, rootNode);
    }


    public int[] sortTreeAsc(int[] ascSortedArray, Node node) {
        if (!node.isLeftChildNull()) {
            sortTreeAsc(ascSortedArray, node.getLeftChild());
        }
        ascSortedArray[index++] = node.getValue();
        if (!node.isRightChildNull()) {
            sortTreeAsc(ascSortedArray, node.getRightChild());
        }
        return ascSortedArray;
    }

    public int[] sortTreeDesc(int[] descSortedArray, Node node) {
        if (!node.isRightChildNull()) {
            sortTreeDesc(descSortedArray, node.getRightChild());
        }
        descSortedArray[index] = node.getValue();
        index += 1;
        if (!node.isLeftChildNull()) {
            sortTreeDesc(descSortedArray, node.getLeftChild());
        }
        return descSortedArray;
    }
}
