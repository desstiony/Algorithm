package com.learn.sort;

import static com.learn.tools.Utils.*;

public class MergeSort {
    /**
     * 归并排序, 分而治之, 一个数组拆分为N个部分, 再合并排序号的数据
     *
     * 递推公式:
     * merge_sort(p...q) -> merge_sort(p...r) && merge(r+1...q)
     *
     * 终止条件:
     * p >= q
     *
     * 伪代码:
     * merge_sort(A){
     *     // 调用递归函数
     *     merge_sort_c(A, 0, A.length - 1)
     * }
     *
     * sort(A, p, q){
     *     // 终止条件
     *     if p >= q when return
     *     r = (p + q) / 2
     *     sort(A, p, r)
     *     sort(A, r+1, q)
     *     merge(A[p, q], A[p, r], A[r+1, q))
     * }
     *
     * @param arr
     */
    public static void mergeSort(Comparable[] arr){
        // 申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
        Comparable[] aux = new Comparable[arr.length];
        mergeSortRecursive(arr, aux, 0, arr.length - 1);
    }

    public static void mergeSortRecursive(Comparable[] arr, Comparable[] aux, int lo, int hi){
        // 递归终止条件
        if (lo >= hi){
            return;
        }
        // 取lo和hi的中间位置, 防止超过int最大值
        int mid = lo + (hi - lo) / 2;
        // int min = (hi-lo) >> 1 + lo;

        // 递归, 分而治之
        mergeSortRecursive(arr, aux, lo, mid);
        mergeSortRecursive(arr, aux, mid + 1, hi);

        // 合并 arr[lo .. mid] with arr[mid+1 .. hi] using aux[lo .. hi]
        merge(arr, aux, lo, mid, hi);
    }

    public static void merge(Comparable[] arr, Comparable[] aux, int lo, int mid, int hi){
        // for(int k = lo; k < hi-1; k++){
        //     aux[k] = arr[k];
        // }
        // i j 为两个已经排序序列的起始位置
        int i = lo, j = mid + 1;
        int k = lo;
        // 比较两个i j 所对应的元素，选择相对小的元素放入到合并空间，并移动到下一位置
        while (i <= mid && j <= hi){
            // arr[j] < arr[i]
            if (less(arr[i], arr[j])){
                aux[k++] = arr[i++];
            }else {
                aux[k++] = arr[j++];
            }
        }

        // 比较剩余的
        while (i <= mid){
            aux[k++] = arr[i++];
        }

        while (j <= hi){
            aux[k++] = arr[j++];
        }

        for (k = lo; k <= hi; k++){
            arr[k] = aux[k];
        }
    }

    public static void main(String[] args) {
        Comparable[] arr = {2, 1, 0, 9, 4, 3, 7, 6, 8};
        mergeSort(arr);
        isSorted(arr);
        show(arr);
    }
}
