## SelectSort - 选择排序

选择排序每次都会在未排序的元素中选定当前最小的元素，并将其排序到未排序序列的左边。

```java
// less()比较元素、exch()交换元素
public static <T extends Comparable<T>> void sort(T[] array){
    for (int i = 0; i < array.length - 1; i++){
        int min = i;
        for (int j = i + 1; j < array.length; j++){
            if (less(array[j], array[min])) min = j;
        }
        exch(array, i, min);
    }
}
```

**运行时间和输入无关：** 为了找到当前最小的元素，选择排序每次都需要扫描数组。<br/>**交换元素次数最少：** 每次内循环遍历完成后都会确定一个元素并交换位置，总共需要交换 N-1 次。

> **算法分析：** 对于长度为 N 的数组，选择排序需要大约 N(N-1)/2 次比较和 N-1 次交换。
>
> **交换次数：** 每此确定一个元素都会进行一次交换元素，每次排序都需要确定 N-1 个元素（最后一个元素自然会有序）。<br/>**比较次数：** 确定第一个元素到第 N-1 个元素会进行 N-1 次到 1 次的比较，所以比较次数为：(N-1)+(N-2)+...+2+1 = N(N-1)/2 次。
