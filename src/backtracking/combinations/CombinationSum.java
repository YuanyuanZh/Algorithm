package backtracking.combinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) return rst;
        Arrays.sort(candidates);
        combinationSum(candidates,rst,new ArrayList<Integer>(),0,target,0);
        return rst;
    }

    public static void combinationSum(int[] candidates,List<List<Integer>> rst,List<Integer> sub,int sum, int target,int start) {
        if (sum == target) {
            rst.add(new ArrayList<Integer>(sub));
            return;
        }
        if (sum > target ) return;
        for (int i = start; i < candidates.length;i++ ) {
            sub.add(candidates[i]);
            combinationSum(candidates,rst,sub,sum + candidates[i],target,i);
            sub.remove(sub.size()-1);

        }
    }

    public static void main(String[] args) {
        int [] a = {10,1,2,7,6,1,5};
        System.out.println(combinationSum(a,8));
    }

}
