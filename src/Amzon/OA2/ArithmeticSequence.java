package Amzon.OA2;

import java.util.Arrays;

public class ArithmeticSequence {
    public static int getLLAP(int[] A) {
        if (A == null) return 0;
        if (A.length <= 2) return A.length;
        Arrays.sort(A);
        int llap = 2;
        // Create a table and initialize all values as 2. The value of
        // DP[i][j] stores LLAP with set[i] and set[j] as first two
        // elements of AP. Only valid entries are the entries where j>i
        int[][] dp = new int[A.length][A.length];
        for (int i = 0; i < A.length; i++) {
            dp[i][A.length - 1] = 2;
        }
        for (int j = A.length - 2; j >= 0; j--) {
            int i = j - 1;
            int k = j + 1;
            while (i >= 0 && k < A.length) {
                if (A[i] + A[k] < A[j] * 2) {
                    k++;
                } else if (A[i] + A[k] > A[j] * 2) {
                    dp[i][j] = 2;
                    i--;
                } else {
                    // Found i and k for j, LLAP with i and j as first two
                    // elements is equal to LLAP with j and k as first two
                    // elements plus 1. L[j][k] must have been filled
                    // before as we run the loop from right side
                    dp[i][j] = dp[j][k] + 1;
                    llap = Math.max(llap, dp[i][j]);
                    i--;
                    k++;
                }
            }
            while (i >= 0) {
                dp[i][j] = 2;
                i--;
            }
        }
        return llap;
    }


    public static void main(String[] args) {
        int[] a = {-1, 0, 3, 4, 3, 2, 1, 1};
        int[] arr = {2, 5, 2, 3, 4, 6, 8, 10, 12, 9, 8, 7, 6, 2, 4, 8};
        int[] a1 = {-1, 1, 3, 3, 3, 2, 1, 0};
        int[] arr1 = {2, 5, 2, 3, 4, 6, 8, 10, 12, 9, 8, 7, 6, 2, 4, 8};
        System.out.println(getLLAP(a));
        System.out.println(getLLAP(arr));

    }
}
