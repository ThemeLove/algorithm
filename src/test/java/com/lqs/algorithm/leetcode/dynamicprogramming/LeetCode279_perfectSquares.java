package com.lqs.algorithm.leetcode.dynamicprogramming;

import org.junit.Test;

/**
 * LeetCode279 完全平方数
 * create by lqs
 * date:2024-11-05
 */
public class LeetCode279_perfectSquares {

    @Test
    public void solution() {
        int ans = numSquares(13);
        System.out.println("ans -> " + ans);
    }

    /**
     * 比如13 = 4 + 9; 14 = 1 + 4 + 9,该题一定是有解的，应为1的平方数为1，任何数都可以由任意个1相加组成
     *
     * 本题可以转化为完全背包问题
     * n 即为背包容量，物品即为1，2，3，4这些数的完全平方数，但平方数要小于n
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        // init
        dp[0] = 0;
        // 非0下标初始化
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        // loop 先遍历物品，再遍历背包
        for (int i = 1; i*i <= n; i++) { // 遍历物品
            for (int j = i*i; j <= n; j++) { // 遍历背包
                dp[j] = Math.min(dp[j], dp[j-i*i] + 1);
            }
        }
        return dp[n];
    }
}