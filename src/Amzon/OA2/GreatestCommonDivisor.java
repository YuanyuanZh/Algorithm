package Amzon.OA2;


public class GreatestCommonDivisor {
    public static int gcd(int[] nums) {
        if (nums == null || nums.length == 0 || nums[0] == 0) return 0;
        if (nums.length == 1) return nums[0];
        int divisor = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) return 0;
            int divident = nums[i];
            while (divident % divisor != 0) {
                int tmp = divisor;
                divisor = divident % divisor;
                divident = tmp;
            }
        }
        return divisor;
    }

    public static void main(String[] args) {
        int[] a ={8,4,6,2};
        int[] b ={1,3,5,7};
        System.out.println(gcd(a));
        System.out.println(gcd(b));
    }
}
