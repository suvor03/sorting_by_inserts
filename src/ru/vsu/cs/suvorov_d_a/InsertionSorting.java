package ru.vsu.cs.suvorov_d_a;

public class InsertionSorting {
    public static LinkedList<Integer> insertionSort(LinkedList<Integer> list) {
        Node x1, x2, x3, x4;
        x1 = list.head.next;
        list.head.next = null;
        while (x1 != null) {
            x3 = list.head;
            x2 = list.head.next;
            while(x2!=null&&((int) x2.data)<=((int) x1.data)) {
                x3 = x2;
                x2 = x2.next;
            }
            x4 = x1.next;
            x1.next = x3.next;
            x3.next = x1;
            x1 = x4;
        }
        return list;
    }
}