package com.lxiaocode.algorithms.sorts;

import java.util.Arrays;

/**
 * 归并排序：
 * 将一个数组分成两半分别排序，然后将结果归并起来。
 *
 * 自顶向下归并排序:
 * 自顶向下归并排序是归并排序的一种。
 * 从整个数组开始，将数组分成两半进行排序，然后使用归并方法将两个有序的数组归并为一个有序的数组。
 * 对于子数组也如此，从而实现递归归并。
 *
 * 算法分析：
 * 比较次数，最坏的情况，C(n) = C(n/2) + C(n/2) + N，最好的情况，C(n) = C(n/2) + C(n/2) + N/2
 * 右边的第一项是指：左半边的数组排序所需的比较次数。
 * 右边的第二项是指：右半边的数组排序所需的比较次数。
 * 右边的第三项是指：归并左右两个数组所需的比较次数。
 * 当 N = 2^n 时，自顶向下归并排序需要 (1/2N)logN 到 NlogN 次比较。
 * 访问数组次数，(6N)logN
 *
 * 优化：
 * 1. 对小规模数组使用插入排序
 *
 * // TODO 自顶向下归并排序
 * @author lixiaofeng
 * @date 2021/3/21 下午10:54
 * @blog http://www.lxiaocode.com/
 */
public class MergeSort {

    private MergeSort(){}

    private static Comparable[] aux;

    public static <T extends Comparable<T>> void sort(T[] array){
        aux = new Comparable[array.length];
        sort(array, 0, array.length-1);
        assert isSort(array);
    }

    private static <T extends Comparable<T>> void sort(T[] array, int lo, int hi){
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(array, 0, mid);
        sort(array, mid + 1, hi);
        merge(array, lo, mid, hi);
    }

    private static <T extends Comparable<T>> void merge(T[] array, int lo, int mid, int hi){
        int i = lo;
        int j = mid + 1;
        System.arraycopy(array, 0, aux, 0, array.length);
        for (int k = lo; k <= hi; k++){
            if (i > mid){
                array[k] = (T) aux[j++];
            }
            else if (j > hi){
                array[k] = (T) aux[i++];
            }
            else if (less(array[i], array[j])){
                array[k] = (T) aux[i++];
            }else {
                array[k] = (T) aux[j++];
            }
        }
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
        MergeSort.sort(integers);
        System.out.println(Arrays.toString(integers));

        String[] strings = {"c", "a", "e", "b", "d"};
        MergeSort.sort(strings);
        System.out.println(Arrays.toString(strings));
    }
}
