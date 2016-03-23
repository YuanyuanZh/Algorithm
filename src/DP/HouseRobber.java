package DP;

public class HouseRobber {
    public static int rob(int[] nums) {
//        if (nums == null || nums.length == 0) return 0;
//        return help(nums,nums.length-1);
        int last = 0;
        int current = 0;
        int tmp;
        for (int n :nums) {
            tmp = current;
            current = Math.max(last + n, current);
            last = tmp;
        }
        return current;

    }

    public static int help(int[] nums,int end) {
        int[] rst =  new int[end+1];
        for (int i = 0; i<=end;i++){
            rst[i] = nums[i];
        }
        if(end == 0) return nums[0];
        if(end == 1) return Math.max(nums[0],nums[1]);
        return Math.max(rst[end]+help(nums,end-2),help(nums,end-1));
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        System.out.println(rob(a));
    }
}
