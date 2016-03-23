package DP;

public class DecodeWays {
    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.startsWith("0")) return 0;
        if (s.length() == 1) return 1;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
//        if (Integer.valueOf(s.substring(0,2))<= 26 && Integer.valueOf(s.substring(0,2))>9) {
//            dp[2]=2;
//        }else {
//            dp[2] = 1;
//        }
        for (int i = 2; i <=s.length();i++) {
            if (s.charAt(i-1) == '0') {
                if ((s.charAt(i-2) == '0') || Integer.valueOf(s.substring(i-2,i-1))>2) {
                    dp[i] = 0;
                }else {
                    dp[i] = dp[i-2];
                }
            }
            else {
                int n = Integer.valueOf(s.substring(i-2,i));
                if (n > 9 && n<=26) {
                    dp[i] = dp[i-1]+dp[i-2];
                }
                else {
                    dp[i] = dp[i-1];
                }
            }
        }
        return dp[s.length()];

    }

    public static int numDecodings2(String s) {
        int n = s.length();
        if (n == 0 || s.startsWith("0")) {
            return 0;
        }
        int[] ways = new int[n+1];
        ways[0] = 1;
        ways[1] = 1;
        for (int i = 2; i <= n; i++) {
            int first = Integer.parseInt(s.substring(i-2, i));
            int prev = (first <= 26 && first > 9) ? ways[i-2]:0;
            int plus = (Integer.parseInt(s.substring(i-1, i)) == 0) ? 0:ways[i-1];
            ways[i] = prev + plus; // dp[n] = dp[n-1]+dp[n-2] or dp[n-2] or dp [n-1] or 0
        }
        return ways[n];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("1212"));
    }
}
