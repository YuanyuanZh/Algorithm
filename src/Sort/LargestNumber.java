package Sort;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LargestNumber {
    public static String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = nums[i]+"";
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String i, String j) {
                String s1 = i+j;
                String s2 = j+i;
                return s1.compareTo(s2);
            }
        });
        if (strs[strs.length-1].charAt(0) == '0') return "0";
        String res = "";
        for (String str : strs) {
            res = str + res;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {13,5,17,9};
        System.out.println(largestNumber(a));
    }
}
