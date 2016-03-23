package DP;

import java.util.Arrays;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) return -1;
        if (amount == 0) return 0;
        int [] dp = new int[amount+1];
        dp[0] = 0;
        Arrays.sort(coins);
        for (int i = 1; i < coins[0];i++) {
            dp[i] = -1;
        }
        for (int i = coins[0]; i<= amount ;i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin > i) break;
                if (dp[i - coin] != -1) min = Math.min(min, dp[i - coin] + 1);
            }
            dp[i] = min == Integer.MAX_VALUE ? -1: min;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1};
        System.out.println(coinChange(coins,0));
    }
}
