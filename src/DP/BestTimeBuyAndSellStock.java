package DP;


public class BestTimeBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int max = 0;
        int min = prices[0];
        for (int i = 0; i< prices.length; i++) {
            if (prices[i] > min) {
                max = Math.max(prices[i] - min,max);
            }
            else {
                min = prices[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {1,7,4,11};
        System.out.println(maxProfit(prices));
    }
}
