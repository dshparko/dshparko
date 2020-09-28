package com.company;

public class List1 {
    private Unit head;
    private Unit current;

    public void add(Unit unit) {
        if (head == null) {
            current = unit;
            head = unit;
            head.setNext(head);
            head.setPrev(head);
        } else {
            unit.setNext(head);
            unit.setPrev(head.getPrev());
            head.getPrev().setNext(unit);
            head.setPrev(unit);
        }
    }

    public Unit getHead() {
        return head;
    }

    public Unit getCurrent() {
        return current;
    }

    public void setCurrent(Unit current) {
        this.current = current;
    }
}