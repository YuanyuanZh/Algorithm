package Array;


import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] rst = new int[2];
        if (nums == null || nums.length == 0) return rst;
        HashMap<Integer,Integer>  hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(target- nums[i])) {
                rst[0] = hm.get(target-nums[i]) + 1;
                rst[1] = i+1;
                return rst;
            }
            if (!hm.containsKey(nums[i])) {
                hm.put(nums[i],i);
            }
        }
        return rst;
    }
}
