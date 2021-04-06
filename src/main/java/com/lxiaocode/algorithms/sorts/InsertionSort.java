package com.lxiaocode.algorithms.sorts;

import java.util.Arrays;

/**
 * @author lixiaofeng
 * @date 2021/3/21 下午9:05
 * @blog http://www.lxiaocode.com/
 */
public class InsertionSort extends SortAlgorithm {
    /**
     * 禁止实例化
     */
    private InsertionSort(){}

    /**
     * 插入排序过程
     * @param array 待排序数组
     * @param <T> 元素泛型
     */
    public static <T extends Comparable<T>> void sort(T[] array){
        for (int i = 1; i < array.length; i++){
            for (int j = i; j > 0 && less(array[j], array[j-1]); j--){
                exch(array, j, j-1);
            }
            assert isSort(array, 0, i);
        }
        assert isSort(array);
    }

    /**
     * 插入排序测试用例
     * @param args
     */
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
