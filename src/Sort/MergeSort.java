package Sort;

import java.util.*;

//O(nlogn)
public class MergeSort
{
    public static void main(String[] args)
    {
        int[] a = {6, 2, 5, 3, 1, 7, 4, 9};
        mergeSort(a);
//        System.out.println(Arrays.toString(a));
    }
    public static void mergeSort(int[] arr) {
        int len = arr.length;
        int[] reg = new int[len];
        merge_sort_recursive(arr, reg, 0, len - 1);
    }
    static void merge_sort_recursive(int[] arr, int[] reg, int start, int end) {
        if (start >= end)
            return;
        int len = end - start, mid = (len >> 1) + start;
        int start1 = start;
        int start2 = mid + 1;
        merge_sort_recursive(arr, reg, start1, mid);
        merge_sort_recursive(arr, reg, start2, end);
        int k = start;
        while (start1 <= mid && start2 <= end)
            reg[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        while (start1 <= mid)
            reg[k++] = arr[start1++];
        while (start2 <= end)
            reg[k++] = arr[start2++];
        System.out.println(Arrays.toString(reg));
        for (k = start; k <= end; k++)
            arr[k] = reg[k];
    }


}