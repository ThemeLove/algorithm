package com.lqs.algorithm.kamacoder.dynamicprogramming;

import org.junit.Test;

/**
 * KamaCode57 爬楼梯进阶版
 * https://kamacoder.com/problempage.php?pid=1067
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬至多m (1 <= m < n)个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 * create by lqs
 * date:2024-11-05
 */
public class KamaCode57_climbingStairs {

    @Test
    public void solution() {
        int ans = climbStairs(2, 3); // 3
        System.out.println("ans -> " + ans);
    }

    /**
     * 分析题意其实是完全背包求排列数
     * 动态规划一维数组解法
     * @param m
     * @param n
     * @return
     */
    public int climbStairs(int m, int n) {
        int[] dp = new int[n+1];

        // init
        dp[0] = 1;
        for (int j = 0; j <= n; j++) {
            for (int i = 1; i <= m; i++) {
                if (j >= i) {
                    dp[j] += dp[j-i];
                }
            }

        }
        return dp[n];
    }

}