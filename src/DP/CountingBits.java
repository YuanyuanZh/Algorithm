package DP;


public class CountingBits {
    public int[] countBits(int num) {
        if (num < 0) return new int[0];
        int[] dp = new int [num+1];
        if (num >= 1) {
            dp[1] = 1;
            for (int i = 2; i <= num; i++) {
                int c = i / 2;
                int m = i % 2;
                dp[i] = dp[c] + dp[m];
            }
        }
        return dp;
    }
}
