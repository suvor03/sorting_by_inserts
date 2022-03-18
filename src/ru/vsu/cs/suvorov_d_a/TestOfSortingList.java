package ru.vsu.cs.suvorov_d_a;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestOfSortingList {
    @Test
    public void test1() {
        List<Integer> testingInputList = new ArrayList<>();
        Collections.addAll(testingInputList, 11, 39, 5, 78, 38, 9, 10, 30, 41, 28);
        List<Integer> actualList = InsertionSorting.sort(testingInputList);
        List<Integer> correctOutputList = new ArrayList<>();
        Collections.addAll(correctOutputList, 5, 9, 10, 11, 28, 30, 38, 39, 41, 78);

        Assert.assertEquals(correctOutputList, actualList);
    }

    @Test
    public void test2() {
        List<Integer> testingInputList = new ArrayList<>();
        Collections.addAll(testingInputList, 3, 0, 0, 1, -1, 7);
        List<Integer> actualList = InsertionSorting.sort(testingInputList);
        List<Integer> correctOutputList = new ArrayList<>();
        Collections.addAll(correctOutputList, -1, 0, 0, 1, 3, 7);

        Assert.assertEquals(correctOutputList, actualList);
    }

    @Test
    public void test3() {
        List<Integer> testingInputList = new ArrayList<>();
        Collections.addAll(testingInputList, 1, 0, 1, 0, 5, 20, 10, 12);
        List<Integer> actualList = InsertionSorting.sort(testingInputList);
        List<Integer> correctOutputList = new ArrayList<>();
        Collections.addAll(correctOutputList, 0, 0, 1, 1, 5, 10, 12, 20);

        Assert.assertEquals(correctOutputList, actualList);
    }
}
