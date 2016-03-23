package DP;

//https://leetcode.com/discuss/72030/share-my-dp-solution-by-state-machine-thinking

public class BestTimeBuySellStockwithCooldown {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <2) return 0;
        int [] buy = new int[2];
        int [] sell = new int[2];
        int [] rest = new int[2];
        buy[0] = -prices[0];
        sell[0] = 0;
        rest[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(rest[i-1]-prices[i],buy[i-1]);
            sell[i] = buy[i-1]+prices[i];
            rest[i] = Math.max(rest[i-1],sell[i-1]);
        }
        return Math.max(sell[1],rest[1]);
    }
//    buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
//    sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
public int maxProfit3(int[] prices) {
    int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
    for (int price : prices) {
        prev_buy = buy;
        buy = Math.max(prev_sell - price, prev_buy);
        prev_sell = sell;
        sell = Math.max(prev_buy + price, prev_sell);
    }
    return sell;
}
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length <2) return 0;
        int buy = -prices[0];
        int sell = 0;
        int rest = 0;
        for (int i = 0; i < prices.length; i++) {
            int preSold = sell;
            sell = buy +prices[i];
            buy= Math.max(rest-prices[i],buy);
            rest = Math.max(rest,preSold);
        }
        return Math.max(sell,rest);
    }

    //        https://leetcode.com/discuss/76929/o-n-java-solution-3ms
//        if (prices.length<2) return 0;
//        int buy = -prices[0], sell = 0, cooldown = 0;
//        for(int i=1; i<prices.length; i++) {
//            int temp = buy;
//            buy = Math.max(buy, cooldown-prices[i]);
//            cooldown = Math.max(sell, cooldown);
//            sell = Math.max(sell, temp+prices[i]);
//        }
//        return sell>cooldown?sell:cooldown;
}
