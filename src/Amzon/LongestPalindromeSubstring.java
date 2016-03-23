package Amzon;


public class LongestPalindromeSubstring {
    //Given a string S, find the longest palindromic substring in S. You may assume that the maximum
    // length of S is 1000, and there exists one unique longest palindromic substring.
    //O(n2)
    public static String LongestPalindromeSubstring(String s) {
        if (s == null || s.length() == 0) return s;
        String rst = null;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                dp[j][i] = s.charAt(i) == s.charAt(j) && (i - j < 3 || dp[j + 1][i - 1]);
                if (dp[j][i] && (rst == null || i - j + 1 > rst.length())) {
                    rst = s.substring(j, i + 1);
                }
            }
        }
        return rst;
    }

    //Manacher O(n)
    public static String LongestPalindromeSubstring_manacher(String s) {
        String ret = preProcess(s);
        int p[] = new int[ret.length()];
        int c = 0;
        int r = 0;
        for (int i = 1; i < ret.length() - 1; i++) {
            if (i > r) p[i] = 0;
            else p[i] = Math.min(p[2 * c - i], r - i);
            while (ret.charAt(i + p[i] + 1) == ret.charAt(i - p[i] - 1))
                p[i]++;
            if (i + p[i] > r) {
                c = i;
                r = i + p[i];
            }
        }
        int max_len = 0;
        int center = 0;
        for (int j = 1; j < p.length - 1; j++) {
            if (p[j] > max_len) {
                max_len = p[j];
                center = j;
            }
        }
        return s.substring((center - 1 - max_len) / 2, (center - 1 + max_len) / 2);
    }

    public static String preProcess(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("^");
        for (int i = 0; i < s.length(); i++) {
            sb.append("#");
            sb.append(s.charAt(i));
        }
        sb.append("#$");
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(LongestPalindromeSubstring("aacaabbebba"));
        System.out.println(LongestPalindromeSubstring_manacher("aacaabbebba"));
    }

}
