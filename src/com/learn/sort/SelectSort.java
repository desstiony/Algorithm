package com.learn.sort;


import static com.learn.tools.Utils.*;

public class SelectSort {
    /**
     * 选择排序,
     * 假设最小值的索引为数组的开始位置, 遍历数组, 与当前假设索引进行比较, 找出比当前最小值更小的数组索引, 然后交换位置.
     *
     * @param arr
     */
    public static void selectSort(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // 最小值的索引
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                // minPos 和 j 索引对应的值比较
                if (less(arr[j], arr[minPos])) {
                    minPos = j;
                }
            }
            exch(arr, i, minPos);
            assert isSorted(arr, 0, i);
        }
        assert isSorted(arr);
    }

    public static void main(String[] args) {
        Comparable[] arr = {2, 1, 0, 9, 4, 3, 7, 6, 8};
        selectSort(arr);
        isSorted(arr);
        show(arr);
    }
}
