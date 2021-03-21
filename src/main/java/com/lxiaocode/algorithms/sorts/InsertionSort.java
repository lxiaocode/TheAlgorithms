package com.lxiaocode.algorithms.sorts;

import java.util.Arrays;

/**
 * 插入排序：
 * 假设左边的元素是已排序的，然后将右边的元素插入左边元素中适合的位置。
 *
 * 算法分析：
 * 交换次数，最坏的情况 1+2+3+...+(N-1) = N(N-1)/2; 最好的情况(已排序) 0 不需要交换; 平均的情况 N(N-1)/4
 * 比较次数，最坏的情况 1+2+3+...+(N-1) = N(N-1)/2; 最好的情况(已排序) N-1; 平均的情况 N(N-1)/4
 *
 * 特点：
 * 插入排序对于有序(或部分有序)数组效率很高; 对于存在很多相同元素的数组也很有效; 也很适合小规模数组。
 * 由此看出，插入排序的运行时间与输入有关。
 *
 * 倒置元素：
 * 倒置指的是数组中两个顺序颠倒的元素，如[2,4,3,1] 2-1、4-3、4-1、3-1
 * 插入排序中每一次交换都会消除一组倒置元素，当倒置元素为 0 这排序完成。
 * 所以插入排序的交换次数 = 倒置元素数量;
 * 倒置元素数量 <= 比较次数 <= 倒置元素数量 + 数组大小 + 1 (每次交换都会对应一次比较，还可能需要一次额外的比较)
 *
 * 优化：
 * 插入有许多优化空间，如希尔排序就是基于插入排序实现的。
 * 一种简单的优化就是，内循环中将较大的元素都向右移动而不总是交换两个元素(这样访问数组的次数就能减半)。
 *
 * @author lixiaofeng
 * @date 2021/3/21 下午9:05
 * @blog http://www.lxiaocode.com/
 */
public class InsertionSort {

    private InsertionSort(){}

    public static <T extends Comparable<T>> void sort(T[] array){
        for (int i = 1; i < array.length; i++){
            for (int j = i; j > 0 && less(array[j], array[j-1]); j--){
                exch(array, j, j-1);
            }
            assert isSort(array, 0, i);
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
        InsertionSort.sort(integers);
        System.out.println(Arrays.toString(integers));

        String[] strings = {"c", "a", "e", "b", "d"};
        InsertionSort.sort(strings);
        System.out.println(Arrays.toString(strings));
    }
}
