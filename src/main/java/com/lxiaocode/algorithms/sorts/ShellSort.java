package com.lxiaocode.algorithms.sorts;

import java.util.Arrays;

/**
 * 希尔排序：
 * 希尔排序基于插入排序的快速排序算法。
 * 由于插入排序对于规模小的、接近有序的数组效率更高。
 * 所以希尔排序将数组分成多个规模较小的数组使用插入排序，然后数组逐渐有序，最后使用插入排序进行排序。
 *
 * 算法分析：
 * 希尔排序的算法分析非常复杂，但是可以确定的是算法性能取决于 h。
 *
 * 特点：
 * 希尔排序将数组以 h 的间隔分为多个子数组，然后使用插入排序将 h 个子数组独立地排序。
 * 在排序之初，各个子数组都很短，排序之后子数组都是部分有序的，这两种情况都很适合插入排序。
 * 子数组的有序程度取决于 h 的递增序列，所以算法的性能取决于 h。
 * 但是有很多论文研究都无法证明某个 h 递增序列是 “最好的”。
 * 在实际应用中，代码中的递增序列(1, 4, 13, 40, 121, 364, 1093, ...)基本就足够.
 *
 * h 有序数组：
 * 希尔排序的思想就是使数组中任意间隔 h 的元素是有序的，这样的数组称为 h 有序数组。
 *
 * @author lixiaofeng
 * @date 2021/3/21 下午9:37
 * @blog http://www.lxiaocode.com/
 */
public class ShellSort {

    private ShellSort(){}

    public static <T extends Comparable<T>> void sort(T[] array){
        int n = array.length;
        int h = 1;
        while (h < n/3) h = 3 * h + 1;  // 1, 4, 13, 40, 121, 364, 1093
        while (h >= 1){
            for (int i = h; i < n; i++){
                for (int j = i; j >= h && less(array[j], array[j-h]); j -= h ){
                    exch(array, j, j-h);
                }
            }
            h /= 3;
        }
        assert isSort(array);
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
        ShellSort.sort(integers);
        System.out.println(Arrays.toString(integers));

        String[] strings = {"c", "a", "e", "b", "d"};
        ShellSort.sort(strings);
        System.out.println(Arrays.toString(strings));
    }
}
