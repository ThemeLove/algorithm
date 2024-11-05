package com.lqs.algorithm.leetcode.dynamicprogramming;

import com.lqs.algorithm.utils.ArrayUtil;
import org.junit.Test;

/**
 * LeetCode 518 零钱兑换II
 * create by lqs
 * date:2024-11-05
 */
public class LeetCode518_coinChangeII {

    @Test
    public void solution() {
        int[] nums = {1, 2, 5}; // 4
        int ans = change(5, nums);
        System.out.println("ans -> " + ans);
    }

    /**
     * 完全背包问题：求组合数
     * 一维数组解法
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        // 从coins中任选，可重复，正好装满amount的组合数
        int[] dp = new int[amount+1];

        //init, 1 < coins[i] < 5000, coins 如果有0的话初始化不一样，如果coins[0] = 0, 对于dp[0] 来说有放和不放两种，这里其实不用考虑这种情况
        dp[0] = coins[0] == 0 ? 2 : 1;

        // loop
        // 先遍历物品，再遍历背包，才是求的组合数
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = dp[j] + dp[j-coins[i]];
            }
            ArrayUtil.printArr(dp);
        }
        // 先遍历背包，再遍历物品，求的是排列数
        /*for (int j = 0; j <= amount; j++) {
            for (int  i = 0; i < coins.length; i++) {
                if (j >= coins[i]) {
                    dp[j] = dp[j] + dp[j-coins[i]];
                }
            }
            ArrayUtil.printArr(dp);
        }*/
        return dp[amount];
    }
}