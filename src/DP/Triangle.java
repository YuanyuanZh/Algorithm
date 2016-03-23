package DP;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int [] dp = new int[triangle.size()+1];
        for (int i = triangle.size()-1 ; i >= 0; i--) {
           List<Integer> level = triangle.get(i);
           for (int j = 0; j < level.size(); j++) {
               dp[j] = Math.min(dp[j],dp[j+1]) + level.get(j);
           }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        DecimalFormat dec = new DecimalFormat("#.#"); //keep one decimal
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i <4;i++){
            list.add(new ArrayList<Integer>());
        }
        list.get(0).add(2);
        list.get(1).add(3);
        list.get(1).add(4);
        list.get(2).add(6);
        list.get(2).add(5);
        list.get(2).add(7);
        list.get(3).add(4);
        list.get(3).add(1);
        list.get(3).add(8);
        list.get(3).add(3);
        System.out.println(minimumTotal(list));
    }
}
