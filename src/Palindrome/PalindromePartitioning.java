package Palindrome;

import java.util.ArrayList;
import java.util.List;

//backtracking
/*
Given a string s, partition s such that every substring of the partition is a palindrome.

        Return all possible palindrome partitioning of s.

        For example, given s = "aab",
        Return

        [
        ["aa","b"],
        ["a","a","b"]
        ]
*/
public class PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> rst = new ArrayList<List<String>>();
        if (s == null || s.length() == 0) return rst;
        partition(rst,new ArrayList<String>(),s,0);
        return rst;
    }

    public static void partition(List<List<String>> rst, List<String> sub, String s, int p){
        if (sub.size()>0 &&  p >= s.length()) {
            rst.add(new ArrayList<String>(sub));
            return;
        }
        for (int i = p ;i < s.length(); i++) {
            if (isp(s, p, i)) {
                sub.add(s.substring(p,i+1));
                partition(rst, sub, s, i+1);
                sub.remove(sub.size()-1);
            }
        }
    }

    public static boolean isp(String s, int l, int r) {
        if (l == r) return true;
        while (l<r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(partition("aabaa"));
    }
}
