package com.lxiaocode.algorithms.sorts;

import java.util.Arrays;

/**
 * 插入排序 - 优化：
 * 哨兵，在插入排序开始前，先将最小的元素将其置于数组最左边。这样就能消除内循环中判断数组越界条件。
 * 不使用交换元素，在插入排序时，循环中将较大的元素都向右移动而不总是交换两个元素(这样访问数组的次数就能减半)。
 *
 * @author lixiaofeng
 * @date 2021/3/21 下午11:14
 * @blog http://www.lxiaocode.com/
 */
public class InsertionXSort {

    private InsertionXSort(){}

    public static <T extends Comparable<T>> void sort(T[] array){
        int n = array.length;
        int exchange = 0;
        for (int i = n - 1; i > 0; i--){
            if (less(array[i], array[i - 1])){
                exch(array, i, i - 1);
                exchange++;
            }
        }
        if (exchange == 0) return;

        for (int i = 2; i < n; i++){
            T v = array[i];
            int j = i;
            while (less(v, array[j - 1])){
                array[j] = array[j - 1];
                j--;
            }
            array[j] = v;
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
        InsertionXSort.sort(integers);
        System.out.println(Arrays.toString(integers));

        String[] strings = {"c", "a", "e", "b", "d"};
        InsertionXSort.sort(strings);
        System.out.println(Arrays.toString(strings));
    }
}
