package DP;


import java.util.ArrayList;
import java.util.List;

public class UglyNumberII {
    public static int nthUglyNumber(int n) {
        if (n < 1) return 0;
        List<Integer> uglys = new ArrayList<Integer>();
        int f2 = 0;
        int f3 = 0;
        int f5 = 0;
        uglys.add(1);
        while (uglys.size()<n){
            int next = Math.min(uglys.get(f2)*2, Math.min(uglys.get(f3)*3, uglys.get(f5)*5));
            uglys.add(next);
            if (uglys.get(f2)*2 == next) f2++;
            if (uglys.get(f3)*3 == next) f3++;
            if (uglys.get(f5)*5 == next) f5++;
        }
        return uglys.get(n-1);

    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
}
