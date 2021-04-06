package com.lxiaocode.algorithms.sorts;

import java.util.Arrays;

/**
 * @author lixiaofeng
 * @date 2021/3/21 下午9:26
 * @blog http://www.lxiaocode.com/
 */
public class SelectionSort extends SortAlgorithm {
    /**
     * 禁止实例化
     */
    private SelectionSort(){}

    /**
     * 选择排序过程
     * @param array 待排序数组
     * @param <T> 元素泛型
     */
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

    /**
     * 选择排序测试用例
     * @param args
     */
    public static void main(String[] args) {
        Integer[] integers = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        SelectionSort.sort(integers);
        System.out.println(Arrays.toString(integers));

        String[] strings = {"c", "a", "e", "b", "d"};
        SelectionSort.sort(strings);
        System.out.println(Arrays.toString(strings));
    }
}
