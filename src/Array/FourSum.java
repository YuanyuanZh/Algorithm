package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) return rst;
        Arrays.sort(nums);
        for (int i = 0 ; i < nums.length -3 ; i++) {
            for (int j = i+1; j < nums.length -2; j++) {
                int k = j+1;
                int r = nums.length-1;
                while (k < r) {
                    int sum = nums[i] +nums[j] +nums[k] +nums[r];
                    if (sum == target) {
                        List<Integer> cur = new ArrayList<Integer>();
                        cur.add(nums[i]);
                        cur.add(nums[j]);
                        cur.add(nums[k]);
                        cur.add(nums[r]);
                        if(!rst.contains(cur))
                            rst.add(cur);
                        k++;
                        r--;
                    }
                    else if (sum > target) {
                        r--;
                    }
                    else {
                        k++;
                    }
                }
            }
        }
        return rst;
    }
}
