package DP;


public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int max = nums[0];
        int last,now = max;

        for (int i=1; i<nums.length; i++) {
            last = now;
            now = Math.max(last+nums[i],nums[i]);
            max = Math.max(now,max);
        }
        return max;
    }

    public static int maxProfit(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(a));
    }
}
