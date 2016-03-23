package Array;

public class ProductofArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] rst = new int[len];
        if (len == 0) return rst;
        int leftMult = 1;
        for (int i = 0 ; i < len; i++) {
            rst[i] = leftMult;
            leftMult *= nums[i];
        }
        int rightMult = 1;
        for (int i = len-1; i >= 0; i--) {
            rst[i] *= rightMult;
            rightMult *= nums[i];
        }
        return rst;
    }

    public static void main(String[] args) {
        int [] array = {1,2,3,4};
        int [] s= productExceptSelf(array);
        for(int i:s) {
            System.out.println(i);
        }
    }
}
