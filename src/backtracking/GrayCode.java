package backtracking;

import java.util.ArrayList;
import java.util.List;

// LC 89
// n= 2, [00,01,11,10]
// n= 3, [(000,001,011,010),(110,111,101,100)]
public class GrayCode {

    public static List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        if (n == 0) {
            ret.add(0);
            return ret;
        }

        ret = grayCode(n - 1);

        for (int i = ret.size() - 1; i >= 0; i--) {
            int num = ret.get(i);
            num += 1 << (n - 1);
            ret.add(num);
        }

        return ret;
    }

    public static void main(String[] args) {
        System.out.println(grayCode(3));
    }
}
