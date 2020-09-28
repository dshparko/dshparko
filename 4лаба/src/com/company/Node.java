package com.company;

public class Node {
    private int number;
    private Node next;

    public Node(int number){
        this.number = number;
    }
    public int getNumber() {
        return number;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}