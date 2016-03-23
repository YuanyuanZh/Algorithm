package Sort;


import java.util.Arrays;

//Θ(n + k)
public class CountingSort {
    private final int maxValue;

    public CountingSort(int maxValue) {
        this.maxValue = maxValue;
    }

    public void sort(int[] values) {
        int[] counts = new int[maxValue+1];
        for (int i = 0; i < values.length; i++) {
            counts[values[i]]++;
        }


        for (int i = 1; i < counts.length; i++) {
            counts[i] = counts[i] + counts[i-1];
        }

        int[] B = new int[values.length];
        for (int i = values.length-1; i >= 0; i--) {
            B[counts[values[i]]-1] = values[i];
            counts[values[i]]--;
        }

        for (int i = 0; i < values.length; i++) {
            values[i] = B[i];
        }
    }

    public static void main(String[] args) {
        CountingSort countingSort = new CountingSort(9);
        int [] a = {3,1,2,4,2,2,9,1,6};
        countingSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
