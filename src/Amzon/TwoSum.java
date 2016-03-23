package Amzon;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] rst = new int[2];
        if (nums == null || nums.length < 2) return rst;
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
    // assume no duplicate in the array
    public static int count1(int[] nums, int target) {
        // corner case
        if (nums == null || nums.length < 2) return 0;
        int count = 0;
        HashSet<Integer> hash = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.contains(target - nums[i])) { count++; }
            hash.add(nums[i]);
        }
        return count;
    }

    public static void main(String[] args) {
        int [] a = {1,2,3,4};
        System.out.println(count1(a,5));
    }
}
