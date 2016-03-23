package DP;

public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int rst = nums[0];
        int min = rst;
        int max = rst;
        for (int i = 1; i< nums.length; i++) {
            if (nums[i] >= 0) {
                max = Math.max(nums[i], max*nums[i]);
                min = Math.min(nums[i], min*nums[i]);
            }
            else {
                int t = max;
                max = Math.max(nums[i], min*nums[i]);
                min = Math.min(nums[i], t*nums[i]);
            }
            rst = Math.max(rst,max);
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] a = {3,-1,4};
        System.out.println(maxProduct(a));
    }
}
