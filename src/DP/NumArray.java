package DP;

//LC 303
public class NumArray {
    private int[] dp;

    public NumArray(int[] nums) {
        this.dp = nums;
        for (int i = 1; i< nums.length;i++) {
            dp[i] += dp[i-1];
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) return dp[j];
        return dp[j] - dp[i-1];
    }

    public static void main(String[] args) {
        int[] a = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(a);
        System.out.println(numArray.sumRange(2,5));
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
