package com.lxiaocode.algorithms.sorts;

import java.util.Arrays;

/**
 * 冒泡排序：
 * 较小的元素随着与较大的元素交换而 “冒泡” 到顶端，较大的元素则 “下沉” 到底部。
 *
 * 算法分析：
 * 交换次数，最坏的情况 1+2+3+...+(N-1) = N(N-1)/2; 最好的情况(已排序) 0 不需要交换
 * 比较次数，1+2+3+...+(N-1) = N(N-1)/2
 *
 * @author lixiaofeng
 * @date 2021/3/21 下午10:54
 * @blog http://www.lxiaocode.com/
 */
public class BubbleSort {
    private BubbleSort(){}

    public static <T extends Comparable<T>> void sort(T[] array){
        for (int i = 0; i < array.length - 1; i++){
            for (int j = array.length-1; j > i; j--){
                if (less(array[j], array[j - 1])) exch(array, j, j - 1);
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
        BubbleSort.sort(integers);
        System.out.println(Arrays.toString(integers));

        String[] strings = {"c", "a", "e", "b", "d"};
        BubbleSort.sort(strings);
        System.out.println(Arrays.toString(strings));
    }
}
