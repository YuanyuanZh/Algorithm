package BitMapipulation;

public class greyCodeCheck {
// XOR INPUT	OUTPUT
//    A	B	A XOR B
//    0	0	0
//    0	1	1
//    1	0	1
//    1	1	0
//gray code : a numerical code used in computing in which consecutive integers are represented by binary numbers differing in
// only one digit.
    public static int grayCheck(byte term1, byte term2){
        byte x = (byte)(term1^term2);
        int count = 0;
        while(x!=0){
            x = (byte)(x&(x-1));
            count++;
        }
        return count == 1?1:0;
    }

    public static void main(String[] args) {
        System.out.println(grayCheck((byte)1,(byte)3));
    }
}
