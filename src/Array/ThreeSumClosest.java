package Array;


import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return -1;
        Arrays.sort(nums);
        int distance = Integer.MAX_VALUE;
        int rst = -1;
        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i+1;
            int hi = nums.length-1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum == target) {
                    return sum;
                }
                else if (sum > target) {
                    if (sum - target < distance) {
                        distance = sum - target;
                        rst = sum;
                    }
                    hi--;
                }
                else {
                    if (target - sum < distance) {
                        distance = target - sum;
                        rst = sum;
                    }
                    lo++;
                }
            }
        }
        return rst;
    }
}
