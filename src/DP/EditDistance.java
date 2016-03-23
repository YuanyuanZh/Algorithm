package DP;


public class EditDistance {
    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 == 0) return len2;
        if (len2 == 0) return len1;
        int [][] dp = new int[len1+1][len2+1];
        for (int i = 0 ; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int j = 0; j <= len1; j++) {
            dp[j][0] = j;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int cost = (word1.charAt(i-1) == word2.charAt(j-1))? 0: 1;
                dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1])+1,dp[i-1][j-1] + cost);
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("cat", "cars"));
    }
}
