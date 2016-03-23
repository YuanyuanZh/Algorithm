package Array;

public class TwoSumII {
    public static int[] twoSum(int[] nums, int target) {
        int[] rst = new int[2];
        if (nums == null || nums.length == 0) return rst;
        int i = 0;
        int j = nums.length -1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                rst[0] = i+1;
                rst[1] = j+1;
                return rst;
            }
            else if (sum < target) {
                i++;
            }
            else {
                j--;
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        int [] a = {3, 5, 6, 7,9,10};
        for (int i = 0; i< 2; i++) {
            System.out.println(twoSum(a,12)[i]);
        }
    }
}
