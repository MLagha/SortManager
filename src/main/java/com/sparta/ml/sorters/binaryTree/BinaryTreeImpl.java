package com.sparta.ml.sorters.binaryTree;

import com.sparta.ml.exceptions.ChildNotFoundException;

public class BinaryTreeImpl implements BinaryTree {
    private final Node rootNode;
    private int [] sortArrayAsc;
    private int asc;

    public BinaryTreeImpl(int elements) {
        rootNode = new Node(elements);
        this.sortArrayAsc = sortArrayAsc;
    }

    public BinaryTreeImpl(final int[] array) {
        rootNode = new Node(array[0]);
        for (int i = 1; i < array.length; i++) {
            addElementToTree(array[i]);
        }
    }

    @Override
    public void addElementToTree(final int element){
        addNodeToTree(rootNode, element);
    }

    @Override
    public void addElements(int[] elements) {
        for (int i : elements) {
            addElementToTree(i);
        }
    }

    @Override
    public boolean findElement(int value){
        Node node = findNode(value);
        if (node != null){
            return true;
        } else{
            return false;
        }
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
    @Override
    public int[] getSortedTreeAsc() {
        asc = 0;
        int [] ArrayAsc = new int[getNumberOfElements()];
        return returnArrayAsc(ArrayAsc, rootNode);
    }

    public int [] returnArrayAsc(int [] sortedArrayAsc, Node node){

        if (!node.isLeftChildNull()){
            returnArrayAsc(sortedArrayAsc, node.getLeftChild());
        }
        sortedArrayAsc[asc++] = node.getValue();

        if (!node.isRightChildNull()){
            returnArrayAsc(sortedArrayAsc, node.getRightChild());
        }

        return sortedArrayAsc;
    }

    @Override
    public int[] getSortedTreeDesc() {
        int[] sortedArray = new int[getNumberOfElements()];
        asc = 0;
        return returnDescendingTree(sortedArray, rootNode);
    }

    private int[] returnDescendingTree(int[] sortedArray, Node node) {

        if (!node.isRightChildNull()) {
            returnDescendingTree(sortedArray, node.getRightChild());
        }
        sortedArray[asc ++] = node.getValue();
        if (!node.isLeftChildNull()) {
            returnDescendingTree(sortedArray, node.getLeftChild());
        }
        return sortedArray;
    }

    private void addNodeToTree(Node node, int element){
        if (element <= node.getValue()){
            if (node.isLeftChildNull()) {
                node.setLeftChild(new Node(element));
            } else {
                addNodeToTree(node.getLeftChild(), element);
            }
        } else if (element > node.getValue()){
            if (node.isRightChildNull()){
                node.setRightChild(new Node(element));
            } else {
                addNodeToTree(node.getRightChild(), element);
            }
        }
    }

    private Node findNode(int element){
        Node node = rootNode;
        while (node != null){
            if (element == node.getValue()){
                return node;
            }
            if (element < node.getValue()){
                node = node.getLeftChild();
            } else if (element > node.getValue()){
                node = node.getRightChild();
            }
        }
        return null;
    }

    @Override
    public int getRootElement() {
        return rootNode.getValue();
    }

    @Override
    public int getNumberOfElements() {
        return numOfNodes(rootNode);
    }

    private int numOfNodes(Node rootNode){
        if (rootNode == null){
            return 0;
        }

        return 1 + numOfNodes(rootNode.getLeftChild()) + numOfNodes(rootNode.getRightChild());
    }

}