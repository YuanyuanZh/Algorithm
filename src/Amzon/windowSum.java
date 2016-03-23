package Amzon;


import java.util.ArrayList;
import java.util.List;

public class windowSum {
    public static List<Integer> windowSum(int[] A, int k) {
        List<Integer> res = new ArrayList<Integer>();
        if (A == null || A.length == 0 || k <= 0) return res;
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            count++;
            if (count >= k) {
                int sum = 0;
                for (int j = i; j >= i-k+1; j--) {
                    sum += A[j];
                }
                res.add(sum);
            }
        }
        return res;
    }

    public static List<Integer> getSum1(List<Integer> arr, int k) {
        List<Integer> rst = new ArrayList<Integer>();
        if (arr == null || arr.size() == 0 || k <= 0) return rst;
        int left = 0;
        int right = left + k - 1;
        while (right < arr.size()) {
            int sum = 0;
            for (int i = right; i >= left; i--) {
                sum += arr.get(i);
            }
            rst.add(sum);
            left++;
            right++;
        }
        return rst;
    }


    public static void main(String[] args) {
        int[] a = {4,2,73,11,-5};
        List<Integer> l = windowSum(a,3);
        for (Integer i : l) {
            System.out.print(i+" ");
        }
    }
}
