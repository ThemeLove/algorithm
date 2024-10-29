package com.lqs.algorithm.leetcode.dynamicprogramming;

import org.junit.Test;

/**
 * LeetCode 70 爬楼梯
 * 本题题解和斐波那契一摸一样，唯一的区别就是初始化值略有区别
 * create by lqs
 * date:2024-10-28
 */
public class LeetCode70_climbingStairs {

    @Test
    public void solution() {
        int ans = climbStairs(8);
        System.out.println("ans -> " + ans);
    }

    /**
     * 动态规划写法
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        // 1.dp数组的定义以及下标的含义
        //   dp[i] 表示爬到第i阶的方式，dp[i]
        //  这里初始化dp数组长度为n+1, 数组下标从0开始
        int[] dps = new int[n+1];
        // init
        // dp[1] = 1, dp[2] = 2;
        dps[1] = 1;
        dps[2] = 2;
        for (int i = 3; i <= n; i++) {
            // 状态转移方程
            dps[i] = dps[i-1] + dps[i-2];
        }
        return dps[n];
     }
}