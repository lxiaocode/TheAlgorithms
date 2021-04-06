package com.lxiaocode.algorithms.sorts;

import java.util.Arrays;

/**
 * @author lixiaofeng
 * @date 2021/3/21 下午11:14
 * @blog http://www.lxiaocode.com/
 */
public class InsertionXSort extends SortAlgorithm {
    /**
     * 禁止实例化
     */
    private InsertionXSort(){}

    /**
     * 插入排序优化版过程
     * @param array 待排序数组
     * @param <T> 元素泛型
     */
    public static <T extends Comparable<T>> void sort(T[] array){
        // 选择最小元素作为哨兵
        int n = array.length;
        int exchange = 0;
        for (int i = n - 1; i > 0; i--){
            if (less(array[i], array[i - 1])){
                exch(array, i, i - 1);
                exchange++;
            }
        }
        if (exchange == 0) return;
        // 不使用 exch() 方法交换元素
        for (int i = 2; i < n; i++){
            T current = array[i];
            int j = i;
            while (less(current, array[j - 1])){
                array[j] = array[j - 1];
                j--;
            }
            array[j] = current;
        }
        assert isSort(array);
    }

    /**
     * 插入排序优化版测试用例
     * @param args
     */
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
