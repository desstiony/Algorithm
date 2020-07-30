package com.learn.sort;

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
        Comparable[] aux = new Comparable[arr.length];
        sort(arr, aux, 0, arr.length - 1);
    }

    public static void sort(Comparable[] arr, Comparable[] aux, int lo, int hi){
        // 递归终止条件
        if (lo >= hi){
            return;
        }
        // 取lo和hi的中间位置, 防止超过int最大值
        int mid = lo + (hi - lo) / 2;
        // 递归, 分而治之
        sort(arr, aux, lo, mid);
        sort(arr, aux, mid + 1, hi);
        // 合并 arr[lo .. mid] with arr[mid+1 .. hi] using aux[lo .. hi]
        merge(arr, aux, lo, mid, hi);
    }

    public static void merge(Comparable[] arr, Comparable[] aux, int lo, int mid, int hi){

    }
}
