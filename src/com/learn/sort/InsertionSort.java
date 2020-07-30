package com.learn.sort;

import static com.learn.tools.Utils.*;

public class InsertionSort {
    public static void insertionSort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && less(arr[j], arr[j - 1]); j--) {
                exch(arr, j, j - 1);
            }
            show(arr);
            assert isSorted(arr, 0, i);
        }
        assert isSorted(arr);
    }


    public static void main(String[] args) {
        Comparable[] arr = {2, 1, 0, 9, 4, 3, 7, 6, 8};
        insertionSort(arr);
        show(arr);
    }
}