package DP;


public class HouseRobberII {
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        if (len < 2) return nums[0];
        int[] firstRobber = new int[len + 1];
        int[] secondRobber = new int[len + 1];
        firstRobber[0] = 0;
        firstRobber[1] = nums[0];
        secondRobber[0] = 0;
        secondRobber[1] = 0;
        for (int i = 2; i <= len; i++) {
            firstRobber[i] = Math.max(firstRobber[i - 2] + nums[i - 1], firstRobber[i - 1]);
            secondRobber[i] = Math.max(secondRobber[i - 2] + nums[i - 1], secondRobber[i - 1]);
        }
        return Math.max(firstRobber[len - 1], secondRobber[len]);
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 1, 2};
        System.out.println(rob(a));

    }
}
