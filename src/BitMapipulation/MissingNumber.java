package BitMapipulation;

/*
The basic idea is to use XOR operation. We all know that a^b^b =a, which means two xor operations with the
same number will eliminate the number and reveal the original number. In this solution, I apply XOR operation
to both the index and value of the array. In a complete array with no missing numbers, the index and value should
be perfectly corresponding( nums[index] = index), so in a missing array, what left finally is the missing number.
 */

public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int rst = 0;
        for (int i = 0 ; i <= nums.length; i++){
            if (i == nums.length) {
                rst = rst ^ i;
            }
            else {
                rst ^= i ^ nums[i];
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] a = {0,1,2,3,5,6};
        System.out.println(missingNumber(a));
    }
}

