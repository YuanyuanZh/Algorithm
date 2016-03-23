package Amzon;


public class grayCode {
    public static int grayCheck(byte term1, byte term2){
        byte diff = (byte)(term1 ^ term2);
        int count = 0;
        while (diff != 0) {
            diff = (byte)(diff ^ (diff-1));
            count++;
        }
        return count == 1? 1:0;
    }
}
