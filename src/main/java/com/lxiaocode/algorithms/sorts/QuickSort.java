package com.lxiaocode.algorithms.sorts;

import java.time.temporal.ValueRange;
import java.util.Arrays;

/**
 * 快速排序
 * // TODO 快速排序
 * @author lixiaofeng
 * @date 2021/3/21 下午10:56
 * @blog http://www.lxiaocode.com/
 */
public class QuickSort {

    private QuickSort(){}

    public static <T extends Comparable<T>> void sort(T[] array){
        sort(array, 0, array.length-1);
    }

    private static <T extends Comparable<T>> void sort(T[] array, int lo, int hi){
        if (lo >= hi) return;
        int k = partition(array, lo, hi);
        sort(array, lo, k-1);
        sort(array, k+1, hi);
    }

    private static <T extends Comparable<T>> int partition(T[] array, int lo, int hi){
        int i = lo; int j = hi+1;
        T v = array[lo];
        while (true){
            while (less(array[++i], v)) if (i == hi) break;
            while (less(v, array[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(array, i, j);
        }
        exch(array, lo, j);
        return j;
    }

    private static <T extends Comparable<T>> boolean less(T a, T b){
        return a.compareTo(b) < 0;
    }

    private static <T extends Comparable<T>> void exch(T[] array, int i, int j){
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static <T extends Comparable<T>> boolean isSort(T[] array){
        return isSort(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> boolean isSort(T[] array, int lo, int hi){
        for (int i = lo + 1; i <= hi; i++){
            if (less(array[i], array[i - 1])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // 测试用例

        Integer[] integers = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        QuickSort.sort(integers);
        System.out.println(Arrays.toString(integers));

        String[] strings = {"c", "a", "e", "b", "d"};
        QuickSort.sort(strings);
        System.out.println(Arrays.toString(strings));
    }
}
