package ru.vsu.cs.suvorov_d_a;

import ru.vsu.cs.suvorov_d_a.utils.JTableUtils;
import ru.vsu.cs.suvorov_d_a.utils.LinkedListUtils;
import ru.vsu.cs.suvorov_d_a.utils.SwingUtils;
import ru.vsu.cs.suvorov_d_a.utils.ArrayUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameMain<T> extends JFrame {
    private JPanel panelMain;
    private JScrollPane scrollPaneTableInput;
    private JTable tableInput;
    private JScrollPane scrollPaneTableOutput;
    private JTable tableOutput;
    private JButton buttonRandomInput;
    private JButton buttonExecute;


    public FrameMain() {
        this.setTitle("Task_2");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(700, 100, 300, 300);
        this.setResizable(true);
        this.pack();

        JTableUtils.initJTableForArray(tableInput, 30, false, true, false, true, 30, 30);
        JTableUtils.initJTableForArray(tableOutput, 30, false, true, false, false, 30, 30);

        tableInput.setRowHeight(30);
        tableOutput.setRowHeight(30);

        buttonRandomInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[][] matrix = ArrayUtils.createRandomIntMatrix(
                            tableInput.getRowCount(), tableInput.getColumnCount(), -50, 100);
                    JTableUtils.writeArrayToJTable(tableInput, matrix, "%d");
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        buttonExecute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    LinkedList<Integer> list = LinkedListUtils.readListFromJTable(tableInput);
                    LinkedList<Integer> List = InsertionSorting.insertionSort(list);

                    int[] resultArr = ArrayUtils.intListToArray(List);
                    JTableUtils.writeArrayToJTable(tableOutput, resultArr, "%d");
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
    }
}