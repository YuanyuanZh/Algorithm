package BitMapipulation;


public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int rst = 0;
        for (int i:nums){
            rst = rst^i;
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] num = {1,2,2,3,3};
        System.out.println(singleNumber(num));
    }
}
/*
    0^N = N
    N^N = 0
*/