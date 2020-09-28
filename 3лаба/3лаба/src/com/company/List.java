package com.company;

public class List<T extends Comparable<T>> {

    private Node head = null;
    private Node last = null;

    void add(String lastName, String name, String patronymic, String number) {
        if (head == null) {
            head = new Node(lastName, name, patronymic, number);
            last = head;
        } else {
            Node temp = new Node(lastName, name, patronymic, number);
            if (temp.compareTo(head) <= 0) {
                temp.next = head;
                head = temp;
            } else if (head == last) {
                head.next = temp;
                last = temp;
            } else {
                putElement(temp);
            }
        }
    }

    void putElement(Node node) {
        Node currentPrevious = head;
        Node current = head.next;
        do {
            if (node.compareTo(current) <= 0) {
                currentPrevious.next = node;
                node.next = current;
                break;
            } else if (current == last) {
                current.next = node;
                last = node;
                break;
            }
            currentPrevious = current;
        } while ((current = current.next) != null);
    }

    void searchLastName(String number) {
        Node current = head;
        boolean isCorrect = true;
        do {
            if (current.number.equals(number)) {
                System.out.println(current.number);
                isCorrect = false;
            }
        } while ((current = current.next) != null);
        if (isCorrect) {
            System.out.println("Совпадений нет.");
        }
    }

    void searchNumber(String lastName) {
        Node current = head;
        boolean isCorrect = true;
        do {
            if (current.lastName.equals(lastName)) {
                System.out.println(current.number);
                isCorrect = false;
            }
        } while ((current = current.next) != null);
        if (isCorrect) {
            System.out.println("Совпадений нет.");
        }
    }

    void show() {
        Node current = head;
        System.out.println("\t\tФамилия:\t\t\tИмя:\t\t\tОтчество:\tНомер:\t\t\t");
        System.out.println("");
        do {
            System.out.printf("%16s\t%16s%16s\t%8s", current.lastName, current.name, current.patronymic, current.number);
            System.out.println("");
        } while ((current = current.next) != null);
    }

    boolean isEmpty() {
        return head == null;
    }

    public class Node implements Comparable<Node> {
        Node next;
        String lastName;
        String number;
        String name;
        String patronymic;

        Node(String lastName, String name, String patronymic, String number) {
            this.lastName = lastName;
            this.number = number;
            this.name = name;
            this.patronymic = patronymic;
            next = null;
        }

        @Override
        public int compareTo(Node node) {
            return lastName.compareTo(node.lastName);
        }

    }
}