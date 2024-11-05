package com.lqs.algorithm.leetcode.dynamicprogramming;

import com.lqs.algorithm.utils.ArrayUtil;
import org.junit.Test;

/**
 * LeetCode322 零钱兑换
 * create by lqs
 * date:2024-11-05
 */
public class LeetCode322_coinChange {

    @Test
    public void solution() {
        int[] coins = {1, 2 ,5};
        int ans = coinChange(coins, 11);
        System.out.println("ans -> " + ans);
    }

    /**
     * 完全背包  求组合的最少元素个数
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        // dp[j] 数组的定义：从coins任取，可重复，装满j的背包的最少元素个数
        int[] dp = new int[amount+1];
        dp[0] = 0;
        // 非0下标初始化，因为是求最小值，所以
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        // 由于是求最小个数，和排列组合无关，所以先遍历物品或者先遍历背包都可以
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
            }
        }
        return dp[amount];
    }

}