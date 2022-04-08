package ru.vsu.cs.suvorov_d_a;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        LinkedList L = new LinkedList();

        for (int i = 0; i < 10; i++) {
            System.out.print("Пожалуйста, введите " + (i+1) + "-й элемент списка: ");
            int t = scan.nextInt();
            L.insert(i, t);
        }
        System.out.println("Данные в односвязном списке:");
        L.display();
        System.out.println("Отсортированный список:");
        InsertionSorting.insertionSort(L);
        L.display();
    }
}