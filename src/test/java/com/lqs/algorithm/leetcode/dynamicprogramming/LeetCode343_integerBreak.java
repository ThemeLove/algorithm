package com.lqs.algorithm.leetcode.dynamicprogramming;

import org.junit.Test;

/**
 * 该题还没有完全理解，要参照题解继续多思考!!!
 * LeetCode 343 整数拆分
 * create by lqs
 * date:2024-10-28
 */
public class LeetCode343_integerBreak {

    @Test
    public void solution() {
        int ans = integerBreak(10);
        System.out.println("ans -> " + ans);
    }

    /**
     *
     * 动态规划解法
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        // dp 数组的定义
        // dp[i]表示第i个数拆分后的最大乘机，我们要求n,所以初始化数组长度为n+1,最后dp[n]即为答案
        int[] dp = new int[n+1];
        // init
        // 0 和 1 不能拆成2个数，所以初始化为0
        dp[0] = 0;
        dp[1] = 0;

        for(int i = 2; i <= n; i++) {
            for(int j = 1; j < i/2+1; j++) { // 剪枝
                // 递推公式
                dp[i] = Math.max(Math.max(j * (i - j), j * dp[i - j]), dp[i]);
            }
        }
        return dp[n];
    }
}