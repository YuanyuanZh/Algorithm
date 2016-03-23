package BitMapipulation;


public class SingleNumberIII {
    public static int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int i:nums) {
            diff ^= i;
        }
        int t = -diff;
        diff &= t;
        int[] rst = {0,0};
        for(int j:nums){
            if ((diff & j) == 0) {
                rst[0] ^= j;
            }
            else{
                rst[1] ^= j;
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,3,5};
        int[] a = singleNumber(nums);
        System.out.println(a[0]);
        System.out.println(a[1]);
    }
}

/*
Once again, we need to use XOR to solve this problem. But this time, we need to do it in two passes:

In the first pass, we XOR all elements in the array, and get the XOR of the two numbers we need to find.
Note that since the two numbers are distinct, so there must be a set bit (that is, the bit with value '1')
in the XOR result. Find out an arbitrary set bit (for example, the rightmost set bit).

In the second pass, we divide all numbers into two groups, one with the aforementioned bit set, another with
the aforementinoed bit unset. Two different numbers we need to find must fall into thte two distrinct groups.
XOR numbers in each group, we can find a number in either group.
*/