package DP;


public class BestTimeBuyStockK {
    public int maxProfit(int[] prices, int k) {
        if (prices == null || prices.length <2) return 0;
        int[][] dp = new int[3][prices.length];
        int maxPro = 0;
        for (int i = 1; i <= 2; i++ ) {
            int min = prices[0];
            for (int j = 1; j<prices.length; j++) {
                dp[i][j] = Math.max(dp[i][j-1],prices[j]-min);
                min = Math.min(min, prices[j]-dp[i-1][j]);
                maxPro = Math.max(dp[i][j],maxPro);
            }

        }
        return maxPro;
    }
}
