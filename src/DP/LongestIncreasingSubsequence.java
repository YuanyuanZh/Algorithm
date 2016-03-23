package DP;


public class LongestIncreasingSubsequence {
   //[10, 9, 2, 5, 3, 7, 101, 18]
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int [] dp = new int [nums.length];
        dp[0] = 1;
        for (int i = 1 ; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] ) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
        }
        int max = 1;
        for (int i = 0; i < nums.length ;i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
