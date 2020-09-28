package com.company;

public class Node {
    private int st;
    private int cof;
    private Node next;

    public Node(int st, int cof) {
        this.st = st;
        this.cof = cof;
    }

    public int getSt() {
        return st;
    }


    public int getCof() {
        return cof;
    }


    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
