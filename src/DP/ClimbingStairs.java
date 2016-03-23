package DP;


public class ClimbingStairs {
    public static int climbStairs(int n) {
        if(n<=1) return n;
        int[] rst = new int[n];
        rst[0] = 1;
        rst[1] = 2;
        for (int i = 2 ; i< n ;i++) {
            rst[i] = rst[i-1] + rst[i-2];
        }
        return rst[n-1];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
