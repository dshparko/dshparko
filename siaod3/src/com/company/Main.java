package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Эта программа осуществляет игру 'Считалочка'.");
        enterPeople();
    }

    public static void enterPeople() {
        Link<String> head = new Link();
        Link<String> current = head;
        Scanner sc = new Scanner(System.in);
        int choice = enterNumber("Введите количество людей в кругу.");
        int i = 0;
        while (i < choice) {
            System.out.println("Введите обозначение человека.");
            current.next = new Link();
            current = current.next;
            current.value = sc.nextLine();
            i++;
        }
        printList(head);
        int number = 0;
        int buffer = enterChoice();
        while (buffer == 1) {
            if (number == 1) {
                System.out.println("Вы уже удалили всех.");
                break;
            }
            number = enterNumber("Введите k(удаляем каждого k-го).");
            printNewList(head, number);
            buffer = enterChoice();
        }
    }

    public static int enterChoice() {
        System.out.println("Хотите ли вы совершить операцию удаления? Необходимо ввести 1 в случае положительного ответа.");
        Scanner sc = new Scanner(System.in);
        int choice;
        String buffer = sc.nextLine();
        try {
            choice = Integer.parseInt(buffer);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка! Необходимо ввести 1 в случае положительного ответа.");
            choice = enterChoice();
        }
        return choice;
    }

    public static void remove(Link<String> head, String buffer) {
        Link current = head;
        while (current.next != null) {
            if (current.next.value.equals(buffer)) {
                current.next = current.next.next;
                break;
            }
            current = current.next;
        }
    }

    public static void printNewList(Link<String> head, int number) {
        int buffer = 1;
        Link<String> current = head;
        while (current.next != null) {
            current = current.next;
            if (buffer % number == 0) {
                remove(head, current.value);
            }
            buffer++;
        }
        printList(head);
    }

    public static void printList(Link<String> head) {
        Link<String> current = head;
        while (current.next != null) {
            current = current.next;
            System.out.print(current.value + "\n");
        }
    }

    public static int enterNumber(String message) {
        System.out.println(message);
        int buffer;
        Scanner sc = new Scanner(System.in);
        try {
            buffer = sc.nextInt();
            if (buffer < 1 || buffer > 64) {
                System.out.println("Ошибка!");
                buffer = enterNumber("Необходимо ввести число в диапазоне [1;64].");
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка! Введите целое число.");
            buffer = enterNumber(message);
        }
        return buffer;
    }

}
