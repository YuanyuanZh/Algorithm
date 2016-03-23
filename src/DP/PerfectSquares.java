package DP;


import java.util.List;

public class PerfectSquares {
    public static int numSquares(int n) {
        if (n <= 0) return 0;
        int i = 1;
        while (i*i < n) {
            i++;
        }
        int [] dp = new int[n+1];
        for (int j = 1; j<= n; j++) {
            int min = Integer.MAX_VALUE;
            for (int k = 1; k<=i; k++) {
                if ((j- k*k>=0) && dp[j-k*k] != -1) {
                    min = Math.min(min,dp[j-k*k] +1);
                }
            }
            dp[j] = min == Integer.MAX_VALUE ? -1: min;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(13));
    }
}
