package Amzon.OA2;


import java.util.Arrays;

public class FourInteger {
    //Given four integers,  变换他们的位置，使得，
// F(S) = abs(S[0]-S[1]) + abs(S[1]-S[2]) + abs(S[2]-S[3] ) 最大。
// 其中，S[0]，S[1]，S[2]，S[3]就是ABCD要对应的位置。
    public static int[] fourInteger(int A, int B, int C, int D) {
        int[] arr = new int[4];
        arr[0] = A;
        arr[1] = B;
        arr[2] = C;
        arr[3] = D;
        Arrays.sort(arr);//(1,2,3,4)
        swap(arr, 0, 1);//2134
        swap(arr, 2, 3);//2143
        swap(arr, 0, 3);
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
