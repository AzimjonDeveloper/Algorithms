package org.example.Bst;

public class Node {
    Node (int data, Color color, Node left, Node right, Node parent) {
        this.data = data;
        this.color = color;
        this.right = right;
        this.left = left;
        this.parent = parent;
    }

    int data;
    Color color;
    Node left;
    Node right;
    Node parent;
}