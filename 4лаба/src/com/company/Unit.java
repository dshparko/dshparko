package com.company;

public class Unit {
    private int number;
    private Unit next;
    private Unit prev;

    public Unit(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Unit getNext() {
        return next;
    }

    public void setNext(Unit next) {
        this.next = next;
    }

    public Unit getPrev() {
        return prev;
    }

    public void setPrev(Unit prev) {
        this.prev = prev;
    }
}