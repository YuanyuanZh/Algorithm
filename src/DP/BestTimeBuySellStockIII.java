package DP;

//Say you have an array for which the ith element is the price of a given stock on day i.
//Design an algorithm to find the maximum profit. You may complete at most two transactions.

public class BestTimeBuySellStockIII {

    public int maxProfit1(int[] prices) {//[1,4,3,7]
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

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <2 ) return 0;
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int i:prices){                              // Assume we only have 0 money at first
            release2 = Math.max(release2, hold2+i);     // The maximum if we've just sold 2nd stock so far.
            hold2    = Math.max(hold2,    release1-i);  // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1, hold1+i);     // The maximum if we've just sold 1nd stock so far.
            hold1    = Math.max(hold1,    -i);          // The maximum if we've just buy  1st stock so far.
        }
        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.

    }
}
