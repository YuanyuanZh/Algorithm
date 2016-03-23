package Palindrome;


public class LongestPalindromicSubstring {
    //Manacher’s Algorithm
    //Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000,
    // and there exists one unique longest palindromic substring.
    public static String longestPalindromeDP(String s) {
        int n = s.length();
        String res = null;

        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i <= n-1; i++) {
            for (int j = 0; j <= i; j++) {
                //j 到 i 是不是palindromic
                dp[j][i] = s.charAt(i) == s.charAt(j) && (i-j < 3 || dp[j+1][i-1]);
                if (dp[j][i] && (res == null || i-j + 1 > res.length())) {
                    res = s.substring(j, i + 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeDP("cabbadtltdc"));
    }
}
