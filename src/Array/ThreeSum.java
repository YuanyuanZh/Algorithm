package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (nums == null || nums.length  < 3) return rst;
        Arrays.sort(nums);
        for (int i = 0 ; i< nums.length-2 ;i ++) {
            int j = i+1;
            int k = nums.length-1;
            while (j < k) {
                List<Integer> cur  = new ArrayList<Integer>();
                int sum = nums[i] + nums[j] + nums[k];
                if ( sum == 0) {
                    cur.add(nums[i]);
                    cur.add(nums[j]);
                    cur.add(nums[k]);
                    rst.add(cur);
                    j++;
                    k--;
                    while(j < k && nums[j-1] == nums[j]) //一定要在这里判断重复数字,不然就会超时
                        j++;
                    while(j < k && nums[k] == nums[k+1])
                        k--;
                }
                else if (sum > 0) {
                    k--;
                }
                else {
                    j++;
                }
            }
            while (i < nums.length-1 && nums[i+1] == nums[i]) {
                i++;
            }
        }
        return rst;
    }
}
