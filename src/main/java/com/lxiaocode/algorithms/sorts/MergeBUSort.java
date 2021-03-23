package com.lxiaocode.algorithms.sorts;

import java.util.Arrays;

/**
 * 归并排序：
 * 将一个数组分成两半分别排序，然后将结果归并起来。
 *
 * 自底向上归并排序:
 * 自底向上归并排序是归并排序的一种。
 * 将每个元素作为一个大小为 1 的数组，然后进行两两归并，然后四四归并，八八归并...
 *
 * 算法分析：
 * 比较次数，(1/2N)logN 到 NlogN
 * 访问数组次数，最多 6NlogN
 *
 * // TODO 自底向上归并排序
 * @author lixiaofeng
 * @date 2021/3/21 下午10:55
 * @blog http://www.lxiaocode.com/
 */
public class MergeBUSort {

    private MergeBUSort(){}

    private static Comparable[] aux;

    public static <T extends Comparable<T>> void sort(T[] array){
        int length = array.length;
        aux = new Comparable[length];
        for (int size = 1; size < length; size *= 2){
            for (int lo = 0; lo < length - size; lo += 2 * size){
                merge(array, lo, lo+size-1, Math.max(lo+2*size-1, length-1));
            }
        }
        assert isSort(array);
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
