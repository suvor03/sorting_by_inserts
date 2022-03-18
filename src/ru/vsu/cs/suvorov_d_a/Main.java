package ru.vsu.cs.suvorov_d_a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> myList  = new ArrayList<>();
        Collections.addAll(myList, 5,4,2,3,0);

        System.out.println("Before Insertion Sort: " + myList);

        InsertionSorting.sort(myList);

        System.out.println("After Insertion Sort: " + myList);
    }
}
