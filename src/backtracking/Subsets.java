package backtracking;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return rst;
        Arrays.sort(nums);
        helper(rst, new ArrayList<Integer>(), 0,nums);
        return rst;
    }

    public static void helper(List<List<Integer>> rst, List<Integer> each, int start, int[] n) {
        if (start <= n.length) {
            List<Integer> copy = new ArrayList<Integer>(each);
            if (!rst.contains(copy))
                rst.add(new ArrayList<Integer>(each));
        }
        for (int i = start; i < n.length; i++) {
            each.add(n[i]);
            helper(rst,each, i + 1, n);
            each.remove(each.size() - 1);
        }
    }

    public static void main(String[] args) {
        int [] a = {1,2,3};
        System.out.println(subsets(a));
    }
}
