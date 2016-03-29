package Review;


import java.util.*;

public class Solution {
    public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }

    class UndirectedGraphNode {
         int label;
         List<UndirectedGraphNode> neighbors;
         UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    }

    public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }



    public static int minCut(String s) {
        // if (s == null || s.length() <= 1) return 0;
        return helper (s);
        // return min;
    }

    public static int helper(String s) {
        if (s == null || s.length() <= 1) return 0;
        int min = s.length()-1;
        for (int i = 1; i <= s.length();i++) {
            if (isPalindrome(s.substring(0,i))) {
                min = Math.min(min, helper(s.substring(i))+1);
            }
        }
        return min;
    }
    public static boolean isPalindrome(String s) {
        if (s == null || s.length()<=1) return true;
        int i = 0; int j = s.length()-1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(minCut("ababababababababababababcbabababababababababababa"));
    }
}
