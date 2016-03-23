package DP;


public class BestTimeBuyAndSellStockIV {
    // [1,4,3,7,6,11]
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length <2) return 0;
        // 没有这个quickSolve 就超时了
        if (k >= prices.length/2 ) return quickSolve(prices);
        int[][] dp = new int[k+1][prices.length];
        int maxPro = 0;
        for (int i = 1; i <= k; i++ ) {
            int min = prices[0];
            for (int j = 1; j<prices.length; j++) {
                dp[i][j] = Math.max(dp[i][j-1],prices[j]-min);
                min = Math.min(min, prices[j]-dp[i-1][j]);
                maxPro = Math.max(dp[i][j],maxPro);
            }
        }
        return maxPro;
    }
    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
}
