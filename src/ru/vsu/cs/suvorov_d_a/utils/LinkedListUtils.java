package ru.vsu.cs.suvorov_d_a.utils;

import ru.vsu.cs.suvorov_d_a.LinkedList;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.util.Scanner;

public class LinkedListUtils {
    public static <T> LinkedList<Integer> readListFromJTable(JTable table) {
        StringBuilder sb = new StringBuilder();
        TableModel tableModel = table.getModel();

        int numberOfColumns = tableModel.getColumnCount();

        for (int i = 0; i < numberOfColumns; i++) {
            sb.append(tableModel.getValueAt(0, i).toString());
            sb.append(" ");
        }

        return convertToList(sb.toString());
    }

    private static LinkedList<Integer> convertToList(String unsortedList) {
        LinkedList<Integer> sortedList = new LinkedList<>();

        if (unsortedList != null) {
            Scanner scn = new Scanner(unsortedList);
            scn.useDelimiter("(\\s|,)+");

            while (scn.hasNext())
                if (!scn.hasNextInt()) {
                    return null;
                } else {
                    sortedList.addLast(scn.nextInt());
                }
        } else {
            return null;
        }

        return sortedList;
    }
}