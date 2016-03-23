package backtracking.combinations;


import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (k <= 0 || n <= 0) return rst;
        combinationSum3(rst, new ArrayList<Integer>(), k, n, 1);
        return rst;
    }

    public static void combinationSum3(List<List<Integer>> rst, List<Integer> sub, int k, int target, int start) {
        if (sub.size() == k && target == 0) {
            List<Integer> tmp = new ArrayList<Integer>(sub);
            if (!rst.contains(sub)) rst.add(tmp);
            return;
        }
        if (sub.size() > k || target < 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            sub.add(i);
            combinationSum3(rst, sub, k, target - i, i + 1);
            sub.remove(sub.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum3(3,9));
    }
}
