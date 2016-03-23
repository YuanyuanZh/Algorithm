package Array;


import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if (numRows <=0 ) return rst;
        List<Integer> first = new ArrayList<Integer>();
        first.add(1);
        rst.add(first);
        for (int i = 1; i < numRows; i++) {
            List<Integer> level = new ArrayList<Integer>(i+1);
            level.add(1);
            for ( int j = 1; j< i; j++) {
                level.add(j,rst.get(i-1).get(j-1)+rst.get(i-1).get(j));
            }
            level.add(1);

            rst.add(level);
        }
        return rst;
    }
}
