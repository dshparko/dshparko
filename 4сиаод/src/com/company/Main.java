package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Link head = new Link();
        makeChoice(head);
    }

    public static void createAList(Link head) {
        Link secondHead = new Link();
        Link secondCurrent = secondHead;
        Link current = head;
        while (current.next != head) {
            current = current.next;
            String buffer = current.value + "";
            if (buffer.length() == 7) {
                secondCurrent.next = new Link();
                secondCurrent = secondCurrent.next;
                secondCurrent.value = current.value;
            }
        }
        printCorrectList(secondHead);
    }

    public static void makeChoice(Link head) {
        head = inputPhoneNumbers();
        System.out.println("1 - Просмотр номеров телефона\n2 - Список номеров телефонов, не включая трехзначные");
        int choice = checkCorrectInputNumber();
        switch (choice) {
            case 1:
                printList(head);
                break;
            case 2:
                createAList(head);
                break;
            default:
                System.out.println("Ошибка! Введите число в диапазоне [1;3].");
        }
    }

    public static int checkCorrectInputNumber() {
        Scanner sc = new Scanner(System.in);
        String buffer = sc.nextLine();
        int digit;
        try {
            digit = Integer.parseInt(buffer);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка! Необходимо ввести целое число.");
            digit = checkCorrectInputNumber();
        }
        return digit;
    }

    public static int checkInputNumber() {
        Scanner sc = new Scanner(System.in);
        String buffer = sc.nextLine();
        int number;
        try {
            if (buffer.length() == 3 || buffer.length() == 7) {
                number = Integer.parseInt(buffer);
            } else {
                System.out.println("Ошибка! Введите 7-ми или 3-хзначный номер телефона.");
                number = checkInputNumber();
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка! Введите 7-ми или 3-хзначный номер телефона.");
            number = checkInputNumber();
        }
        return number;
    }

    public static void insert(Link current) {
        System.out.println("Введите номер телефона.");
        Link node = new Link();
        int phoneNumber = checkInputNumber();
        node.value = phoneNumber;
        node.next = current.next;
        node.previous = current;
        current.next.previous = node;
        current.next = node;
    }

    public static Link inputPhoneNumbers() {
        Link head = new Link();
        head.next = head;
        head.previous = head;
        int choice;
        do {
            insert(head.previous);
            choice = checkCorrectInputNumber();
        } while (choice == 1);
        return head;
    }

    public static void printList(Link head) {
        Link current = head;
        System.out.println("Просмотр списка с начала:");
        while (current.next != head) {
            current = current.next;
            System.out.print(current.value + "\n");
        }
        System.out.println("Просмотр списка с конца:");
        while (current.value != 0) {
            System.out.print(current.value + "\n");
            current = current.previous;
        }
    }

    public static void printCorrectList(Link head) {
        Link current = head;
        if (current.next != null) {
            while (current.next != null) {
                current = current.next;
                System.out.print(current.value + "\n");
            }
        } else {
            System.out.println("7-мизначных номеров нет.");
        }
    }
}
