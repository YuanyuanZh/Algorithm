package Sort;


import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int [] a = {3,1,2,5,0};
        quickSort(a);
        System.out.print(Arrays.toString(a));
    }

    public static void quickSort (int[] array) {
        quickSort(array, 0, array.length-1);
    }

    public static void quickSort (int[] array, int left, int right) {
        if (left > right) return;
        int rp = partition(array, left, right);
        quickSort(array,left, rp-1);
        quickSort(array,rp+1,right);
    }

    private static int partition(int[] array, int left, int right) {
        int key = array[left];
        int lp = left;
        int rp = right;
        while (lp < rp) {
            while (array[rp] >= key && lp < rp) {
                rp --;
            }
            while (array[lp] <= key && lp < rp) {
                lp ++;
            }
            int tmp = array[lp];
            array[lp] = array[rp];
            array[rp] = tmp;
        }
        int tmp = array[left];
        array[left] = array[lp];
        array[lp] =  tmp;
        return lp;
    }
}
