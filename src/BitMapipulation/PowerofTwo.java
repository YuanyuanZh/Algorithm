package BitMapipulation;


public class PowerofTwo {
//    public static boolean isPowerOfTwo(int n) {
//        int count = 0;
//        while(n > 0) {
//            if((n & 1) == 1) {
//                count++;
//            }
//            // shift one bit
//            n = n>>1;
//        }
//        return count == 1;
//    }
    public static boolean isPowerOfTwo(int n) {
        return n>0 && (n&(n-1))==0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(8));
        System.out.println(isPowerOfTwo(6));
    }
}
