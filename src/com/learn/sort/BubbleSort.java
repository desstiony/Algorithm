package com.learn.sort;

import static com.learn.tools.Utils.*;

public class BubbleSort {
    public static void bubbleSort(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // is arr[j] < arr[j+1]
                if (less(arr[j + 1], arr[j])) {
                    exch(arr, j, j + 1);
                    show(arr);
                    // 表示有数据交换
                    flag = true;
                    assert isSorted(arr, 0, i);
                }
            }
            // 没有数据交换, 提前退出
            if (!flag) break;
        }
        assert isSorted(arr);
    }

    public static void main(String[] args) {
        Comparable[] arr = {2, 1, 0, 9, 4, 3, 7, 6, 8};
        bubbleSort(arr);
        isSorted(arr);
        show(arr);
    }
}
