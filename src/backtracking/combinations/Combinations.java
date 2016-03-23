package backtracking.combinations;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (n == 0 || k == 0) return rst;
        List<Integer> sub = new ArrayList<Integer>();
        combine(n, k, rst, sub, 1);
        return rst;
    }

    public static void combine(int n, int k, List<List<Integer>> rst, List<Integer> sub, int start) {
        if (k == 0) {
            rst.add(new ArrayList<Integer>(sub));
            return;
        }

        for (int i = start; i <= n - k + 1; i++) {
            sub.add(i);
            System.out.println(sub);
            combine(n, k - 1, rst, sub, i + 1);
            System.out.println(sub);
            sub.remove(sub.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }
}
