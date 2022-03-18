package ru.vsu.cs.suvorov_d_a;

import java.util.List;

public class InsertionSorting {
    public static List<Integer> sort(List<Integer> list) {
        if (list != null) {
            insertionSort(list);
        } else {
            throw new IllegalArgumentException("Input parameter for list to sort is null.");
        }
        return list;
    }

    private static void insertionSort(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            int current = list.get(i);
            int j = i - 1;
            while(j >= 0 && current < list.get(j)) {
                list.set(j+1, list.get(j));
                j--;
            }
            list.set(j+1, current);
        }
    }
}