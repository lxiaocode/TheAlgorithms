package com.lxiaocode.algorithms.sorts;

import java.util.Arrays;

/**
 * 选择排序：
 * 每次都会选定当前最小的元素，将其排序到左边。
 *
 * 算法分析：
 * 交换次数 N
 * 比较次数 (N-1)+(N-2)+(N-3)+...+2+1 = N(N-1)/2
 *
 * 特点：
 * 运行时间和输入无关，为了找到当前最小元素需要扫描数组。
 * 交换元素次数最少，每次交换都会确定一个元素，总共交换 N 次。
 *
 * @author lixiaofeng
 * @date 2021/3/21 下午9:26
 * @blog http://www.lxiaocode.com/
 */
public class SelectionSort {

    private SelectionSort(){}

    public static <T extends Comparable<T>> void sort(T[] array){
        for (int i = 0; i < array.length - 1; i++){
            int min = i;
            for (int j = i + 1; j < array.length; j++){
                if (less(array[j], array[min])) min = j;
            }
            exch(array, i, min);
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
        SelectionSort.sort(integers);
        System.out.println(Arrays.toString(integers));

        String[] strings = {"c", "a", "e", "b", "d"};
        SelectionSort.sort(strings);
        System.out.println(Arrays.toString(strings));
    }
}
