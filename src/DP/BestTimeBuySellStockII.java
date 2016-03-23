package DP;


public class BestTimeBuySellStockII {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int max = 0;
        int curmax = 0;
        for (int i = 1; i < prices.length; i++) {
            curmax += Math.max(prices[i] - prices[i - 1], 0);
            max = Math.max(max, curmax);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {1, 7, 4, 11};
        System.out.println(maxProfit(prices));
    }
}
