package BitMapipulation;


public class reverseBit {
    public static int reverseBits(int n) {
        int rst = 0;
        for (int i = 31; i>=0; i--) {
            if ((n & 1) == 1){
                rst = rst + (1<< i);
            }
            n = n>>1;
        }
        return rst;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(14));
    }
}
