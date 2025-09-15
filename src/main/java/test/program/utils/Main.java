package test.program.utils;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.ListUtils;

public class Main {
    public static void main(String[] args) {
        // Original list
        List<Integer> originalList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Partition the list into sublists of size 3
        List<List<Integer>> partitionedList = ListUtils.partition(originalList, 3);

        // Print each sublist
        for (List<Integer> sublist : partitionedList) {
            System.out.println(sublist);
        }
    }
}

