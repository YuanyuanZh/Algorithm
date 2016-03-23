package Sort;


import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
    public static void main(String[] args) {
        int [] a = {3,1,2,5,0};
        selectionSort(a);
        System.out.print(Arrays.toString(a));
    }
    public static void selectionSort (int[] arr) {
        shuffle(arr);
        selectionSort(arr, 0, arr.length-1);

    }

    public static void  selectionSort(int[] arr, int lo, int hi) {
        if (lo > hi) return;
        int j = partition(arr,lo, hi);
        selectionSort(arr,lo, j-1);
        selectionSort(arr,j+1,hi);
    }

    public static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi;
        int key = a[lo];
        while (i < j) {
            while (a[j] >= key && i< j) {
                j--;
            }
            while (a[i] <= key && i < j){
                i++;
            }

            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        int tmp = a[lo];
        a[lo] = a[j];
        a[j] = tmp;
        return j;
    }

    private static void shuffle(int a[]) {

        final Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            int tmp = a[ind];
            a[ind] = a[r];
            a[r] = tmp;
        }
    }
}
