package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    static List list = new List();

    public static void main(String[] args) throws IOException {
        fillList();
        workMethod();
    }

    static void workMethod() {
        mainInstructions();
        int input;
        while((input = Integer.parseInt(inputChoice())) != 0) {
            switch (input) {
                case 0:
                    exit(0);
                case 1:
                    System.out.println("Введите фамилию, чтобы найти соответствующий номер.");
                    System.out.println(list.searchNumber(inputChoice()));
                    break;
                case 2:
                    System.out.println("Введите номер телефона, чтобы найти соответсвующую фамилию.");
                    System.out.println(list.searchLastName(inputChoice()));
                    break;
                case 3:
                    list.show();
                    break;
            }
            mainInstructions();
        }
    }

    static void mainInstructions() {
        System.out.println("Нажмите 1, если вы хотите искать по фамилии номер телефона.");
        System.out.println("Нажмите 2, если вы хотите искать номер телефона по фамилии.");
        System.out.println("Нажмите 3, если вы хотите посмотреть список.");
        System.out.println("Нажмите 0, если вы хотите завершить программу.");
    }

    static void fillList() throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("C:/Users/Lenovo/Desktop/3лаба/data.txt"));
        String line;
        String[] bufferArray;
        while((line = bf.readLine()) != null) {
            bufferArray = line.split("\\s+");
            list.add(bufferArray[0],bufferArray[1],bufferArray[2],bufferArray[3]);
        }
    }

    static String inputChoice() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

}